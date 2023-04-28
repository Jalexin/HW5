package org.example;

import java.sql.*;

public class Database {

    private static final String DB_URL = "jdbc:h2:~/test1";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";
    private static Database instance;
    private Connection connection;

    public Database() {
        try {
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
