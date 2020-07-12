package nl.eimertvink.repository;


import nl.eimertvink.entity.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, Integer> {


}
