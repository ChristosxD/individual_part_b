
CREATE SCHEMA IF NOT EXISTS christoskotsoudatabase;
USE christoskotsoudatabase ;


CREATE TABLE IF NOT EXISTS christoskotsoudatabase.assignment (
  ID INT NOT NULL AUTO_INCREMENT,
  Title VARCHAR(50) NULL DEFAULT NULL,
  Description VARCHAR(50) NULL DEFAULT NULL,
  SubDateTime DATE NULL DEFAULT NULL,
  OralMark INT NULL DEFAULT NULL,
  TotalMark INT NULL DEFAULT NULL,
  PRIMARY KEY (ID))
AUTO_INCREMENT = 0;


CREATE TABLE IF NOT EXISTS christoskotsoudatabase.course (
  ID INT NOT NULL AUTO_INCREMENT,
  Title VARCHAR(45) NULL DEFAULT NULL,
  Stream VARCHAR(45) NULL DEFAULT NULL,
  Type VARCHAR(45) NULL DEFAULT NULL,
  StartDate DATE NULL DEFAULT NULL,
  EndDate DATE NULL DEFAULT NULL,
  PRIMARY KEY (ID))
AUTO_INCREMENT = 0;


CREATE TABLE IF NOT EXISTS christoskotsoudatabase.coursesperassignments (
  Course_ID INT NOT NULL,
  Assignment_ID INT NOT NULL,
  PRIMARY KEY (Course_ID, Assignment_ID),
  INDEX fk_Course_has_Assignment_Assignment1_idx (Assignment_ID ASC) VISIBLE,
  INDEX fk_Course_has_Assignment_Course1_idx (Course_ID ASC) VISIBLE,
  CONSTRAINT fk_Course_has_Assignment_Assignment1
    FOREIGN KEY (Assignment_ID)
    REFERENCES christoskotsoudatabase.assignment (ID),
  CONSTRAINT fk_Course_has_Assignment_Course1
    FOREIGN KEY (Course_ID)
    REFERENCES christoskotsoudatabase.course (ID));


CREATE TABLE IF NOT EXISTS christoskotsoudatabase.student (
  ID INT NOT NULL AUTO_INCREMENT,
  FirstName VARCHAR(45) NULL DEFAULT NULL,
  LastName VARCHAR(45) NULL DEFAULT NULL,
  DateOfBirth DATE NULL DEFAULT NULL,
  TuitionFees VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (ID))
AUTO_INCREMENT = 0;


CREATE TABLE IF NOT EXISTS christoskotsoudatabase.coursesperstudents (
	Course_ID INT NOT NULL,
	Student_ID INT NOT NULL,
	PRIMARY KEY (Course_ID, Student_ID),
	INDEX fk_Course_has_Student_Student1_idx (Student_ID ASC) VISIBLE,
	INDEX fk_Course_has_Student_Course_idx (Course_ID ASC) VISIBLE,
	CONSTRAINT fk_Course_has_Student_Course
    FOREIGN KEY (Course_ID)
    REFERENCES christoskotsoudatabase.course (ID),
	CONSTRAINT fk_Course_has_Student_Student1
    FOREIGN KEY (Student_ID)
    REFERENCES christoskotsoudatabase.student (ID));


CREATE TABLE IF NOT EXISTS christoskotsoudatabase.trainer (
  ID INT NOT NULL AUTO_INCREMENT,
  FirstName VARCHAR(45) NULL DEFAULT NULL,
  LastName VARCHAR(45) NULL DEFAULT NULL,
  Subject VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (ID))
AUTO_INCREMENT = 0;


CREATE TABLE IF NOT EXISTS christoskotsoudatabase.coursespertrainers (
  Course_ID INT NOT NULL,
  Trainer_ID INT NOT NULL,
  PRIMARY KEY (Course_ID, Trainer_ID),
  INDEX fk_Course_has_Trainer_Trainer1_idx (Trainer_ID ASC) VISIBLE,
  INDEX fk_Course_has_Trainer_Course1_idx (Course_ID ASC) VISIBLE,
  CONSTRAINT fk_Course_has_Trainer_Course1
    FOREIGN KEY (Course_ID)
    REFERENCES christoskotsoudatabase.course (ID),
  CONSTRAINT fk_Course_has_Trainer_Trainer1
    FOREIGN KEY (Trainer_ID)
    REFERENCES christoskotsoudatabase.trainer (ID));


