-- 코드를 입력하세요
SELECT I.ANIMAL_TYPE, COUNT(I.ANIMAL_ID) AS COUNT
FROM ANIMAL_INS I
WHERE I.ANIMAL_TYPE IN ('Cat', 'Dog')
GROUP BY I.ANIMAL_TYPE
ORDER BY I.ANIMAL_TYPE