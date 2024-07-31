CREATE TABLE  "ADMIN"(    "USERNAME" VARCHAR2(30),"PASSWORD" VARCHAR2(20),"NAME" VARCHAR2(255),"EMAIL" VARCHAR2(255),"ADMINID" NUMBER(38,0)) ;
INSERT INTO ADMIN (USERNAME, PASSWORD, NAME, EMAIL, ADMINID) VALUES
('Shiva', '1234', 'Shiva', 'shiva@gmail.com', 1),
('Janvika', '123', 'Janvika', 'janvika@gmail.com', 2),
('Shivasankaran', '1234', 'Shivasankaran', 'shivasankaran@gmail.com', 3),
('Lakshmansamy', '1234', 'Lakshmanasamy', 'Laskshmanasamy@gmail.com', 4),
('Dharun', '1234', 'Dharun', 'Dharun@gmail.com', 5),
('Jayanthi', '1234', 'Jayanthi', 'Jayanthi@gmail.com', 6),
('Christopher', '1234', 'Christopher', 'Christopher@gmail.com', 7),
('Saravanan', '1234', 'Saravanan', 'Saravanan@gmail.com', 8),
('dinesh', '1234', 'dinesh', 'dinesh', 9);
CREATE TABLE  "TOPIC"(    "TOPICID" NUMBER(38,0),"TOPICNAME" VARCHAR2(255),"MODULEID" NUMBER(38,0),CONSTRAINT "TPK" PRIMARY KEY ("TOPICID") ENABLE,CONSTRAINT "UTOPICNAME" UNIQUE ("TOPICNAME") ENABLE) ;
INSERT INTO TOPIC (TOPICID, TOPICNAME, MODULEID) VALUES
(51, 'Java 8', 52),
(31, 'Data Structures and Algorithm', 26),
(29, 'Encapsulation', 25),
(81, 'Java Exception', 81),
(82, 'Java', 82),
(33, 'Abstraction', 25),
(84, 'Java Strings', 73),
(85, 'Spring configuration', 92),
(86, 'Try and Catch', 31),
(87, 'Executor Service', 72);


CREATE TABLE  "ASSESSMENT"(    "ASSESSMENTID" NUMBER(38,0),"ASSESSMENTNAME" VARCHAR2(255),"TOPICID" NUMBER(38,0),CONSTRAINT "APK" PRIMARY KEY ("ASSESSMENTID") ENABLE,CONSTRAINT "UASSESSMENTNAME" UNIQUE ("ASSESSMENTNAME") ENABLE) ;
INSERT INTO ASSESSMENT (ASSESSMENTID, ASSESSMENTNAME, TOPICID) VALUES
(31, 'Probability', 29),
(21, 'Abstraction Assessment 3', 33),
(61, 'Java Stream', 51),
(42, 'Grand Test 1', 31),
(62, 'Encapsulation 1', 51),
(5, 'Encapsulation Assessment 1', 29),
(6, 'Encapsulation Assessment 2', 29),
(7, 'Abstraction Assessment 1', 33);


CREATE TABLE  "INSTRUCTOR"(    "INSTRUCTORID" NUMBER(*,0),"FIRSTNAME" VARCHAR2(50), 
    "LASTNAME" VARCHAR2(50), 
    "EMAIL" VARCHAR2(50), 
    "DEPARTMENT" VARCHAR2(50), 
    "USERNAME" VARCHAR2(255), 
    "PASSWORD" VARCHAR2(255), 
    "COURSEID" NUMBER, 
     PRIMARY KEY ("INSTRUCTORID") ENABLE, 
     CONSTRAINT "IUSER" UNIQUE ("USERNAME") ENABLE
   ) ;
   INSERT INTO INSTRUCTOR (INSTRUCTORID, FIRSTNAME, LASTNAME, EMAIL, DEPARTMENT, USERNAME, PASSWORD, COURSEID) VALUES
