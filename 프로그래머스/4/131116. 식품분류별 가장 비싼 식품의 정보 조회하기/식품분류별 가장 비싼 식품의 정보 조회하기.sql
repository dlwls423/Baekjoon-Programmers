-- 코드를 입력하세요
SELECT
    f.CATEGORY,
    f.PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM
    FOOD_PRODUCT f JOIN 
    (
        SELECT
            CATEGORY, 
            MAX(PRICE) AS PRICE
        FROM
            FOOD_PRODUCT
        WHERE
            CATEGORY IN ('과자', '국', '김치', '식용유')
        GROUP BY
            CATEGORY
    ) f2
    ON f.PRICE = f2.PRICE
    AND f.CATEGORY = f2.CATEGORY
ORDER BY
    MAX_PRICE DESC
