-- 코드를 입력하세요
WITH m AS (
    SELECT 
        MEMBER_ID,
        MEMBER_NAME
    FROM
        MEMBER_PROFILE
), r AS (
    SELECT
        MEMBER_ID,
        COUNT(REVIEW_ID) AS TOTAL_REVIEW
    FROM
        REST_REVIEW
    GROUP BY
        MEMBER_ID
)

SELECT
    MEMBER_NAME,
    REVIEW_TEXT,
    DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM
    m JOIN r
    ON m.MEMBER_ID = r.MEMBER_ID
    JOIN
    REST_REVIEW rr
    ON r.MEMBER_ID = rr.MEMBER_ID
WHERE
    TOTAL_REVIEW =
    (
        SELECT 
            MAX(TOTAL_REVIEW)
        FROM 
            r
    )
ORDER BY
    REVIEW_DATE,
    REVIEW_TEXT