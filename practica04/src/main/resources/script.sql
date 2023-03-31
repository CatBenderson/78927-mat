create database if not exists saludos;
use saludos;
create user if not exists '78927'@'localhost' identified by '123456';
create user if not exists '78927'@'127.0.0.1' identified by '123456';
grant all privileges on  saludos.* to '78927'@'localhost' ;
grant all privileges on  saludos.* to '78927'@'127.0.0.1' ;
flush privileges;