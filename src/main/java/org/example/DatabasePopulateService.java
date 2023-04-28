package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String[] workerNames = {"Michel", "Taras", "Nikita", "Anton", "Kolya", "Jonson", "Jana", "Galina", "Ana",
                "Kristina", "Genadiy", "Tolya", "Yaroslav"};
        String[] workerBirthday = {"1990-05-12", "2001-12-10", "2002-07-17", "1998-10-03", "2000-11-02", "2000-05-12",
                "1999-07-28", "2001-05-21", "1997-11-15", "2002-01-11", "2003-03-18", "2000-08-13", "2001-06-17"};
        String[] workerLevel = {"Senior", "Junior", "Trainee", "Middle", "Junior", "Trainee", "Middle", "Junior",
                "Middle", "Junior", "Trainee", "Middle", "Junior"};
        int[] workerSalary = {6500, 1000, 450, 2000, 750, 500, 2500, 1000, 2300,
                800, 350, 2000, 800};
        String[] clientNames = {"Dohn", "Joseph", "Thor", "Loki", "Rosalina"};
        int[] clentIds = {1, 5, 5, 1, 2, 4, 3, 3, 1, 4, 2};
        String[] projectStsrtDates = {"2017-10-12",
                "2020-05-18",
                "2018-07-17",
                "2021-01-10",
                "2021-08-21",
                "2022-11-24",
                "2019-09-14",
                "2018-12-25",
                "2017-06-10",
                "2023-11-11",
                "2022-12-01"};
        String[] projectFinishDates = {"2020-03-08",
                "2024-12-01",
                "2023-01-01",
                "2022-09-05",
                "2022-04-19",
                "2023-02-02",
                "2022-12-11",
                "2024-10-14",
                "2025-06-11",
                "2027-08-17",
                "2024-01-13"};
        int[] projectIds = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 7, 7, 7, 8, 9, 9, 10, 11, 11, 11};
        int[] workerIds = {13, 7, 9, 2, 3, 1, 8, 6, 13, 4, 1, 5, 2, 9, 11, 10, 12, 11, 1, 3, 5, 9};
        addWorkers(workerNames, workerBirthday, workerLevel, workerSalary);
        addClients(clientNames);
        addProjects(clentIds, projectStsrtDates, projectFinishDates);
        addLinkProjectWorker(projectIds, workerIds);
    }

    private static void addWorkers(String[] name, String[] birthday, String[] level, int[] salary) {
        String workerInsertSql = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(workerInsertSql)) {
            for (int i = 0; i < name.length; i++) {
                ps.setString(1, name[i]);
                ps.setString(2, birthday[i]);
                ps.setString(3, level[i]);
                ps.setInt(4, salary[i]);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addClients(String[] name) {
        String clientInsertSql = "INSERT INTO client (name) VALUES (?)";
        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(clientInsertSql)) {
            for (int i = 0; i < name.length; i++) {
                ps.setString(1, name[i]);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addProjects(int[] clientId, String[] startDate, String[] finishDate) {
        String projectInsertSql = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)";
        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(projectInsertSql)) {
            for (int i = 0; i < clientId.length; i++) {
                ps.setInt(1, clientId[i]);
                ps.setString(2, startDate[i]);
                ps.setString(3, finishDate[i]);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addLinkProjectWorker(int[] projectId, int[] workerId) {
        String projectWorkerInsertSql = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";
        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(projectWorkerInsertSql)) {
            for (int i = 0; i < projectId.length; i++) {
                ps.setInt(1, projectId[i]);
                ps.setInt(2, workerId[i]);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}