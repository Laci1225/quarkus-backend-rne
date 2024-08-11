-- init.sql

-- Create Users Table
CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       phone_number VARCHAR(15) NOT NULL,
                       birth_date DATE NOT NULL,
                       nickname VARCHAR(255),
                       UNIQUE(phone_number, birth_date)
);

-- Create BeReals Table
CREATE TABLE bereals (
                         bereal_id SERIAL PRIMARY KEY,
                         user_id INT REFERENCES users(user_id),
                         front_photo BYTEA NOT NULL,
                         back_photo BYTEA NOT NULL,
                         location VARCHAR(255),
                         date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         UNIQUE(user_id, date_created)
);

-- Create Friendships Table
CREATE TABLE friendships (
                             user_id INT REFERENCES users(user_id),
                             friend_id INT REFERENCES users(user_id),
                             PRIMARY KEY(user_id, friend_id),
                             CHECK (user_id <> friend_id)
);

-- Optional: Insert initial data
-- INSERT INTO users (phone_number, birth_date) VALUES ('1234567890', '1990-01-01');
-- INSERT INTO bereals (user_id, front_photo_url, back_photo_url, location) VALUES (1, 'front_photo_url', 'back_photo_url', 'location');
-- INSERT INTO friendships (user_id, friend_id) VALUES (1, 2);
