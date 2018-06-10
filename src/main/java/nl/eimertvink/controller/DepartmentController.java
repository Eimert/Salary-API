package nl.eimertvink.controller;

import nl.eimertvink.model.Department;
import nl.eimertvink.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody List<Department> findAll() {
        return departmentService.findAll();

    }

    @RequestMapping(value="/getaveragesalary", method = RequestMethod.GET)
    public @ResponseBody List<Department> getAverageSalary() {
        return departmentService.getAverageSalary();
    }

}
