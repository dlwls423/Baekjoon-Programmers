-- 코드를 입력하세요
SELECT
    ANIMAL_ID,
    ANIMAL_TYPE,
    NAME
FROM
    ANIMAL_OUTS
WHERE
    ANIMAL_ID IN
    (
        SELECT
            ANIMAL_ID
        FROM
            ANIMAL_INS
        WHERE
            SEX_UPON_INTAKE LIKE 'Intact%'
    ) AND
    ANIMAL_ID IN
    (
        SELECT
            ANIMAL_ID
        FROM
            ANIMAL_OUTS
        WHERE
            SEX_UPON_OUTCOME LIKE 'Spayed%' OR
            SEX_UPON_OUTCOME LIKE 'Neutered%'
    )