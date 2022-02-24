DROP DATABASE IF EXISTS bake_a_cake;
CREATE DATABASE IF NOT EXISTS bake_a_cake;
USE bake_a_cake;

CREATE TABLE IF NOT EXISTS users(
id int not null auto_increment,
name varchar(100) not null,
username varchar(100) unique not null,
password text not null,
email varchar(100) unique null,
primary key(id)
);

CREATE TABLE IF NOT EXISTS cake_tin_18(
id int not null auto_increment,
cake_title varchar(100)not null,
flour int,
sugar int,
eggs_grams int,
butter int,
cream_cheese int,
vanilla_sugar int,
milk int,
oil int,
gelatin int,
corn_flour int,
cocoa int,
dark_chocolate int,
white_chocolate int,
salt int,
baking_soda int,
baking_powder int,
confectioners_sugar int,
other varchar(250),
primary key(id)
);

CREATE TABLE IF NOT EXISTS cake_tin_20(
id int not null auto_increment,
cake_title varchar(100)not null,
flour int,
sugar int,
eggs_grams int,
butter int,
cream_cheese int,
vanilla_sugar int,
milk int,
oil int,
gelatin int,
corn_flour int,
cocoa int,
dark_chocolate int,
white_chocolate int,
salt int,
baking_soda int,
baking_powder int,
confectioners_sugar int,
other varchar(250),
primary key(id)
);

CREATE TABLE IF NOT EXISTS cake_tin_22(
id int not null auto_increment,
cake_title varchar(100)not null,
flour int,
sugar int,
eggs_grams int,
butter int,
cream_cheese int,
vanilla_sugar int,
milk int,
oil int,
gelatin int,
corn_flour int,
cocoa int,
dark_chocolate int,
white_chocolate int,
salt int,
baking_soda int,
baking_powder int,
confectioners_sugar int,
other varchar(250),
primary key(id)
);