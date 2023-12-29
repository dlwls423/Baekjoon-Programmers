-- 코드를 입력하세요
SELECT
    TITLE,
    u1.BOARD_ID,
    REPLY_ID,
    u2.WRITER_ID,
    u2.CONTENTS,
    DATE_FORMAT(u2.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM
    (
        SELECT
            BOARD_ID, TITLE
        FROM
            USED_GOODS_BOARD
        WHERE
            CREATED_DATE >= '2022-10-01'
            AND
            CREATED_DATE < '2022-11-01'
    ) u1
    JOIN
    USED_GOODS_REPLY u2
    ON u1.BOARD_ID = u2.BOARD_ID
ORDER BY
    CREATED_DATE,
    TITLE
    