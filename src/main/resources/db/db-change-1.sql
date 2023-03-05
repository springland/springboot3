--liquibase formatted sql

--changeset springland:1
create table customer (
                        id int primary key,
                        name varchar(255)
);


insert into customer(id , name) values ( 1,  'Adam');
insert into customer(id , name) values ( 2,  'Alan');
insert into customer(id , name) values ( 3,  'Peter');