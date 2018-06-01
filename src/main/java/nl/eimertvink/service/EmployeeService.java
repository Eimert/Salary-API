package nl.eimertvink.service;

import nl.eimertvink.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    String topInternalEarner();
}
