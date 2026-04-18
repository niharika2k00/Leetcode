# Write your MySQL query statement below

-- Inner subquery returns the largest single number, but incase of null it prints empty. Hence wrapped in select.
select (
  select num from MyNumbers
  group by num
  having count(num) = 1
  order by num DESC
  limit 1
) as num;

-- When MAX(num) + GROUP BY is used, then => each group has 1 distinct value, so MAX is useless here.
-- SELECT MAX(num) as num
-- FROM (
--   SELECT num
--   FROM mynumbers
--   GROUP BY num
--   HAVING COUNT(*)=1
-- ) as newset;

-- SELECT MAX(num) as num
-- FROM mynumbers n
-- where num IN (
--   SELECT num
--   FROM mynumbers
--   GROUP BY num
--   HAVING COUNT(*)=1
-- )
