package nl.eimertvink.repository;


import nl.eimertvink.model.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path="employee", collectionResourceRel = "employee")
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
    Employee getOne(Integer id);
    Optional<Employee> findById(Integer integer);


    // heavy:
    List<Employee> findAll();
    List<Employee> findAll(Sort sort);

    List<Employee> findAllById(Iterable<Integer> iterable);

    // C_UD:
    void deleteById(Integer id);
    void delete(Employee employee);
    void deleteAll(Iterable<? extends Employee> iterable);

    void deleteAll();
    // create + update:
    <S extends Employee> S save(S s);

    <S extends Employee> S saveAndFlush(S s);
    long count();
    <S extends Employee> List<S> saveAll(Iterable<S> iterable);
    boolean existsById(Integer integer);
    void flush();
    void deleteInBatch(Iterable<Employee> iterable);
    void deleteAllInBatch();
    <S extends Employee> List<S> findAll(Example<S> example);
    <S extends Employee> List<S> findAll(Example<S> example, Sort sort);
}