insert into student (Firstname,lastname,dateofbirth,tuitionFees)
values ('Giannis', 'Kaltsas', '1993-4-02', 2500)
,( 'George','Pappas','1993-5-12',2500)
,('Dimitris', 'Souliotis', '1993-6-12', 1000)
,('Nikolaos', 'Tsepetsidis', '1993-4-16', 1542)
,('Christos', 'Kontosis', '1993-5-18', 1565)
,('Panagiotis', 'Makriniotis', '1993-5-21', 2422)
,('Athanasios', 'Vavatsikos', '1993-1-5', 1233)
,('Panagiotis', 'Souliotis', '1993-11-7', 1255)
,('Maria', 'Likoudi', '1993-2-09', 1622)
,('Fotis', 'Soldatos', '1994-3-12', 1255)
,('Giorgos', 'Giorgou', '1995-4-3', 2450)
,('Giorgos', 'Kardakas', '1996-5-22', 2222)
,('Lefteris', 'Mistakidis', '1991-4-21', 1253)
,('Theodoros', 'Feskos', '1992-3-21', 2156)
,('Petros', 'Charitos', '1993-6-21', 2144)
,('Eirini', 'Papaioannou', '1990-5-13', 2555)
,('Stavros', 'Nikitaras', '1990-6-17', 1244)
,('Foteini', 'Riga', '1991-7-15', 1255)
,('George', 'Karamitros', '1991-8-16', 2133)
,('Ioannis', 'Karamitros', '1992-7-16', 2155)
,('Iasonas', 'Limas', '1993-7-2', 1233)
,('Efraim', 'Argiriou', '1994-7-29', 2122)
,('Argiris', 'Konstas', '1995-7-2', 2500)
,('Paul', 'Tsikas', '1991-10-3', 2000)
,('Lefteris', 'Lekkos', '1991-4-3', 1000)
,('Kostas', 'Giannou', '1992-11-21', 2144)
,('Charis', 'Markou', '1991-2-22', 1244)
,('Giannis', 'Antoniou', '1990-3-21', 2155)
,('Spyros', 'Gogas', '1990-2-2', 2001)
,('Christos','Kotsou','1990-2-2', 2001);


insert into course (title, stream, type, startdate, enddate)
values ('Java', 'PartTime','CB13','2021-2-15', '2021-9-15'),
('Java', 'FullTime','CB13','2021-2-15', '2021-9-15'),
('Python', 'PartTime','CB13','2021-2-15', '2021-9-15'),
('Python', 'FullTime','CB13','2021-2-15', '2021-9-15'),
('C++', 'PartTime','CB13','2021-2-15', '2021-9-15'),
('C++', 'FullTime','CB13','2021-2-15', '2021-9-15'),
('C#', 'PartTime','CB13','2021-2-15', '2021-9-15'),
('C#', 'FullTime','CB13','2021-2-15', '2021-9-15'),
('SQL', 'PartTime','CB13','2021-2-15', '2021-9-15'),
('SQL', 'FullTime','CB13','2021-2-15', '2021-9-15') ;

insert into trainer (firstname,lastname,subject)
values ('Giorgos', 'Irakleidis', 'Trainer'),
('Spiros', 'Mavros', 'Trainer'),
('Giorgos', 'Rigopoulos', 'Trainer'),
('Giorgos', 'Pasparakis', 'Leader Trainer'),
('Tasos', 'Lekakis', 'Trainer');

insert into assignment (title,Description,SubDateTime,OralMark,TotalMark)
values('Private School','Individual Project','2021-3-31',100,100),
('Cinema','Individual Project','2021-3-31',100,100),
('Pet Shop','Individual Project','2021-3-31',100,100),
('Coffe Shop','Individual Project','2021-3-31',100,100),
('WareHouse','Individual Project','2021-3-31',100,100);


insert into coursesperstudents(Course_id,student_id)
 values(1,1)
 ,(2,2),(3,3)
,(4,4),(5,5),
(6,6),(7,7),
(8,8),(9,9),
(10,10),(1,11)
,(2,12),(3,13)
,(4,14),(5,15)
,(6,16),(7,17)
,(8,18),(9,19)
,(10,20),(1,20)
,(2,21),(3,22)
,(4,23),(5,24)
,(6,25),(7,26)
,(8,27),(9,28)
,(10,29),(1,30)
,(1,21),(1,22)
,(1,15),(1,12)
,(2,7),(2,22)
,(2,30),(2,29)
,(3,26),(3,20)
,(4,1),(4,2)
,(5,9),(6,8)
,(5,4),(7,3);

insert into coursespertrainers(course_id,trainer_id)
values (1,1),(2,2),
(3,3),(4,4),
(5,5),(6,1),
(7,2),(8,3),
(9,4),(10,5),
(1,4),(2,4),
(3,4),(5,4),
(6,4),(7,4),
(8,4),(10,4);


insert into coursesperassignments(course_id,Assignment_ID)
values (1,1),(2,1),
(3,2),(4,2),
(5,3),(6,3),
(7,4),(8,4),
(9,5),(10,5),
(1,2),(2,2),
(3,1),(4,1);



