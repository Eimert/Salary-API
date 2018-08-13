package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

    List<Employee> getByName(String name);
    void deleteByName(String name);

    String queryByMaxInternalSalary();

    List<Employee> findTop5ByNameLike(String compulsoryNameFilter);
    Employee findFirstByNameLike(String compulsoryNameFilter);
    List<String> findDistinctEmployeeByDepartmentLike(String departmentName);
    //    List<Employee> findAllDistinctDepartment();
    List<Employee> findBySalaryLessThan(Float num);
    List<Employee> findBySalaryLessThanEqual(Float num);
    List<Employee> findBySalaryGreaterThan(Float num);
    List<Employee> findBySalaryGreaterThanEqual(Float num);
    Employee findFirstByDepartmentLike(String departmentName);



    Page<Employee> queryByNameIgnoreCase(String name, Pageable page);
    List<Employee> findByNameLikeIgnoreCase(String name);
    //    Employee getOne(int id);
    Employee findById(int id);


    // heavy:
    List<Employee> findAll();
    List<Employee> findAll(Sort sort);

    // C_UD:
    void deleteById(int id);
    void delete(Employee employee);

    // create + update:
//    <S extends Employee> S save(S s);
    <S extends Employee> S saveAndFlush(S s);
}
