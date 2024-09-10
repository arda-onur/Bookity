CREATE TABLE IF NOT EXISTS bookity.verification_token
(
    id          SERIAL PRIMARY KEY,
    token       VARCHAR(255) NOT NULL,
    user_id     VARCHAR(36) NOT NULL,
    expiry_date TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES bookity.user(user_id) ON DELETE CASCADE
);