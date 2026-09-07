with tables as (
    select distinct customer_id,product_key from Customer
)
select customer_id from tables
group by customer_id
having count(*) = (select count(*) from Product)