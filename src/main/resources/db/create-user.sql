DROP USER IF EXISTS 'fortune2009'@'localhost';
CREATE USER 'fortune2009'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON peersdb.* TO 'fortune2009'@'localhost';
FLUSH PRIVILEGES ;

DROP DATABASE IF EXISTS peersdb;
CREATE DATABASE peersdb;