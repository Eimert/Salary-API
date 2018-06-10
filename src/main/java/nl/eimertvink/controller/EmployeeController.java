package nl.eimertvink.controller;

import nl.eimertvink.model.Employee;
import nl.eimertvink.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

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

    @RequestMapping(value = "/deleteall", method = RequestMethod.GET)
    public @ResponseBody String deleteAll() {
        employeeservice.deleteAll();
        return "Emptied db";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public @ResponseBody String delete(Employee employee) {
        // to-do: check existsById before delete.
        employeeservice.delete(employee);
        return "Deleted employee.";
    }

    @RequestMapping(value = "/deletebyid", method = RequestMethod.GET)
    public @ResponseBody String deleteById(Integer id) {
        // to-do: check existsById before delete.
        employeeservice.deleteById(id);
        return "Deleted employee with id=" + id;
    }

    @RequestMapping(value = "/trumpmode", method = RequestMethod.GET)
    public String trumpMode() {
        Random rand = new Random();
        // to-do: on max(id). check existsById before delete.
        int i = rand.nextInt(32180) + 1;
        deleteById(i);
        return "Trump fired Employee with id=" + i;
    }
//    public @ResponseBody String deleteById(Integer id) {
//        employeeservice.deleteById(id);
//        return "Deleted employee with id=" + id;
//    }

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
//        System.out.println(e);
        employeeservice.save(e);
        return "Saved";
    }

    @RequestMapping("/topinternalearner")
    public @ResponseBody String topInternalEarner() {
        return "<html><body>City of Chicago' Top Internal Earner: " + employeeservice.topInternalEarner() + " <br> <a href='/'>back to home</a></body></html>";
    }

    @RequestMapping(value="/deletebyname", method = RequestMethod.GET)
    public @ResponseBody String deleteByName(@RequestParam String name) {
        employeeservice.deleteByName(name);
        return "Deleted employee called=" + name;
    }


}
