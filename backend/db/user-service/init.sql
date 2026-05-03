CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     username VARCHAR(100) NOT UNIQUE NULL,
    password_hash VARCHAR(255) NOT NULL
    );

INSERT INTO users (username, password_hash)
VALUES
    ('Alice', '$2a$10$demoHashedPasswordAlice'),
    ('Bob', '$2a$10$demoHashedPasswordBob')
