package nl.eimertvink.controller;

import nl.eimertvink.model.Employee;
import nl.eimertvink.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable list(Model model) {
        Iterable<Employee> employeeList = employeeservice.findAll();
        return employeeList;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody String addNewEmployee (@RequestParam String name,
                                                @RequestParam String position,
                                                @RequestParam String department,
                                                @RequestParam Float salary) {
        Employee e = new Employee();
        e.setName(name);
        e.setPosition(position);
        e.setDepartment(department);
        e.setSalary(salary);
        System.out.println(e);
        employeeservice.save(e);
        return "Saved";
    }

//    @RequestMapping("/topinternalearner")
//    @ResponseBody
//    public String topInternalEarner() {
//        return "<html><body> City of Chicago' Top Internal Earner: " + employeeservice.topInternalEarner() + " <br> <a href='/'>back to home</a>  </body></html>";
//    }

}
