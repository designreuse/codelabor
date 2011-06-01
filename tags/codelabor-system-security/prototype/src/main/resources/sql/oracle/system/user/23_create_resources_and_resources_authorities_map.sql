CREATE TABLE RESOURCES(
	RESOURCE_ID VARCHAR2(10) NOT NULL,
	RESOURCE_NAME VARCHAR2(50),
	RESOURCE_PATTERN VARCHAR2(300) NOT NULL,
	DESCRIPTION VARCHAR2(100),
	RESOURCE_TYPE VARCHAR2(10),
	SORT_ORDER NUMBER(5), 
	CONSTRAINT PK_RESOURCES PRIMARY KEY(RESOURCE_ID));

CREATE TABLE RESOURCES_AUTHORITIES_MAP(
	RESOURCE_ID VARCHAR2(10) NOT NULL,
	AUTHORITY VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_RESOURCES_AUTHORITIES_MAP PRIMARY KEY(RESOURCE_ID,AUTHORITY),
	CONSTRAINT FK_RESOURCES FOREIGN KEY(RESOURCE_ID) REFERENCES RESOURCES(RESOURCE_ID),
	CONSTRAINT FK_AUTHORITIES FOREIGN KEY (AUTHORITY) REFERENCES AUTHORITIES(AUTHORITY));