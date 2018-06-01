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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        // pass-through, without applying any business logic here.
        return employeeRepository.findAll();
    }

    @Override
    public String topInternalEarner() {
        return null;
    }


}