(1, 'Shiva', 'Sankaran', 'Shivacse2002@gmail.com', 'Physics', 'Shiva', '1234', 31),
(2, 'Naga', 'Jayanthi', 'NagaJayanthi@gmail.com', 'Physics', 'Naga', '1234', 31),
(3, 'Ravindra', 'Narayanan', 'RavindraNarayanan@gmail.com', 'Physics', 'Ravindra', '1234', 31),
(31, 'Vignesh', 'Kumar', 'viki123@gmail.com', 'Computer Science', 'vignesh', '1234', 31),
(11, 'Saravana', 'Kumar', 'saravanakumar@gmail.com', 'Computer Science', 'Saravanan', '1234', 31),
(51, 'Sham', 'Sundar', 'Sham@gmail.com', 'Computer Science', 'Sham', '1234', 31),
(21, 'Lakshman', 'samy', 'lakshman@gmail.com', 'Corporate Secrataryship', 'Lakshman', '1234', 31),
(41, 'Sheeba', 'Palanimuthu', 'sheeba@gmail.com', 'Computer Science', 'Sheeba', '1234', 31);


CREATE TABLE  "COURSES" 
   (    "COURSEID" NUMBER(*,0), 
    "COURSENAME" VARCHAR2(255), 
    "INSTRUCTORID" NUMBER(*,0), 
    "STARTDATE" DATE, 
    "ENDDATE" DATE, 
     PRIMARY KEY ("COURSEID") ENABLE
   ) ;
   INSERT INTO COURSES (COURSEID, COURSENAME, INSTRUCTORID, STARTDATE, ENDDATE) VALUES
(31, 'Python', 1, '2024-08-17', '2025-12-11'),
(81, 'Go Lang', 1, '2025-05-09', '2025-06-10'),
(101, 'Mojo', 1, '2024-12-11', '2025-12-11');

CREATE TABLE  "INS" 
   (    "INSID" NUMBER, 
    "FIRSTNAME" VARCHAR2(255), 
    "LASTNAME" VARCHAR2(255), 
    "DEPARTMENT" VARCHAR2(255), 
    "DOB" DATE, 
    "USERNAME" VARCHAR2(255), 
    "PASWORD" VARCHAR2(255)
   ) ;

INSERT INTO INS (INSID, FIRSTNAME, LASTNAME, DEPARTMENT, DOB, USERNAME, PASWORD) VALUES
(6, 'Johner', 'Brown', 'Computer Science', '2002-12-11', 'johner', 'jayanthi'),
(2, 'Shiva', 'Sankaran', 'Computer Science', '2002-11-12', 'Shiva', '1234'),
(3, 'Naga', 'Jayanthi', 'Computer Science', '2002-11-12', 'Naga', '1234'),
(8, 'Ravindra', 'Narayanan', 'Computer Science', '2002-11-12', 'Ravindra', '1234'),
(9, 'Vignesh', 'Kumar', 'Computer Science', '2002-11-12', 'Vignesh', '1234'),
(10, 'Saravana', 'Kumar', 'Computer Science', '2002-11-12', 'Saravanan', '1234'),
(11, 'Sham', 'Sundar', 'Computer Science', '2002-11-12', 'Sham', '1234'),
(12, 'Lakshman', 'Samy', 'Computer Science', '2002-11-12', 'Lakshman', '1234'),
(13, 'Sheeba', 'Palanimuthu', 'Computer Science', '2002-11-12', 'Sheeba', '1234');


CREATE TABLE  "MARKS" 
   (    "ASSESSMENTID" NUMBER, 
    "STUDENTID" NUMBER, 
    "MARKS" NUMBER
   ) ;

   INSERT INTO MARKS (ASSESSMENTID, STUDENTID, MARKS) VALUES
(5, 57, 1),
(5, 57, 1),
(21, 57, 1),
(5, 57, 1),
(61, 57, 0),
(62, 57, 1),
(42, 57, 0),
(7, 1, 2),
(7, 57, 3);



