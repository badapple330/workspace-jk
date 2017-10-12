set names utf8;
drop database if exists test;
create database test;
use test;
create table user(
id int,
user_name varchar(255),
password varchar(255)
);
insert into user values(1, "taro", "123");
insert into user values(2, "jiro", "123");
insert into user values(3, "hanako", "123");
insert into user values(4, "saburo", "123");


商品情報
create table items(

カート情報を追加していく。
create table cart(
