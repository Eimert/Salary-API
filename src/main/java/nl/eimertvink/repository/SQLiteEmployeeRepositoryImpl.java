package nl.eimertvink.repository;

import nl.eimertvink.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EmployeeRepository employeeRepository;

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
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public List<Employee> getByName(String name) {
        return null;
    }

//    @Override
    public Void update(String Name, String position, String department, Float salary) {
        return null;
    }

    @Override
    public void deleteByName(String name) {
        employeeRepository.deleteByName(name);
    }

    @Override
    public List<Employee> findAll() {
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
    public void deleteById(Integer id) {

    }

    @Override
    public void delete(Employee employee) {
//        employee.getId()
    }

    @Override
    public void deleteAll(Iterable<? extends Employee> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
