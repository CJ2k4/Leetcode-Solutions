# Write your MySQL query statement below
# saleid, year -> primary
# product_id -> foreign

select p.product_name, s.year, s.price from product p join sales s on s.product_id = p.product_id;