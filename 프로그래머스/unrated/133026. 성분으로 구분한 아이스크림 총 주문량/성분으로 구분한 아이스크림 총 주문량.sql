-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, sum(f.total_order) as TOTAL_ORDER
from FIRST_HALF f, ICECREAM_INFO i
where f.flavor = i.flavor
group by INGREDIENT_TYPE
order by `TOTAL_ORDER`