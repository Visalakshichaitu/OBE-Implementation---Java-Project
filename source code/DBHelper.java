package courseoutcome;

import java.sql.*;

public class DBHelper {
    private static final String DB_URL = "jdbc:sqlite:course_outcome.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            
            String sql = "CREATE TABLE IF NOT EXISTS Team11_course_outcome (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "course_outcome_code TEXT UNIQUE," +  
                    "course_id TEXT," +
                    "bloom_id TEXT," +
                    "expected_proficiency REAL," +
                    "expected_attainment REAL)";
            
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error creating database table");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}