package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabaseInitService {

    public static void main(String[] args) {
        String sql = readScriptFromFile("sql/init_db.sql");
        if (sql == null) {
            System.out.println("Failed to read file.");
            return;
        }
        try {
            Connection conn = Database.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Database initialized successfully.");
        } catch (Exception e) {
            System.out.println("Failed to initialize database: " + e.getMessage());
        }
    }

    public static String readScriptFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            System.out.println("Failed to read file: " + e.getMessage());
            return null;
        }
    }
}
