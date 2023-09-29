CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    first_name VARCHAR(25),
    last_name VARCHAR(25)
);

CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    status VARCHAR(15),
    priority VARCHAR(10),
    complexity BIGINT
);
CREATE TABLE user_task (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    task_id BIGINT,
    last_edit TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (task_id) REFERENCES tasks (id)
);


INSERT INTO users (username, password, first_name, last_name)
VALUES ('john_doe', 'my_password', 'John', 'Doe'),
       ('jane_smith', 'another_password', 'Jane', 'Smith'),
       ('bob_jackson', 'secure_pw', 'Bob', 'Jackson');






