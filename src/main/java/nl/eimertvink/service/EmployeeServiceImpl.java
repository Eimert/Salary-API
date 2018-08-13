package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getByName(String name) {
        return employeeRepository.getByName(name);
    }

    @Override
    public void deleteByName(String name) {
        employeeRepository.deleteByName(name);
    }

    @Override
    public String queryByMaxInternalSalary() {
        return employeeRepository.queryByMaxInternalSalary();
    }

    @Override
    public List<Employee> findTop5ByNameLike(String compulsoryNameFilter) {
        return employeeRepository.findTop5ByNameLike(compulsoryNameFilter);
    }

    @Override
    public Employee findFirstByNameLike(String compulsoryNameFilter) {
        return employeeRepository.findFirstByNameLike(compulsoryNameFilter);
    }

    @Override
    public List<String> findDistinctEmployeeByDepartmentLike(String departmentName) {
        return employeeRepository.findDistinctEmployeeByDepartmentLike(departmentName);
    }

    @Override
    public List<Employee> findBySalaryLessThan(Float num) {
        return employeeRepository.findBySalaryLessThan(num);
    }

    @Override
    public List<Employee> findBySalaryLessThanEqual(Float num) {
        return employeeRepository.findBySalaryLessThan(num);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Float num) {
        return employeeRepository.findBySalaryGreaterThan(num);
    }

    @Override
    public List<Employee> findBySalaryGreaterThanEqual(Float num) {
        return employeeRepository.findBySalaryGreaterThanEqual(num);
    }

    @Override
    public Employee findFirstByDepartmentLike(String departmentName) {
        return findFirstByDepartmentLike(departmentName);
    }

    @Override
    public Page<Employee> queryByNameIgnoreCase(String name, Pageable page) {
        return employeeRepository.queryByNameIgnoreCase(name, page);
    }

    @Override
    public List<Employee> findByNameLikeIgnoreCase(String name) {
        return employeeRepository.findByNameLikeIgnoreCase(name);
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return employeeRepository.findAll(sort);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public <S extends Employee> S saveAndFlush(S s) {
        return employeeRepository.saveAndFlush(s);
    }
}
