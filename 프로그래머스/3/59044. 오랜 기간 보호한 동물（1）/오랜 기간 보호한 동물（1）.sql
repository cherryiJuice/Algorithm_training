-- 코드를 입력하세요
SELECT i.name, i.DATETIME
from ANIMAL_INS i
where not exists(
    select 1
    from ANIMAL_OUTS o
    where i.animal_id = o.animal_id
)
order by i.DATETIME
limit 3