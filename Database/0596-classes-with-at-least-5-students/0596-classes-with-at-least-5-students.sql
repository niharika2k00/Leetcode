# Write your MySQL query statement below

-- select class, count(*) as totalstudent from Courses
-- group by class

select class from Courses
group by class
having count(*) >= 5
-- order by count(*) 

