-- 코드를 입력하세요
SELECT 
    count(USER_ID) AS 'USERS'
FROM
    USER_INFO
WHERE 
    AGE >= 20 AND AGE <= 29
    AND 
    LEFT(JOINED,4) = '2021'