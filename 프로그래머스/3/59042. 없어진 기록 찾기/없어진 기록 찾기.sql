-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.name
from ANIMAL_INS i
right join ANIMAL_OUTS o 
on i.ANIMAL_ID = o.ANIMAL_ID
where i.animal_id is null
order by ANIMAL_ID