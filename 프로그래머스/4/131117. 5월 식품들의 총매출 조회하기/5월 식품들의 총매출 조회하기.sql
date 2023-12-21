-- 코드를 입력하세요
SELECT
    a.PRODUCT_ID,
    PRODUCT_NAME,
    PRICE * AMOUNT AS TOTAL_SALES
FROM
    (
        SELECT
            PRODUCT_ID,
            PRODUCT_NAME,
            PRICE
        FROM
            FOOD_PRODUCT 
    ) a JOIN
    (
        SELECT
            PRODUCT_ID,
            SUM(AMOUNT) AS AMOUNT
        FROM
            FOOD_ORDER
        WHERE
            DATE_FORMAT(PRODUCE_DATE, '%Y-%m') = '2022-05'
        GROUP BY
            PRODUCT_ID
    ) b
    ON a.PRODUCT_ID = b.PRODUCT_ID
ORDER BY
    TOTAL_SALES DESC,
    PRODUCT_ID
