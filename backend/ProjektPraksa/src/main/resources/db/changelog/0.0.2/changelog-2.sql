CREATE TABLE userstories (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(50),
    complexity BIGINT,
    current_stage VARCHAR(20)
    );

CREATE TABLE project (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    start_date TIMESTAMP,
    end_date TIMESTAMP
);


CREATE TABLE user_userstory (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    userstory_id BIGINT,
    last_edit TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (userstory_id) REFERENCES userstories (id)
);

CREATE TABLE userstory_project (
    userstory_id BIGINT,
    project_id BIGINT,
    added_date TIMESTAMP,
    PRIMARY KEY (userstory_id, project_id),
    FOREIGN KEY (userstory_id) REFERENCES userstories (id),
    FOREIGN KEY (project_id) REFERENCES project (id)
);

