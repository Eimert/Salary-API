package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.CustomizedEmployeeRepository;
import nl.eimertvink.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 * service layer has the business logic
 *
 * @Primary because:
 * Field employeeservice in nl.eimertvink.controller.EmployeeController required a single bean, but 2 were found:
	- employeeServiceImpl: defined in file [/home/eimert/IdeaProjects/salary-api/target/classes/nl/eimertvink/service/EmployeeServiceImpl.class]
	- employeeService: defined in null
 */
@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CustomizedEmployeeRepository customizedEmployeeRepository;

//    @Autowired
//    @EnableJpaRepositories(basePackages="nl.eimertvink", entityManagerFactoryRef="emf")
//    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
//        System.out.println("We are using setter injection");
//        this.employeeRepository = employeeRepository;
//    }

    @Override
    public <S extends Employee> S save(S s) {
        return employeeRepository.save(s);
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteAll(Iterable<? extends Employee> iterable) {

    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public String topInternalEarner() {
        return customizedEmployeeRepository.topInternalEarner();
    }
}
