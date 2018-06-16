package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String queryByMaxInternalSalary() {
        return employeeRepository.queryByMaxInternalSalary();
    }

    @Override
    public void deleteByName(String name) {
        employeeRepository.deleteByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
//        return Optional.empty();
    }

    @Override
    public Employee getOne(Integer id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public List<String> findDistinctEmployeeByDepartmentLike(String departmentName) {
        return employeeRepository.findDistinctEmployeeByDepartmentLike(departmentName);
    }

    public String findOne(Integer id) {
        return id + "\t" +
                employeeRepository.getOne(id).getName() + "\t" +
                employeeRepository.getOne(id).getPosition() + "\t" +
                employeeRepository.getOne(id).getDepartment() + "\t" +
                "$" + employeeRepository.getOne(id).getSalary();
    }


    @Override
    public void saveAndFlush(Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteAll(Iterable<? extends Employee> iterable) {
        employeeRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    Page<Employee> queryByNameIgnoreCase(String name, Pageable page) {
        PageRequest.of(0, 100);
        return employeeRepository.queryByNameIgnoreCase(name, page);
    }

}
