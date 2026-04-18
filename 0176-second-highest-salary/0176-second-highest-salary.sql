-- Write your PostgreSQL query statement below

select (
  select distinct salary
  from Employee
  order by salary DESC
  limit 1 offset 1
) as SecondHighestSalary
