-- 코드를 입력하세요
SELECT DOCTOR.DR_NAME, DOCTOR.DR_ID, DOCTOR.MCDP_CD, DATE_FORMAT(DOCTOR.HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE DOCTOR.MCDP_CD = 'CS' OR DOCTOR.MCDP_CD = 'GS'
ORDER BY DOCTOR.HIRE_YMD DESC, DOCTOR.DR_NAME