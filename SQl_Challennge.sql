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

CREATE TABLE homework3 (id int, YEAR int);
select * from homework3

insert into homework3 values(1,1776);
insert into homework3 values(1,2001);
insert into homework3 values(1,1643);
insert into homework3 values(1,1865);
insert into homework3 values(1,1969);


CREATE TABLE homework4 (id int, value int);
insert into homework4 values (1,4);
insert into homework4 values (2,11);
insert into homework4 values (3,57);
insert into homework4 values (4,24);
insert into homework4 values (5,47);
select * from homework4

CREATE TABLE homework5 (id int, name varchar,age int);
insert into homework5 values (1,'bob',21);
insert into homework5 values (2,'sam',19);
insert into homework5 values (3,'jill',18);
insert into homework5 values (4,'jim',21);
insert into homework5 values (5,'sally',19);
insert into homework5 values (6,'jess',20);
insert into homework5 values (7,'Will',21);
select * from homework5

CREATE TABLE homework6 (id int, name varchar);
insert into homework6 values (1,'bob');
insert into homework6 values (2,'sam');
insert into homework6 values (3, 'jill');
insert into homework6 values (4,'jim');
insert into homework6 values (5,'sally');
insert into homework6 values (6,'jess');
insert into homework6 values (7,'will');

select * from homework6

CREATE TABLE homework7 (id int, name varchar, amount_sold int);
insert into homework7 values (1,'cup',11);
insert into homework7 values (2,'saucer',22);
insert into homework7 values (3,'plate',46);
insert into homework7 values (4,'fork,34');
insert into homework7 values (5,'spoon,45');
insert into homework7 values (6,'knife',78);
insert into homework7 values (7,'mug',23);
insert into homework7 values (8,'glass',64);
insert into homework7 values (9,'tumbler,24)';
select * from homework7

CREATE TABLE homework8 (id int, name varchar, country varchar);
insert into homework8 values (1,'Bob smith','united states');
insert into homework8 values (2,'Bob smith','united states');
insert into homework8 values (3,'Bob smith','united states');
insert into homework8 values (4,'Bob smith','united states');
insert into homework8 values (5,'Bob smith','united states');
insert into homework8 values (6,'Bob smith','united states');
insert into homework8 values (7,'Bob smith','united states');
insert into homework8 values (8,'Bob smith','united states');
insert into homework8 values (9,'Bob smith','united states');
select * from homework8

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

CREATE TABLE homework10 (id int, name varchar, age int);
select * from homework10