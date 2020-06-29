create database atm;

use atm;

create table user
(
name varchar(50),
password varchar(6),
money double
);

insert into user values ('a','123456',10000);
insert into user values ('b','123456',10000);