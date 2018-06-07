package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * service layer has the business logic
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        System.out.println("We are using setter injection");
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findMe() {
        // pass-through, without applying any business logic here.
        return employeeRepository.findMe();
    }

    @Override
    public String topInternalEarner() {
        return employeeRepository.topInternalEarner();
    }

    @Override
    public List<Employee> listAllEmployees() {
        return employeeRepository.listAllEmployees();
    }

}
