# EmployeeManagenmentSystem-Backend-Springbbot
using springboot java jdk17 
intellij idea 

#database

CREATE DATABASE 'empolyeedb';
USE empolyeedb;

create table empolyee (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 phone varchar(10) NOT NULL,
 username vatchar(10) NOT NULL,
 password varchar(8) NOT NULL,
 PRIMARY KEY (id)
);
