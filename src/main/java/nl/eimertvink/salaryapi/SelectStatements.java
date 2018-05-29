package nl.eimertvink.salaryapi;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class SelectStatements {

    public void selectDepartment() {
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

    @RequestMapping("/topinternalearner")
    @ResponseBody
    public String topInternalEarner() {
        String sql = "select name, position, department, max(CAST(REPLACE(REPLACE(IFNULL(Salary,0),',',''),'$','') as DECIMAL(10,2))) AS SALARY from salaries;";
        Connection conn = SQLiteJDBCDriverConnection.connect();
        List<String> resultArray = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            resultArray.add(String.format("%1$-30s %2$-30s %3$-30s %4$6s", new String("NAME"), new String("POSITION"), new String("DEPARTMENT"), new String("SALARY")));
            // loop through the result set

            while (rs.next()) {
                resultArray.add(String.format("%1$-30s %2$-30s %3$-30s %4$6d", rs.getString("NAME"), rs.getString("POSITION"), rs.getString("DEPARTMENT"), rs.getInt("SALARY")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            SQLiteJDBCDriverConnection.close(conn);
        }
        return resultArray.toString();
//        return ArrayUtil.arrayToString(resultArray);
    }
}
