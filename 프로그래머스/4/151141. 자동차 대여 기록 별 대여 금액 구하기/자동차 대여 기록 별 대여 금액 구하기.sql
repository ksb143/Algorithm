-- 코드를 입력하세요
SELECT
    H.HISTORY_ID,
    FLOOR(C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE) + 1) *
    (1 - IFNULL(
        CASE
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN DP90.DISCOUNT_RATE
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN DP30.DISCOUNT_RATE
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN DP7.DISCOUNT_RATE
            ELSE 0
        END, 0) / 100)
    ) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
JOIN CAR_RENTAL_COMPANY_CAR C ON H.CAR_ID = C.CAR_ID
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP7 ON C.CAR_TYPE = DP7.CAR_TYPE AND DP7.DURATION_TYPE = '7일 이상'
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP30 ON C.CAR_TYPE = DP30.CAR_TYPE AND DP30.DURATION_TYPE = '30일 이상'
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP90 ON C.CAR_TYPE = DP90.CAR_TYPE AND DP90.DURATION_TYPE = '90일 이상'
WHERE C.CAR_TYPE = '트럭'
ORDER BY FEE DESC, H.HISTORY_ID DESC;