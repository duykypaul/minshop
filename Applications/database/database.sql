create database minshop character set utf8;
/*================|||||||||===============*/

use minshop;
create table role(
	role_id integer not null auto_increment,
    name nvarchar(20),
    primary key(role_id)
);

create table user (
	user_id integer not null auto_increment,
	email varchar(50),
    password varchar(16) not null,
    full_name nvarchar(30),
    old integer,
    address nvarchar(100),
    sex bit,
    id_number char(14),
    phone_number varchar(12),
    role_id integer not null,
    primary key(user_id),
    constraint fk_user_role foreign key(role_id) references role(role_id)
);

create table product_line (
	product_line_id integer not null auto_increment,
    name nvarchar(50),
    image nvarchar(30),
    primary key(product_line_id)
);

create table product (
	product_id integer not null auto_increment,
    name nvarchar(100) not null,
    price integer,
    descriptions nvarchar(100),
    image nvarchar(30),
    product_line_id integer not null,
    primary key(product_id),
    constraint fk_product_product_line foreign key(product_line_id) references product_line(product_line_id)
);

create table product_color (
	product_color_id integer not null auto_increment,
    name nvarchar(20),
    primary key(product_color_id)
);

create table product_size (
	product_size_id integer not null auto_increment,
    size varchar(10),
    primary key(product_size_id)
);

create table product_details (
	product_details_id integer not null auto_increment,
    product_id integer,
    product_size_id integer,
    product_color_id integer,
    quantity integer,
    import_date varchar(20),
    primary key(product_details_id),
    constraint fk_product_details_product foreign key(product_id) references product(product_id),
    constraint fk_product_details_product_size foreign key(product_size_id) references product_size(product_size_id),
    constraint fk_product_details_product_color foreign key(product_color_id) references product_color(product_color_id)
);

create table promotion (
	promotion_id integer not null auto_increment,
    name nvarchar(50),
    start_time nvarchar(50),
    end_time nvarchar(50),
    descriptions text,
    image text,
    current_price integer,
    primary key(promotion_id)
);


create table promotion_details(
	promotion_id integer not null auto_increment,
    product_id integer not null,
    primary key(promotion_id, product_id),
    constraint fk_promotion_details_promotion foreign key(promotion_id) references promotion(promotion_id),
    constraint fk_promotion_details_product foreign key(product_id) references product(product_id)
);

create table invoice (
	invoice_id integer not null auto_increment,
    customer_name nvarchar(50),
    phone_number nvarchar(12),
    delivery_address nvarchar(100),
    status bit,
    invoice_creation_date nvarchar(50),
    primary key(invoice_id)
);

create table invoice_details (
	invoice_id integer not null,
    product_details_id integer not null,
    quantity integer,
    price varchar(100),
    primary key(invoice_id, product_details_id),
    constraint fk_invoice_details_invoice foreign key(invoice_id) references invoice(invoice_id),
    constraint fk_invoice_details_product_details foreign key(product_details_id) references product_details(product_details_id)
);

ALTER TABLE `minshop`.`product`
ADD COLUMN `object` VARCHAR(10) NULL DEFAULT NULL AFTER `product_line_id`;

alter table product modify image varchar(50) null;

