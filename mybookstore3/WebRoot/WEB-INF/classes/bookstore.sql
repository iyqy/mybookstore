create database bookstore;

use bookstore;

# 分类 categorys
create table categorys
(
	id varchar(40) primary key,
	name varchar(30)
);
	
# 图书 books
create table books
(
	id varchar(40) primary key,
	name varchar(30),
	author varchar(20),
	price float,
	pagenum int,
	imagepath varchar(200),
	categorysid varchar(40),
	constraint categorysid_FK foreign key(categorysid) references categorys(id)
);

# 用户 users
create table users
(
	id varchar(40) primary key,
	username varchar(20),
	password varchar(100),
	email varchar(50)
);

# 地址 address
create table address
(
	id varchar(40) primary key,
	name varchar(20),
	location varchar(200),
	cellphone varchar(20),
	usersid varchar(40),
	constraint usersid_FK foreign key(usersid) references users(id)
);

# 订单 orders
create table orders
(
	id varchar(40) primary key,
	number varchar(20),
	ordertime date,
	price float,
	status boolean,
	usersid varchar(40),
	addressid varchar(40),
	constraint usersid_FK1 foreign key(usersid) references users(id),
	constraint addressid_FK foreign key(addressid) references address(id)
);

# 订单项 orderitems
create table orderitems
(
	id varchar(40) primary key,
	quantity int,
	price float,
	booksid varchar(40),
	ordersid varchar(40),
	constraint booksid_FK foreign key(booksid) references books(id),
	constraint ordersid_FK foreign key(ordersid) references orders(id)
);
