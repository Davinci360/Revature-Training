create database PROJECTJB ;

--create table pet (id serial primary key, name varchar(50), species varchar(50), food varchar(50));

-- our new addition to the project will be adding a person table
create table person (id serial primary key, name varchar(50), password varchar(50));

alter table pet add column owner_id integer;

-- JB new addition to the project will be adding a employee table

--SETS USERNAME TO UNIQUE CONSTRAINT
create table employee (id serial primary key, name varchar(50), username varchar(50) unique, password varchar(50),title varchar(50));
-- add title column
insert into employee values (default, 'Roger','Rogdawg911', 'Roger123', 'Manager');

-- DEFAULT TO EMPLOYEE
insert into employee values (default, 'Lisa','Lisapizza83', 'Lisa123', default);

-- TEST DUPLICATE USERNAME---Throws EXPECTED error _SQL Error [23505]: ERROR: duplicate key value violates unique constraint "employee_username_key"
  Detail: Key (username)=(Lisapizza83) already exists.
insert into employee values (default, 'Pizza','Lisapizza83', 'Pizza123', default);

-- SETS TITLE TO EMPLOYEE WITH DEFAULT CONSTRAINT
alter table employee alter column title set default 'employee';

-- add ticket table
create table ticket (id serial primary key, amount numeric, description varchar(500), status varchar(50));
--add owner id column for ticket tracking
alter table ticket  add column owner_id integer;
--change name to user_id since user created the ticket
alter table ticket  rename column owner_id to user_id ;


-- public.ticket definition

-- Drop table
drop table employee ;
-- DROP TABLE public.ticket;

CREATE TABLE public.ticket (
	id serial4 NOT NULL,
	amount numeric NULL,
	description varchar(500) NULL,
	status varchar(50) NULL,
	user_id int4 NULL,
	CONSTRAINT ticket_pkey PRIMARY KEY (id)
);