CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    first_name VARCHAR(25),
    last_name VARCHAR(25)
);
CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    start_date TIMESTAMP,
    end_date TIMESTAMP
);

CREATE TABLE userstories (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(50),
    complexity BIGINT,
    current_stage VARCHAR(20),
     project_id BIGINT,
    FOREIGN KEY (project_id) REFERENCES projects (id)
    );


CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    status VARCHAR(15),
    priority VARCHAR(10),
    complexity BIGINT,
    userstory_id BIGINT,
    FOREIGN KEY (userstory_id) REFERENCES userstories (id)
);
CREATE TABLE user_task (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    task_id BIGINT,
    last_edit TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (task_id) REFERENCES tasks (id)
);

CREATE TABLE user_project (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    project_id BIGINT,
    role VARCHAR(10),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (project_id) REFERENCES projects (id)
);

CREATE TABLE user_userstory (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    userstory_id BIGINT,
    last_edit TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (userstory_id) REFERENCES userstories (id)
);


INSERT INTO users (username, password, first_name, last_name)
VALUES ('john_doe', 'my_password', 'John', 'Doe'),
       ('jane_smith', 'another_password', 'Jane', 'Smith'),
       ('bob_jackson', 'secure_pw', 'Bob', 'Jackson');





INSERT INTO users (username, password, first_name, last_name)
VALUES ('VPavlik', 'changeme', 'Veronika', 'Pavlik'),
       ('FKramar', 'changeme', 'Filip', 'Kramar'),
       ('ISmoljo', 'changeme', 'Ivan', 'Smoljo'),
       ('JJurcevic', 'changeme', 'Jurica', 'Jurcevic'),
       ('FLeskovic', 'changeme', 'Filip', 'Leskovic'),
       ('RDean', 'changeme', 'Rentato', 'Dean');

INSERT INTO projects (name, description, start_date, end_date)
VALUES ('Project 1', 'Description for Project 1', '2023-01-01 00:00:00', '2023-12-31 23:59:59'),
       ('Project 2', 'Description for Project 2', '2023-02-01 00:00:00', '2023-11-30 23:59:59'),
       ('Project 3', 'Description for Project 3', '2023-03-01 00:00:00', '2023-10-31 23:59:59');


INSERT INTO userstories (description, name, complexity, current_stage, project_id)
VALUES
  ('Develop user login feature', 'User Story 1', 0, 'IN_DEVELOPMENT', 1),
  ('Create product catalog', 'User Story 2', 0, 'TESTED', 1),
  ('Implement payment gateway', 'User Story 3', 0, 'CLOSED', 2),
  ('Design user dashboard', 'User Story 4', 0, 'IN_DEVELOPMENT', 3),
  ('Optimize database queries', 'User Story 5', 0, 'TESTED', 3);

INSERT INTO tasks (description, status, priority, complexity, userstory_id)
VALUES
  ('Task 1', 'NEW', 'HIGH', 0, 1),
  ('Task 2', 'IN_PROGRESS', 'HIGH', 0, 2),
  ('Task 3', 'IN_PROGRESS', 'LOW', 0, 3),
  ('Task 4', 'ON_HOLD', 'HIGH', 0, 4),
  ('Task 5', 'IN_PROGRESS', 'MEDIUM', 0, 5),
  ('Task 6', 'IN_PROGRESS', 'MEDIUM', 0, 5),
  ('Task 7', 'IN_PROGRESS', 'MEDIUM', 0, 5),
  ('Task 8', 'IN_PROGRESS', 'MEDIUM', 0, 5),
  ('Task 9', 'ON_HOLD', 'HIGH', 0, 4);


INSERT INTO user_task (user_id, task_id, last_edit)
VALUES
  (1, 2, '2023-09-28 14:20:00'),
  (1, 3, '2023-09-28 15:15:00'),
  (2, 4, '2023-09-28 15:15:00'),
  (1, 8, '2023-09-28 15:30:00'),
  (1, 9, '2023-09-28 15:20:00'),
  (4, 7, '2023-09-28 00:30:00');

INSERT INTO user_userstory (user_id, userstory_id, last_edit)
VALUES
  (1, 1, '2023-09-28 10:00:00'),
  (2, 2, '2023-09-28 11:30:00'),
  (3, 3, '2023-09-28 12:45:00');






INSERT INTO user_project (user_id, project_id, role)
VALUES
  (1, 1, 'MEMBER'),
  (2, 1, 'ADMIN'),
  (3, 2, 'MEMBER'),
  (4, 2, 'MEMBER'),
  (5, 3, 'ADMIN');

