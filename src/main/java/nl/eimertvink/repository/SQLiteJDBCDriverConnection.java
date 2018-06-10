package nl.eimertvink.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class SQLiteJDBCDriverConnection {
//    @Autowired
//    private ConfigProperties configproperties;

    /*
     * connect to the salaries.db db
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:salaries.db";
//            String url = "jdbc:sqlite:salaries.db";
//            String url = SQLiteJDBCDriverConnection.url;
//            String url = "jdbc:sqlite:salaries.db";

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

