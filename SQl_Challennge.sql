drop table if exists Homework;
CREATE TABLE Homework (ID int,value int);
select * from homework;
INSERT INTO homework 
VALUES( 1,-56);
INSERT INTO homework 
VALUES( 2,76);
INSERT INTO homework 
VALUES( 3,-84);
INSERT INTO homework 
VALUES( 4,96);
INSERT INTO homework 
VALUES( 5,-47);
--challenge 1
Select
id,
value * -1
From homework h 
--challenge 2
drop table if exists Homework2;
CREATE TABLE homework2 (division int, YEAR int, revenue int);
select * from homework2 h 

insert into homework2 values(1,2018,60);
insert into homework2 values(1,2021,40);
insert into homework2 values(1,2020,70);
insert into homework2 values(1,2021,-10);
insert into homework2 values(1,2018,20);
insert into homework2 values(1,2016,40);
insert into homework2 values(1,2021,50);


SELECT * 
FROM homework2 h 
WHERE "year" > 2020
and revenue > 0;

--challenge3
CREATE TABLE homework3 (id int, YEAR int);
select * from homework3

insert into homework3 values(1,1776);
insert into homework3 values(1,2001);
insert into homework3 values(1,1643);
insert into homework3 values(1,1865);
insert into homework3 values(1,1969);
select year/100 + 1 as century from homework3;

--challenge4
CREATE TABLE homework4 (id int, value int);
insert into homework4 values (1,4);
insert into homework4 values (2,11);
insert into homework4 values (3,57);
insert into homework4 values (4,24);
insert into homework4 values (5,47);
select * from homework4;

SELECT value,
     CASE WHEN value%2=0 THEN 'Even'
          WHEN value%2=1 THEN 'Odd'
          END AS Even_Odd
     FROM homework4;
--question5
CREATE TABLE homework5 (id int, name varchar,age int);
insert into homework5 values (1,'bob',21);
insert into homework5 values (2,'sam',19);
insert into homework5 values (3,'jill',18);
insert into homework5 values (4,'jim',21);
insert into homework5 values (5,'sally',19);
insert into homework5 values (6,'jess',20);
insert into homework5 values (7,'Will',21);
select age, count(*) from table5 group by age order by age asc;
select * from homework5;
--question6
CREATE TABLE homework6 (id int, name varchar);
insert into homework6 values (1,'bob');
insert into homework6 values (2,'sam');
insert into homework6 values (3, 'jill');
insert into homework6 values (4,'jim');
insert into homework6 values (5,'sally');
insert into homework6 values (6,'jess');
insert into homework6 values (7,'will');
SELECT SELECT concat('Hello, ', firstname, ' ', lastname, '!') FROM users;
select * from homework6;
select concat('Hi ', name, '! How are you today?') as greeting from homework6;
--question7
CREATE TABLE homework7 (id int, name varchar, amount_sold int);
insert into homework7 values (1,'cup',11);
insert into homework7 values (2,'saucer',22);
insert into homework7 values (3,'plate',46);
insert into homework7 values (4,'fork',34);
insert into homework7 values (5,'spoon',45);
insert into homework7 values (6,'knife',78);
insert into homework7 values (7,'mug',23);
insert into homework7 values (8,'glass',64);
insert into homework7 values (9,'tumbler',24);
SELECT amount_sold
FROM homework7
ORDER BY amount_sold DESC
limit 5;
select * from homework7
--question8
CREATE TABLE homework8 (id int, name varchar, country varchar);
insert into homework8 values (1,'Bob smith','united states');
insert into homework8 values (2,'Jim Jones','China');
insert into homework8 values (3,'Sam White','Japan');
insert into homework8 values (4,'Jess Black','Canada');
insert into homework8 values (5,'Will Wilson','Germany');
insert into homework8 values (6,'Wilson Scott','England');
insert into homework8 values (7,'Scott Daniels','France');
insert into homework8 values (9,'Jack Johnson','united states');
select * from homework8;
select *
FROM homework8
where not  country = 'united states'
--where not  country = 'Canada';?
--question9
CREATE TABLE homework9 (id int, name varchar, age varchar);
insert into homework9 values (1,'Bob',21);
insert into homework9 values (2,'Sam',19);
insert into homework9 values (3,'Jill',18);
insert into homework9 values (4,'Jim',21);
insert into homework9 values (5,'Sally',19);
insert into homework9 values (6,'Jess',20);
insert into homework9 values (7,'will',21);
select * from homework9;
select distinct age from homework9;
--question10
SELECT SUM(age) FROM homework9;