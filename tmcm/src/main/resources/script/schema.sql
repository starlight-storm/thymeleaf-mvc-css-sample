CREATE SCHEMA sample authorization dba;
DROP TABLE IF EXISTS sample.customer;
CREATE TABLE sample.customer(
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(20),
    email VARCHAR(30),
    membership_type VARCHAR(1),
    graduate VARCHAR(1)
);
