package example1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private Connection connection;

    public ClientService(Connection connection) {
        this.connection = connection;
    }

    public long create(String name) throws SQLException {
        if (name == null || name.trim().isEmpty() || name.length() > 1000) {
            throw new IllegalArgumentException("Invalid name");
        }

        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO client (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating client failed, no ID.");
            }
        }
    }

    public String getById(long id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT name FROM client WHERE id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                return null;
            }
        }
    }

    public void setName(long id, String name) throws SQLException {
        if (name == null || name.trim().isEmpty() || name.length() > 1000) {
            throw new IllegalArgumentException("Invalid name");
        }

        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE client SET name = ? WHERE id = ?")) {
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();
        }
    }

    public void deleteById(long id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM client WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM client");

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                clients.add(new Client(id, name));
            }
        }

        return clients;
    }
}