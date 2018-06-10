package nl.eimertvink.repository;

import nl.eimertvink.model.Department;

import java.util.List;


public interface DepartmentRepository {
    List<Department> findAll();

    List<Department> getAverageSalary();
}

/*
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> getByName(String name);

//    Void update(String Name, String position, String department, Float salary);

    void deleteByName(String name);

    List<Employee> findAll();

    void delete(Employee employee);

    void deleteById(Integer id);
}




	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ManufacturerJpaRepository manufacturerJpaRepository;
 */
