-- 코드를 입력하세요
SELECT f.product_id, f.product_name, 
        f.price * sum(w.amount) as total_sales
from food_product f join FOOD_ORDER w
on f.product_id = w.product_id

where year(PRODUCE_DATE) = 2022
and month(PRODUCE_DATE) = 5

group by w.product_id
order by total_sales desc, product_id;