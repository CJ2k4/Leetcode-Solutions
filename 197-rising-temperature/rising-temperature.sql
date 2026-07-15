# Write your MySQL query statement below
select ww.id from weather w join weather ww on ww.recordDate=w.recordDate + interval 1 day
where ww.temperature > w.temperature;