-- 코드를 입력하세요
SELECT 
    r.FOOD_TYPE,
    REST_ID,
    REST_NAME,
    r.FAVORITES
FROM
    REST_INFO r 
    JOIN (
        SELECT 
            FOOD_TYPE, 
            MAX(FAVORITES) AS FAVORITES
        FROM
            REST_INFO
        GROUP BY
            FOOD_TYPE
    ) f
    ON r.FOOD_TYPE = f.FOOD_TYPE
    AND r.FAVORITES = f.FAVORITES
ORDER BY
    FOOD_TYPE DESC