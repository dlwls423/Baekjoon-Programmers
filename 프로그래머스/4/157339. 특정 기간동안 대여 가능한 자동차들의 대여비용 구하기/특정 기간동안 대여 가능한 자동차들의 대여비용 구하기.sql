-- 코드를 입력하세요
WITH t1 AS (
    SELECT
        CAR_ID, 
        CAR_TYPE, 
        DAILY_FEE
    FROM
        CAR_RENTAL_COMPANY_CAR
    WHERE
        CAR_TYPE IN ('세단', 'SUV')
), t2 AS (
    SELECT
        CAR_ID, MAX(END_DATE) AS MAX_DAY
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    GROUP BY
        CAR_ID
    HAVING
        MAX(END_DATE) >= '2022-11-04'
), t3 AS (
    SELECT
        CAR_TYPE,
        CAST(REPLACE(DISCOUNT_RATE, '%', '') AS UNSIGNED) AS DISCOUNT_RATE
    FROM
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE
        REPLACE(DURATION_TYPE, '일 이상', '') = '30'
)

SELECT
    CAR_ID,
    t1.CAR_TYPE,
    CAST(DAILY_FEE * 0.01 * (100 -  DISCOUNT_RATE) * 30 AS UNSIGNED) AS FEE 
FROM
    t1 JOIN t3
    ON t1.CAR_TYPE = t3.CAR_TYPE
WHERE
    CAR_ID NOT IN 
    (
        SELECT 
            CAR_ID
        FROM 
            t2
    )
HAVING
    FEE >= 500000
    AND
    FEE < 2000000
ORDER BY
    FEE DESC,
    CAR_TYPE,
    CAR_ID DESC
    
    
