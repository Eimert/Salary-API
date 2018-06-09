package nl.eimertvink.repository;

import nl.eimertvink.model.Employee;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class SQLiteEmployeeRepositoryImpl implements EmployeeRepository {

//    private final JdbcTemplate jdbcTemplate;
//    /*
//     * constructor autowiring
//     */
//    @Autowired
//    public SQLiteEmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//
//    @Override
//    public List<Employee> findMe() {
//        List<Employee> employees = new ArrayList<>();
//
//        Employee employee = new Employee();
//        employee.setName("Vink, Eimert");
//
//        employees.add(employee);
//        return employees;
//    }
//
//    @Override
//    public String topInternalEarner() {
//        String sql = "select name, position, department, max(CAST(REPLACE(REPLACE(IFNULL(Salary,0),',',''),'$','') as DECIMAL(10,2))) AS SALARY from salaries;";
//        Connection conn = SQLiteJDBCDriverConnection.connect();
//        List<String> resultArray = new ArrayList<>();
//        try (Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            resultArray.add(String.format("%1$-30s %2$-30s %3$-30s %4$6s", new String("NAME"), new String("POSITION"), new String("DEPARTMENT"), new String("SALARY")));
//            // loop through the result set
//
//            while (rs.next()) {
//                resultArray.add(String.format("%1$-30s %2$-30s %3$-30s %4$6d", rs.getString("NAME"), rs.getString("POSITION"), rs.getString("DEPARTMENT"), rs.getInt("SALARY")));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            SQLiteJDBCDriverConnection.close(conn);
//        }
//        return resultArray.toString();
////        return ArrayUtil.arrayToString(resultArray);
//    }
//
//    @Override
//    public List<Employee> listAllEmployees() {
//        String sql = "select name, position, department, (CAST(REPLACE(REPLACE(IFNULL(Salary,0),',',''),'$','') as DECIMAL(10,2))) AS SALARY from salaries limit 1,(select count(*) from salaries);";
//        Connection conn = SQLiteJDBCDriverConnection.connect();
//        List<Employee> resultArray = new ArrayList<>();
//        try (Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            // loop through the result set
//            while (rs.next()) {
////                System.out.println(rs.getString("NAME") + " sal: " + rs.getFloat("SALARY") + " " + Float.valueOf(rs.getString("SALARY")));
//                resultArray.add(new Employee(rs.getString("NAME"), rs.getString("POSITION"), rs.getString("DEPARTMENT"), Float.valueOf(rs.getString("SALARY"))));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            SQLiteJDBCDriverConnection.close(conn);
//        }
//
//        return resultArray; //.toString();
////        return ArrayUtil.arrayToString(resultArray);
//    }

//    @Override
//    public List<Employee> getByName(String name) {
//        return null;
//    }
//
//    @Override
//    public Void update(String Name, String position, String department, Float salary) {
//        return null;
//    }
//
//    @Override
//    public Void deleteByName(String name) {
//        return null;
//    }
//
//    @Override
//    public Iterable<Employee> findAllById(Iterable<Float> iterable) {
//
//    }

    @Override
    public <S extends Employee> S save(S s) {

        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Employee> findAll() {
        String sql = "select rowid, name, position, department, (CAST(REPLACE(REPLACE(IFNULL(Salary,0),',',''),'$','') as DECIMAL(10,2))) AS SALARY from salaries;";
        Connection conn = SQLiteJDBCDriverConnection.connect();
        List<Employee> resultArray = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next()) {
//                System.out.println(rs.getString("NAME") + " sal: " + rs.getFloat("SALARY") + " " + Float.valueOf(rs.getString("SALARY")));
                Employee e = new Employee();
                e.setId(rs.getInt("rowid"));
                e.setName(rs.getString("NAME"));
                e.setPosition(rs.getString("POSITION"));
                e.setDepartment(rs.getString("DEPARTMENT"));
                e.setSalary(Float.valueOf(rs.getString("SALARY")));
                resultArray.add(e);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            SQLiteJDBCDriverConnection.close(conn);
        }
        return resultArray;
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
