package nl.eimertvink.service;

import nl.eimertvink.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findMe();
    String topInternalEarner();
    List<Employee> listAllEmployees();
}
