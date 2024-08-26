create database atsdb;
use atsdb;
create table user_credentials(id VARCHAR(6),user_name varchar(30),email_address VARCHAR(30),password VARCHAR(20),phone_number VARCHAR(10),last_attempt DATETIME,is_active BOOLEAN);
select * from user_credentials;
drop table user_credentials;