/* CREATE 'cinedb' SCHEMA */
CREATE SCHEMA cinedb;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON cinedb.* TO 'spq'@'localhost';
