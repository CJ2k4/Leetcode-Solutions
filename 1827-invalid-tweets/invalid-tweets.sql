# Write your MySQL query statement below
# ! or ' '

select tweet_id from tweets
where char_length(content) > 15;