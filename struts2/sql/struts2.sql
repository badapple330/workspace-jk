set names utf8;
drop database if exists test;
create database test;
use test;

/*---------------------各テーブルの作成-----------------------*/
create table user(
id int auto_increment,
user_id varchar(255) primary key,
password varchar(255),
adminflg int,
index(id)
);

/*primary keyは同じ値の重複の禁止 */
create table items(
item_id varchar(100) not null primary key, /*商品ID*/
item_name varchar(100) not null,
price int not null,
stocks int not null
);

create table cart(
user_id varchar(100) not null,
item_id varchar(100) not null,
item_name varchar(100) not null,
price int not null,
quantity int not null default 1
);

create table creditcard(
id int auto_increment primary key,
user_id varchar(100) not null,
category varchar(100) not null,
name varchar(100) not null,
cardnumber varchar(16) not null,
month varchar(10) not null,
year varchar(10) not null,
security varchar(10) not null,
index(id)
);

create table history(
id int auto_increment,
user_id varchar(100) not null,
item_id varchar(100) not null,
item_name varchar(100) not null,
price int not null,
quantity int not null,
index(id)
);

insert into user values(1, "taro", "123", 0);
insert into user values(2, "jiro", "123", 1);
insert into user values(3, "hanako", "123", 0);
insert into user values(4, "saburo", "123", 0);

insert into items(
item_id, item_name, price, stocks
)values
(1, 'テストテスト', 1024, 255),
(2, 'aaaaa', 9999, 314),
(3, 'bbbbb', 65535, 37);
