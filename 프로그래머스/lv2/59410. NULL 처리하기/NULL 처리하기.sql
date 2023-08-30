-- 코드를 입력하세요
SELECT ANIMAL_TYPE, if(name is null,"No name",name), SEX_UPON_INTAKE
from animal_ins
order by animal_id