DROP TABLE USERS;

CREATE TABLE users (
	username VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	UNIQUE (username, password)
);


INSERT INTO users VALUES ('test', 'test');

SELECT * FROM USERS;