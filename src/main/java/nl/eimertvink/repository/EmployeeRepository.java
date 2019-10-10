package nl.eimertvink.repository;


import nl.eimertvink.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e " +
            " where (lower(coalesce(e.name, ' ')) like lower(concat('%', :filter, '%'))" +
            " or (lower(coalesce(e.position, ' ')) like lower(concat('%', :filter, '%'))))" )
    Page<Employee> findByFilter(@Param("filter") String filter, Pageable pageable);
}
