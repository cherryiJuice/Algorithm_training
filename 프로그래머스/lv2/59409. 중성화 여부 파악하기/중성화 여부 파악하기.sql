-- 코드를 입력하세요
SELECT animal_id, name, 
        if(locate('Intact', SEX_UPON_INTAKE),"X","O")
from animal_ins
order by animal_id