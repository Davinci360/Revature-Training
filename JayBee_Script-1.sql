-- ??HELP?? why did this code block stop working when it worked fine previously?
create table if not exists pet (id integer, name varchar(50), species varchar(50), food varchar(50));
drop table pet;
create table food ()
Drop table if exists "food";--SQL Error [42601]: ERROR: syntax error at or near "drop"
  Position: 23
  
  		--HW Questions
  		 
--Select all records from the Employee table.
select * from "Employee";
--General Structure: select <columns> from <table> where <condition>

--Select all records from the Employee table where last name is King.
-- specify rows:
select * from "Employee" where "LastName"  = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" is null ;

--Select all albums in Album table and sort result set in descending order by title.
select * from "Album" order by "Title" desc ;  
--Select first name from Customer and sort result set in ascending order by city
select "FirstName"  from "Customer" c order by "FirstName"  asc;--??Whats with the c tag??

--General Structure: select <columns> from <table> where <condition>

--Select all invoices with a billing address like “T%”
select "BillingAddress"  from "Invoice" i WHERE "BillingAddress"  LIKE 'a%'; --SQL Error [42703]: ERROR: column "t%" does not exist
  Position: 197
  
--Select all invoices that have a total between 15 and 50
  --BETWEEN Syntax
--SELECT column_name(s) FROM table_name WHERE column_name BETWEEN value1 AND value2;
  select "Total"  from "Invoice" i where "Total" between 15 and 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
 select "HireDate"  from "Employee" e where "HireDate" between '2003-06-01T00:00:00' and '2004-03-01T00:00:00' 
 
--Insert practice
 --SYNTAX: INSERT INTO Customers (CustomerName, City, Country) VALUES ('Cardinal', 'Stavanger', 'Norway');
--Insert two new records into Genre table
 insert into "Genre" ("GenreId","Name") values (seq_person.nextval,'funk'); --??NEED HELP w this
 
--Insert two new records into Employee table
--Insert two new records into Customer table
 
--Update Practice
 --UPDATE Syntax
 	--UPDATE table_name SET column1 = value1, column2 = value2, ...WHERE condition;
 
--Update Aaron Mitchell in Customer table to Robert Walter
 select * from "Customer" c  where "LastName" = 'Mitchell'; -- id =32
 update "Customer" set "FirstName" = 'Robert',"LastName" = 'Walter' where "CustomerId" = 32;
select * from "Customer" c where "CustomerId" = 32; --SUCCESFUL
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
select * from "Artist" a where "Name" = 'Creedence Clearwater Revival';--ID 76
select * from "Artist" a where "Name" like  'Creedence%';
update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';
select "Name"  from "Artist" a where "ArtistId" =76;--SUCCESFUL
  
--Save all of your queries/commands in an sql file and push it to your exercise repo.
