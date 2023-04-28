package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static org.example.DatabaseInitService.readScriptFromFile;

public class DatabaseQueryService {

    public Database database;

    public DatabaseQueryService(Database database) {
        this.database = database;
    }

    public DatabaseQueryService() {

    }

    public List<ProjectPrice> findProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();
        String sql = readScriptFromFile("sql/print_project_prices.sql");

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ProjectPrice projectPrice = new ProjectPrice(
                        resultSet.getInt("ID"),
                        resultSet.getDouble("project_cost")
                );
                result.add(projectPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        String sql = readScriptFromFile("sql/find_longest_project.sql");

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                LongestProject longestProject = new LongestProject(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getDate("START_DATE"),
                        resultSet.getDate("FINISH_DATE"),
                        resultSet.getInt("project_duration")
                );
                result.add(longestProject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String sql = readScriptFromFile("sql/find_max_projects_client.sql");

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("num_projects")
                );
                result.add(maxProjectCountClient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String sql = readScriptFromFile("sql/find_max_salary_worker.sql");

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                MaxSalaryWorker worker = new MaxSalaryWorker(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("POSITION"),
                        resultSet.getDouble("SALARY"),
                        resultSet.getDate("BIRTHDAY")
                );
                result.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        String sql = readScriptFromFile("sql/find_youngest_eldest_workers.sql");

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(
                    resultSet.getString("TYPE"),
                    resultSet.getString("NAME"),
                    resultSet.getDate("BIRTHDAY")
                );
                result.add(youngestEldestWorkers);
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private class YoungestEldestWorkers {
        public YoungestEldestWorkers(String type, String name, Date birthday) {

        }
    }

    private class MaxSalaryWorker {
        public MaxSalaryWorker(int id, String name, String position, double salary, Date birthday) {
        }
    }

    private class MaxProjectCountClient {
        public MaxProjectCountClient(int id, String name, int num_projects) {

        }
    }

    private class LongestProject {
        public LongestProject(int id, String name, Date start_date, Date finish_date, int project_duration) {

        }
    }

    private class ProjectPrice {
        public ProjectPrice(int id, double project_cost) {

        }
    }
}