SELECT u.user_id, u.username, td.training_id, td.training_date, COUNT(*) AS count 
FROM User u JOIN Training_details td ON u.user_id = td.user_id 
WHERE (u.user_id, td.training_id, td.training_date) IN ( 
	SELECT user_id, training_id, training_date 
	FROM Training_details 
	GROUP BY user_id, training_id, training_date 
	HAVING COUNT(*) > 1 
) 
GROUP BY u.user_id, u.username, td.training_id, td.training_date 
ORDER BY td.training_date DESC, count DESC;