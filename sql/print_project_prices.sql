SELECT project.ID, SUM(worker.SALARY * TIMESTAMPDIFF(MONTH, project.START_DATE, project.FINISH_DATE)) AS project_cost
FROM project
JOIN project_worker ON project.ID = project_worker.PROJECT_ID
JOIN worker ON project_worker.WORKER_ID = worker.ID
GROUP BY project.ID
ORDER BY project_cost DESC;