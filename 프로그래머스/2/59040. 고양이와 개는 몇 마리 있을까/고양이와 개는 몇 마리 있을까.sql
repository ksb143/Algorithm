-- 코드를 입력하세요
SELECT I.ANIMAL_TYPE, COUNT(ANIMAL_ID) AS COUNT
FROM ANIMAL_INS I
GROUP BY I.ANIMAL_TYPE
ORDER BY I.ANIMAL_TYPE;