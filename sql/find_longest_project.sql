SELECT *, TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE) AS project_duration
FROM project
WHERE TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE) = (SELECT MAX(TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE)) FROM project);