create database atsdb;
use atsdb;
create table login(id bigint,email_Address varchar(30),password varchar(15));
insert into login values(1,"mikkalya@gmail.com","Miks@123");
insert into login values(2,"hemalatha@gmail.com","Hema@123");
insert into login values(3,"satheesh@gmail.com","Satheesh@23");
select * from login;
drop table login;