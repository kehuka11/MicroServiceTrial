DROP TABLE customer.app_user


CREATE TABLE IF NOT EXISTS customer.app_user(
	id varchar(50) Not Null PRIMARY KEY,
	user_password TEXT Not Null,
	last_name TEXT Not Null,
	first_name TEXT Not Null,
	status TEXT Not Null
	
)

