# Write your MySQL query statement below

-- find employee bonus < 1000 OR NO bonus 
select e.name, b.bonus from Employee e
left join Bonus b
on e.empId = b.empId -- also contains the null bonus
where b.bonus < 1000 or b.bonus is NULL;
