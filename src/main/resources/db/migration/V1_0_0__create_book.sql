CREATE TABLE IF NOT EXISTS bookity.book
(
    "id"        SERIAL PRIMARY KEY,
    "isbn"      VARCHAR(255) NOT NULL,
    "book_name" VARCHAR(255) NOT NULL,
    "category"  VARCHAR(255) DEFAULT NULL,
    "image_url" VARCHAR(255) DEFAULT NULL
);
