package nl.eimertvink.salaryapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteJDBCDriverConnection {
    /*
     * connect to the salaries.db db
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:salaries.db";

            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /*
     * close connection to the salaries.db db
     */
    public static void close(Connection conn) {
        try {
            conn.close();
            System.out.println("Connection to SQLite has been closed.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

