# Write your MySQL query statement below

-- Approach 1
-- In the subquery we're getting the max salary for x branch
select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e 
inner join Department d
on e.departmentId = d.id
where (e.departmentId, e.salary) in (
  select e.departmentId, MAX(e.salary)
  from Employee e
  group by e.departmentId
)

-- Approach 2
-- select d.name as Department, e.name as Employee, e.salary as Salary
-- from Employee e 
-- inner join Department d
-- on e.departmentId = d.id
-- where e.salary = (
--   select MAX(e.salary)
--   from Employee e
--   where e.departmentId = d.id
-- )
