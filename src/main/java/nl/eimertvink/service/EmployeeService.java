package nl.eimertvink.service;

import nl.eimertvink.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    // Customized:
    String queryByMaxInternalSalary();
    void deleteByName(String name);
    void deleteById(Integer id);

    List<Employee> findAll();
    String findOne(Integer id);
    Optional<Employee> findById(Integer id);
    Employee getOne(Integer id);
    List<String> findDistinctEmployeeByDepartmentLike(String departmentName);
//    Iterable<Employee> listAllEmployees();
//    List<Employee> findTop5ByNameLike(String compulsoryNameFilter);
//    Employee findFirstByNameLike(String compulsoryNameFilter);
//    List<Employee> findAllDistinctDepartment();
//    List<Employee> findBySalaryLessThan(Float num);
//    List<Employee> findBySalaryLessThanEqual(Float num);
//    List<Employee> findBySalaryGreaterThan(Float num);
//    List<Employee> findBySalaryGreaterThanEqual(Float num);
//    Employee findFirstByDepartmentLike(String departmentName);


    void saveAndFlush(Employee emp);
//    void setNameById(Integer id, String name);
//    void setPositionById(Integer id, String name);
    void delete(Employee employee);
    void deleteAll(Iterable<? extends Employee> iterable);
    void deleteAll();




}
