package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    @Override
//    public void deleteById(Integer id) {
//        employeeRepository.deleteById(id);
//    }
    @Override
    public String getOne(Integer id) {
        return employeeRepository.getOne(id).getName() + "\t" +
                employeeRepository.getOne(id).getPosition() + "\t" +
                employeeRepository.getOne(id).getDepartment() + "\t" +
                "$" + employeeRepository.getOne(id).getSalary();
    }

    Page<Employee> queryByNameIgnoreCase(String name, Pageable page) {
        PageRequest.of(0, 100);

        return employeeRepository.queryByNameIgnoreCase(name, page);
    }

}