CREATE TABLE  "MODULE" 
   (    "MODULEID" NUMBER, 
    "MODULENAME" VARCHAR2(255), 
    "INSTRUCTORID" NUMBER(38,0), 
    "COURSEID" NUMBER(38,0), 
     CONSTRAINT "PK" PRIMARY KEY ("MODULEID") ENABLE, 
     CONSTRAINT "UMODULENAME" UNIQUE ("MODULENAME") ENABLE
   ) ;

   INSERT INTO MODULE (MODULEID, MODULENAME, INSTRUCTORID, COURSEID) VALUES
(52, 'Java 9', 11, 31),
(81, 'variables and constants', 51, 81),
(82, 'Structural Programming', 51, 81),
(73, 'Java 19', 31, 31),
(92, 'Spring & Spring Boot', 11, 31),
(31, 'Exception', 11, 31),
(72, 'Multithreading', 51, 31),
(121, 'Oops', 11, 31),
(25, 'Object Oriented Programming', 11, 31),
(26, 'Stream', 11, 31);

CREATE TABLE  "QUESTION" 
   (    "QUESTIONID" NUMBER(38,0), 
    "QUESTION" VARCHAR2(2000), 
    "OPTIONA" VARCHAR2(2000), 
    "ANSWER" VARCHAR2(1), 
    "ASSESSMENTID" NUMBER(38,0), 
    "OPTIONB" VARCHAR2(2000), 
    "OPTIONC" VARCHAR2(2000), 
    "OPTIOND" VARCHAR2(2000), 
     CONSTRAINT "QPK" PRIMARY KEY ("QUESTIONID") ENABLE
   );

   INSERT INTO QUESTION (QUESTIONID, QUESTION, OPTIONA, ANSWER, ASSESSMENTID, OPTIONB, OPTIONC, OPTIOND) VALUES
(69, 'Where is Taj Mahal located?', 'New Delhi', 'b', 7, 'Agra', 'Chennai', 'Hydrabad'),
(21, 'Abstraction can apply to ____________', 'a) Control and data', 'a', 7, 'b) Only data', 'c) Only control', 'd) Classes'),
(22, 'Encapsulation and abstraction differ as ____________', 'a) Binding and Hiding respectively', 'a', 7, 'b) Hiding and Binding respectively', 'c) Can be used any way', 'd) Hiding and hiding respectively'),
(71, 'xyz', 'x', 'c', 5, 'y', 'z', 'zz'),
(3, 'What does abstraction in Java focus on ?', 'Implementation', 'c', 7, 'Visibility', 'Essentials', 'Specifics'),
(4, 'Which keyword is used to create an abstract class in Java?', 'a) abstract', 'a', 7, 'b) encapsulate', 'c) private', 'd) Virtual'),
(61, 'What is the use of abstraction in java??', 'to hide the inner functionlities', 'D', 21, 'to make the deveopement ease', 'to acheive data hiding', 'all the above');

CREATE TABLE  "STUDENTS" 
   (    "STUDENTID" NUMBER(*,0), 
    "FIRSTNAME" VARCHAR2(50), 
    "LASTNAME" VARCHAR2(50), 
    "DEPARTMENT" VARCHAR2(200), 
    "DOB" DATE, 
    "USERNAME" VARCHAR2(200), 
    "PASSWORD" VARCHAR2(200)
   ) ;

insert into students values(1,'Shiva','Sankaran','Computer Science','11-12-2002','Shiva','1234');
INSERT INTO STUDENTS (STUDENTID, FIRSTNAME, LASTNAME, DEPARTMENT, DOB, USERNAME, PASSWORD) VALUES
(2, 'Naga', 'Jayanthi', 'Computer Science', TO_DATE('12-11-2002', 'DD-MM-YYYY'), 'Naga', '5678');

