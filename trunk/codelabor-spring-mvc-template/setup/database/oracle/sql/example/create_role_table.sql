DROP TABLE EXAMPLE_ROLE CASCADE CONSTRAINTS;

CREATE TABLE EXAMPLE_ROLE (
	ROLE_ID		VARCHAR2(32) PRIMARY KEY NOT NULL,
	DESCRIPTION	VARCHAR2(128)
);