-- 코드를 입력하세요
SELECT distinct first_half.flavor from first_half
join ICECREAM_INFO on ICECREAM_INFO.flavor = first_half.flavor
where first_half.total_order >= 3000 
and ICECREAM_INFO.INGREDIENT_TYPE = "fruit_based"
order by first_half.total_order desc