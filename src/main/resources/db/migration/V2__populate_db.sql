INSERT INTO worker (ID, NAME, BIRTHDAY, LEVEL, SALARY) VALUES
(1, 'John Doe', '1990-05-01', 'Trainee', 800),
(2, 'Jane Doe', '1995-02-15', 'Junior', 1200),
(3, 'Bob Smith', '1985-09-23', 'Middle', 3500),
(4, 'Alice Johnson', '1980-12-10', 'Senior', 7500),
(5, 'Tom Wilson', '1992-08-07', 'Trainee', 900),
(6, 'Sarah Lee', '1998-01-20', 'Junior', 1500),
(7, 'David Kim', '1993-11-05', 'Middle', 4200),
(8, 'Jessica Chen', '1979-06-30', 'Senior', 9000),
(9, 'Kevin Nguyen', '1987-04-14', 'Trainee', 700),
(10, 'Erica Garcia', '1988-07-02', 'Middle', 5500);

INSERT INTO client (ID, NAME) VALUES
(1, 'ABC Company'),
(2, 'XYZ Corporation'),
(3, '123 Industries'),
(4, 'Big Enterprises'),
(5, 'Small Business Co.');

INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES
(1, 1, '2021-01-01', '2022-06-30'),
(2, 2, '2021-02-15', '2022-08-31'),
(3, 3, '2021-03-10', '2023-03-09'),
(4, 4, '2020-04-01', '2022-09-30'),
(5, 5, '2020-05-15', '2023-01-14'),
(6, 1, '2019-06-01', '2023-05-31'),
(7, 2, '2022-07-01', '2023-06-30'),
(8, 3, '2022-08-01', '2022-12-31'),
(9, 4, '2022-09-01', '2023-03-31'),
(10, 5, '2022-10-01', '2023-09-30');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(3, 7),
(4, 8),
(5, 9),
(5, 10),
(6, 1),
(6, 4),
(7, 2),
(7, 3),
(7, 5),
(8, 6),
(9, 7),
(9, 8),
(10, 9),
(10, 10);