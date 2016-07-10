DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS PROFESSION;
DROP TABLE IF EXISTS PERSON;
DROP TABLE IF EXISTS DEPARTMENT;

--DEPARTMENT TABLE
CREATE TABLE IF NOT EXISTS DEPARTMENT (
    ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 100, INCREMENT BY 1) NOT NULL,
    NAME VARCHAR(200),
    HEAD INT,
	PRIMARY KEY (ID)
);

--PERSON TABLE
CREATE TABLE IF NOT EXISTS PERSON(
	ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 100, INCREMENT BY 1) NOT NULL,
    NAME VARCHAR(200),
	PRIMARY KEY (ID)
);

--PROFESSION TABLE
CREATE TABLE IF NOT EXISTS PROFESSION (
	ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 100, INCREMENT BY 1) NOT NULL,
    NAME VARCHAR(200),
    PRIMARY KEY (ID)
);

--EMPLOYEE TABLE
CREATE TABLE IF NOT EXISTS EMPLOYEE (
	ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL,
    PERSON_ID    INTEGER,
    PROFESSION_ID  INTEGER,
    DEPARTMENT_ID  INTEGER,
    EMAIL VARCHAR(30),
    PHONE VARCHAR(20),
    MOBILE_PHONE VARCHAR(20),
    PRIMARY KEY (ID)
);
	
--FOREING KEYS
ALTER TABLE DEPARTMENT ADD CONSTRAINT FK_DEPARTMENT_HEAD FOREIGN KEY (HEAD) REFERENCES DEPARTMENT (ID) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_PERSON FOREIGN KEY (PERSON_ID) REFERENCES PERSON (ID) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_PROFESSION FOREIGN KEY (PROFESSION_ID) REFERENCES PROFESSION (ID) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT (ID) ON DELETE CASCADE ON UPDATE CASCADE;