package nl.eimertvink.service;

import nl.eimertvink.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();
    List<Department> getAverageSalary();
}
