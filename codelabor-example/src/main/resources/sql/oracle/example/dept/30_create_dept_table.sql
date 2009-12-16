CREATE TABLE EXAMPLE_DEPT
(
	DEPTNO NUMBER(2 , 0) NOT NULL,
	DNAME VARCHAR2(14),
	LOC VARCHAR2(13)
);

ALTER TABLE EXAMPLE_DEPT ADD CONSTRAINT PK_EXAMPLE_DEPT PRIMARY KEY (DEPTNO);