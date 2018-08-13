package nl.eimertvink.repository;


import nl.eimertvink.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path="employee", collectionResourceRel = "employee")
//@Import(SwaggerConfig.class)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> getByName(String name);
    void deleteByName(String name);

    @Query("Select max(salary) from Employee")
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



    @Query("select e from Employee e where e.name like :name")
    Page<Employee> queryByNameIgnoreCase(@Param("name") String name, Pageable page);
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
