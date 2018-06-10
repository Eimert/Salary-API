package nl.eimertvink.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * to-do: migrate
 */
public class SelectStatements {

    public void showDepartments() {
        String sql = "select DISTINCT(Department) as DEPARTMENT, count(Department) as NUM_EMPLOYEES from salaries GROUP BY Department ORDER BY NUM_EMPLOYEES desc;";
        Connection conn = SQLiteJDBCDriverConnection.connect();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println(String.format("%1$-23s %2$10s", new String("DEPARTMENT"), new String("NUM_EMPLOYEES")));
            // loop through the result set
            while (rs.next()) {

                System.out.println(String.format("%1$-30s %2$6d", rs.getString("DEPARTMENT"), rs.getInt("NUM_EMPLOYEES")));
//                System.out.println(rs.getString("DEPARTMENT") + "\t" +
//                                   rs.getInt("NUM_EMPLOYEES"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            SQLiteJDBCDriverConnection.close(conn);
        }

    }

}
