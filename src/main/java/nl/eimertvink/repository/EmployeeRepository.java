package nl.eimertvink.repository;


import io.swagger.annotations.ApiOperation;
import nl.eimertvink.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@Repository
//@Api(tags = "Employee Entity", description = "Set of endpoints for Creating, Retrieving, Updating and Deleting Employees.")
//@RepositoryRestResource(path="employee", collectionResourceRel = "employee")
//@Import(SwaggerConfig.class)
@RepositoryRestResource(path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @ApiOperation("Find the top earner.")
    Employee findFirstByOrderBySalaryDesc();

    List<?> findBySalaryLessThan(@Param("salary") Float salary);
    List<?> findBySalaryGreaterThan(@Param("salary") Float salary);

    List<?> findByNameLikeIgnoreCase(@Param("name") String name);

}