INSERT INTO STUDENTS (STUDENTID, FIRSTNAME, LASTNAME, DEPARTMENT, DOB, USERNAME, PASSWORD) VALUES
(3, 'Ravindra', 'Narayanan', 'Mathematics', TO_DATE('15-07-2001', 'DD-MM-YYYY'), 'Ravindra', 'abcd1234');



ALTER TABLE  "ASSESSMENT" ADD CONSTRAINT "AFK" FOREIGN KEY ("TOPICID")
      REFERENCES  "TOPIC" ("TOPICID") ON DELETE CASCADE ENABLE;ALTER TABLE  "COURSES" ADD CONSTRAINT "FK" FOREIGN KEY ("INSTRUCTORID")
      REFERENCES  "INSTRUCTOR" ("INSTRUCTORID") ENABLE;ALTER TABLE  "MODULE" ADD CONSTRAINT "MFK" FOREIGN KEY ("COURSEID")
      REFERENCES  "COURSES" ("COURSEID") ON DELETE CASCADE ENABLE;ALTER TABLE  "QUESTION" ADD CONSTRAINT "QFK" FOREIGN KEY ("ASSESSMENTID")
      REFERENCES  "ASSESSMENT" ("ASSESSMENTID") ON DELETE CASCADE ENABLE;ALTER TABLE  "TOPIC" ADD CONSTRAINT "TFK" FOREIGN KEY ("MODULEID")
      REFERENCES  "MODULE" ("MODULEID") ON DELETE CASCADE ENABLE;CREATE UNIQUE INDEX  "APK" ON  "ASSESSMENT" ("ASSESSMENTID");

INSERT INTO ASSESSMENT (ASSESSMENTID, ASSESSMENTNAME, TOPICID) VALUES
(31, 'Probability', 29),
(21, 'Abstraction Assessment 3', 33),
(61, 'Java Stream', 51),
(42, 'Grand Test 1', 31),
(62, 'Encapsulation 1', 51),
(5, 'Encapsulation Assessment 1', 29),
(6, 'Encapsulation Assessment 2', 29),
(7, 'Abstraction Assessment 1', 33);


CREATE UNIQUE INDEX  "PK" ON  "MODULE" ("MODULEID");
CREATE UNIQUE INDEX  "QPK" ON  "QUESTION" ("QUESTIONID");
CREATE UNIQUE INDEX  "SYS_C007219" ON  "COURSES" ("COURSEID");
CREATE UNIQUE INDEX  "SYS_C007220" ON  "INSTRUCTOR" ("INSTRUCTORID");
CREATE UNIQUE INDEX  "TPK" ON  "TOPIC" ("TOPICID");
CREATE UNIQUE INDEX  "UASSESSMENTNAME" ON  "ASSESSMENT" ("ASSESSMENTNAME");
CREATE UNIQUE INDEX  "UMODULENAME" ON  "MODULE" ("MODULENAME");
CREATE UNIQUE INDEX  "UTOPICNAME" ON  "TOPIC" ("TOPICNAME");
CREATE SEQUENCE   "TOPICSEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 91 CACHE 10 NOORDER  NOCYCLE ; CREATE SEQUENCE   "STUDENTSEQ"  MINVALUE 7 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 97 CACHE 10 NOORDER  NOCYCLE ; CREATE SEQUENCE   "QUESTIONSEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 10 NOORDER  NOCYCLE ; CREATE SEQUENCE   "MODULESEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 10 NOORDER  NOCYCLE ; CREATE SEQUENCE   "MODULESEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 131 CACHE 10 NOORDER  NOCYCLE ; CREATE SEQUENCE   "INSTRUCTORSEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 10 NOORDER  NOCYCLE ; CREATE SEQUENCE   "INSSEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ; CREATE SEQUENCE   "COURSESSEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 71 CACHE 10 NOORDER  NOCYCLE ; CREATE SEQUENCE   "ASSESSMENTSEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 71 CACHE 10 NOORDER  NOCYCLE ; CREATE SEQUENCE   "ADMINSEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 10 CACHE 20 NOORDER  NOCYCLE ;
