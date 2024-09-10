CREATE TABLE IF NOT EXISTS bookity.user
(
    id                      SERIAL PRIMARY KEY,
    email                   VARCHAR(255) UNIQUE,
    first_name              VARCHAR(255) NOT NULL,
    last_name               VARCHAR(255) NOT NULL,
    password                VARCHAR(255) NOT NULL,
    user_id                 VARCHAR(36) UNIQUE NOT NULL,
    enabled                 BOOLEAN      DEFAULT TRUE,
    account_non_expired     BOOLEAN      DEFAULT TRUE,
    account_non_locked      BOOLEAN      DEFAULT TRUE,
    credentials_non_expired BOOLEAN      DEFAULT TRUE
    );
