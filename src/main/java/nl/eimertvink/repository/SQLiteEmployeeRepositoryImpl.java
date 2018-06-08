package nl.eimertvink.repository;

import nl.eimertvink.model.Employee;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



@Component
public class SQLiteEmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public List<Employee> findMe() {
        List<Employee> employees = new ArrayList<>();

        Employee employee = new Employee();
        employee.setFirstname("Eimert");
        employee.setLastname("Vink");

        employees.add(employee);
        return employees;
    }

    @Override
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

    /*
     * What is a better return type: List<String> or List<Employee> (of objects)?
     */
    @Override
    public List<Employee> listAllEmployees() {
        String sql = "select name, position, department, (CAST(REPLACE(REPLACE(IFNULL(Salary,0),',',''),'$','') as DECIMAL(10,2))) AS SALARY from salaries limit 1,(select count(*) from salaries);";
        Connection conn = SQLiteJDBCDriverConnection.connect();
        List<Employee> resultArray = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
//                System.out.println(rs.getString("NAME") + " sal: " + rs.getFloat("SALARY") + " " + Float.valueOf(rs.getString("SALARY")));
                resultArray.add(new Employee(rs.getString("NAME"), rs.getString("POSITION"), rs.getString("DEPARTMENT"), Float.valueOf(rs.getString("SALARY"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            SQLiteJDBCDriverConnection.close(conn);
        }

        return resultArray; //.toString();
//        return ArrayUtil.arrayToString(resultArray);
    }


}
