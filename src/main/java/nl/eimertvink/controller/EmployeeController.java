package nl.eimertvink.controller;

import nl.eimertvink.model.Employee;
import nl.eimertvink.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable list(Model model) {
        Iterable<Employee> employeeList = employeeservice.listAllEmployees();
        return employeeList;
    }

    @RequestMapping("/topinternalearner")
    @ResponseBody
    public String topInternalEarner() {
        return "<html><body> City of Chicago' Top Internal Earner: " + employeeservice.topInternalEarner() + " <br> <a href='/'>back to home</a>  </body></html>";
    }

}
