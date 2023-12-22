-- 코드를 입력하세요
WITH TB_P AS (
    SELECT 
        PT_NO,
        PT_NAME
    FROM
        PATIENT
), TB_D AS (
    SELECT
        DR_ID,
        DR_NAME
    FROM
        DOCTOR
), TB_A AS (
    SELECT 
        APNT_YMD,
        APNT_NO,
        PT_NO,
        MCDP_CD,
        MDDR_ID
    FROM
        APPOINTMENT
    WHERE
        DATE_FORMAT(APNT_YMD, '%Y-%m-%d') = '2022-04-13'
        AND
        MCDP_CD = 'CS'
        AND
        APNT_CNCL_YN = 'N'
)

SELECT
    APNT_NO,
    PT_NAME,
    TB_P.PT_NO,
    MCDP_CD,
    DR_NAME,
    APNT_YMD
    # DATE_FORMAT(APNT_YMD, '%Y-%m-%d %T.%f') AS APNT_YMD
FROM
    TB_A 
    JOIN TB_D
    ON TB_A.MDDR_ID = TB_D.DR_ID
    JOIN TB_P
    ON TB_A.PT_NO = TB_P.PT_NO
ORDER BY
    APNT_YMD
    