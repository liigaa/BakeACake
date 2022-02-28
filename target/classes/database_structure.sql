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
    cake_title varchar(100) unique not null,
    flour double (10, 2),
    sugar double (10, 2),
    eggs_grams double (10, 2),
    butter double (10, 2),
    cream_cheese double (10, 2),
    vanilla_sugar double (10, 2),
    milk double (10, 2),
    oil double (10, 2),
    gelatin double (10, 2),
    corn_flour double (10, 2),
    cocoa double (10, 2),
    dark_chocolate double (10, 2),
    white_chocolate double (10, 2),
    salt double (10, 2),
    baking_soda double (10, 2),
    baking_powder double (10, 2),
    confectioners_sugar double (10, 2),
    other varchar(250),
    primary key(id)
    );

CREATE TABLE IF NOT EXISTS cake_tin_20(
    id int not null auto_increment,
    cake_title varchar(100) unique not null,
    flour double (10, 2),
    sugar double (10, 2),
    eggs_grams double (10, 2),
    butter double (10, 2),
    cream_cheese double (10, 2),
    vanilla_sugar double (10, 2),
    milk double (10, 2),
    oil double (10, 2),
    gelatin double (10, 2),
    corn_flour double (10, 2),
    cocoa double (10, 2),
    dark_chocolate double (10, 2),
    white_chocolate double (10, 2),
    salt double (10, 2),
    baking_soda double (10, 2),
    baking_powder double (10, 2),
    confectioners_sugar double (10, 2),
    other varchar(250),
    primary key(id)
    );

CREATE TABLE IF NOT EXISTS cake_tin_22(
    id int not null auto_increment,
    cake_title varchar(100) unique not null,
    flour double (10, 2),
    sugar double (10, 2),
    eggs_grams double (10, 2),
    butter double (10, 2),
    cream_cheese double (10, 2),
    vanilla_sugar double (10, 2),
    milk double (10, 2),
    oil double (10, 2),
    gelatin double (10, 2),
    corn_flour double (10, 2),
    cocoa double (10, 2),
    dark_chocolate double (10, 2),
    white_chocolate double (10, 2),
    salt double (10, 2),
    baking_soda double (10, 2),
    baking_powder double (10, 2),
    confectioners_sugar double (10, 2),
    other varchar(250),
    primary key(id)
    );

CREATE TABLE IF NOT EXISTS shopping_list(
    id int not null auto_increment,
    flour double (10, 2),
    sugar double (10, 2),
    eggs_grams double (10, 2),
    butter double (10, 2),
    cream_cheese double (10, 2),
    vanilla_sugar double (10, 2),
    milk double (10, 2),
    oil double (10, 2),
    gelatin double (10, 2),
    corn_flour double (10, 2),
    cocoa double (10, 2),
    dark_chocolate double (10, 2),
    white_chocolate double (10, 2),
    salt double (10, 2),
    baking_soda double (10, 2),
    baking_powder double (10, 2),
    confectioners_sugar double (10, 2),
    other varchar(500),
    primary key(id)
    );
