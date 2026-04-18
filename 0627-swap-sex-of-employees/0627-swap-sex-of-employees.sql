# Write your MySQL query statement below

-- 2 types of format of CASE is below
update Salary
set sex = case
  when sex = 'm' then 'f'
  else 'm'
end;

-- update Salary
-- set sex = case sex
--   when 'm' then 'f'
--   else 'm'
-- end;
