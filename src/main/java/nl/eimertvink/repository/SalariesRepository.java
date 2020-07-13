package nl.eimertvink.repository;


import nl.eimertvink.entity.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface SalariesRepository extends JpaRepository<Salaries, Integer> {

}
