package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        DatabaseInitService o = new DatabaseInitService();
        String sql = o.readScriptFromFile("sql/populate_db.sql");
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
}
