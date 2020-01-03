package nl.eimertvink.rest.controller;

import nl.eimertvink.entity.Employee;
import nl.eimertvink.rest.dto.EmployeeDto;
import nl.eimertvink.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController extends AbstractController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<EmployeeDto> getEmployees(@RequestParam(required = false) String filter,
                                          @PageableDefault(sort = {"name"}) Pageable pageable) {
//        return convertToDtoPage(employeeService.findByFilter(filter, pageable), this::convert, pageable);
        return convertToDtoPage(employeeService.findAll(pageable), this::convert, pageable);
    }

    private EmployeeDto convert(Employee employee) {
        return new EmployeeDto(employee);
    }

}
