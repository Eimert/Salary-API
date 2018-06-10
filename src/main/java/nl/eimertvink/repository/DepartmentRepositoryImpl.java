package nl.eimertvink.repository;

import nl.eimertvink.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/*
 * SQL FROM 'Department'. Here's why: https://stackoverflow.com/questions/9954590/hibernate-error-querysyntaxexception-users-is-not-mapped-from-users
 */
@Component
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        List<Department> deps = entityManager
                .createQuery("select distinct(department) as department from Department order by department asc")
                .getResultList();
        return deps;
    }

    @Override
    public List<Department> getAverageSalary() {
        List<Department> avgSal = entityManager
                .createQuery("select department, avg(salary) AS SALARY from Department group by department order by salary desc")
                .getResultList();
        return avgSal;
    }

    /*
    	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ManufacturerJpaRepository manufacturerJpaRepository;
     */
}
