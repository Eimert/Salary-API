package nl.eimertvink.repository;


import nl.eimertvink.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
 * Repository or CrudRepository?
 * If we want to expose all repository methods that are declared by the CrudRepository interface AND we don’t want to return Optional (Guava / Java 8) objects, our repository interfaces should extend the CrudRepository interface.
 * If we don’t want to expose all repository methods that are declared by the CrudRepository interface OR we want to return Optional (Guava / Java 8) objects, our repository interfaces must extend the Repository interface.
 * Source: https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-two-crud/
 *
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> getByName(String name);

//    Void update(String Name, String position, String department, Float salary);

    void deleteByName(String name);

    List<Employee> findAll();

    void delete(Employee employee);

    void deleteById(Integer id);
    /*
     * Put customized methods in CustomizedEmployeeRepository.
     */
}
