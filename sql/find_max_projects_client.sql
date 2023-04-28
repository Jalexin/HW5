SELECT client.ID, client.NAME, COUNT(project.ID) as num_projects
FROM client
JOIN project ON client.ID = project.CLIENT_ID
GROUP BY client.ID, client.NAME
HAVING COUNT(project.ID) = (SELECT MAX(num_projects) FROM (SELECT COUNT(ID) as num_projects FROM project GROUP BY CLIENT_ID) AS project_counts);