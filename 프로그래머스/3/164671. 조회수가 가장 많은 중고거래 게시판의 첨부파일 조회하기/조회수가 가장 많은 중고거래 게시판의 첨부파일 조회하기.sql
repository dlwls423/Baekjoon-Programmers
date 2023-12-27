-- 코드를 입력하세요
SELECT
    CONCAT('/home/grep/src/', u.BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM
    USED_GOODS_FILE u
    JOIN
    (
        SELECT
            BOARD_ID,
            VIEWS
        FROM
            USED_GOODS_BOARD 
    ) b
    ON u.BOARD_ID = b.BOARD_ID
WHERE
    VIEWS IN
    (
        SELECT 
            MAX(VIEWS)
        FROM
            USED_GOODS_BOARD
    )
ORDER BY
    FILE_ID DESC