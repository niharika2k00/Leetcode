# Write your MySQL query statement below

-- total_order_times -> total number of times a person ordered
-- displayed the total num of order done by a customer

-- select customer_number, Count(*) as total_order_times from Orders
-- group by customer_number

select customer_number from Orders
group by customer_number
order by Count(*) DESC
limit 1;
