CREATE TABLE IF NOT EXISTS bookity.customer
(
    "id"            SERIAL PRIMARY KEY,
    "email"         VARCHAR(255) NOT NULL ,
    "password"      VARCHAR(255) NOT NULL
 );
