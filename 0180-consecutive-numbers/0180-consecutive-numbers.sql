# Write your MySQL query statement below

-- Logic: join 3 tables and increment the id's by 1 and check the num value is equal
SELECT distinct
  l1.num as ConsecutiveNums 
FROM 
  logs l1,
  logs l2,
  logs l3
WHERE 
  l1.id=l2.id+1 AND 
  l2.id=l3.id+1 AND 
  l1.num=l2.num AND 
  l2.num=l3.num

-- Check below TC (if you think why we've used distinct) :
-- | id | num |
-- | -- | --- |
-- | 1  | 3   |
-- | 2  | 3   |
-- | 3  | 3   |
-- | 4  | 3   |
