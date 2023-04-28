package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            String InitDbFilename = "sql/init_db.sql";
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(InitDbFilename))
            );
            try(Connection connection = Database.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
