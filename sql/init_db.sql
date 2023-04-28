CREATE TABLE IF NOT EXISTS worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1003) NOT NULL CHECK (CHAR_LENGTH(name)>2 and CHAR_LENGTH(name)<1000),
    birthday DATE CHECK (birthday > '1900-12-31'),
    level VARCHAR(8) NOT NULL CHECK ( level IN ('Trainee', 'Junior', 'Middle', 'Senior') ),
    salary INT CHECK (salary > 100 AND salary < 100000)
);

CREATE TABLE IF NOT EXISTS client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1003) NOT NULL CHECK (CHAR_LENGTH(name)>2 and CHAR_LENGTH(name)<1000)
);

CREATE TABLE IF NOT EXISTS project (
    id IDENTITY PRIMARY KEY,
    client_id BIGINT NOT NULL,
    start_date DATE,
    finish_date DATE
);

CREATE TABLE IF NOT EXISTS project_worker (
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (worker_id) REFERENCES worker(id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);

ALTER TABLE project
ADD CONSTRAINT client_id_fk
FOREIGN KEY(client_id)
REFERENCES client(id);