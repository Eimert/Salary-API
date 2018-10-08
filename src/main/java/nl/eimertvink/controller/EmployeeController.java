package nl.eimertvink.controller;

import nl.eimertvink.configuration.CustomErrorType;
import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addemployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        // to-do: throw neat exception when book already exists.
        if (employeeRepository.findById(employee.getId()) != null)
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Employee with id=" + employee.getId() + " does already exist."), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(employeeRepository.saveAndFlush(employee), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody Iterable<Employee> list() {
        return employeeRepository.findAll();
    }

//    @RequestMapping(value = "/deleteall", method = RequestMethod.GET)
//    public @ResponseBody Department deleteAll() {
//        employeeservice.deleteAll();
//        return "Emptied db";
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public @ResponseBody Department delete(Employee employee) {
//        // to-do: check existsById before delete.
//        employeeservice.delete(employee);
//        return "Deleted employee.";
//    }
//
//    @RequestMapping(value = "/deletebyid", method = RequestMethod.DELETE)
//    public @ResponseBody String deleteById(Integer id) {
//        // to-do: check existsById before delete.
//        employeeRepository.deleteById(id);
//        return "Deleted employee with id=" + id;
//    }
//
//    @RequestMapping(value = "/trumpmode", method = RequestMethod.GET)
//    public Department trumpMode() {
//        Random rand = new Random();
//        // to-do: on max(id). check existsById before delete.
//        int i = rand.nextInt(32180) + 1;
//        deleteById(i);
//        return "Trump fired Employee with id=" + i;
//    }
////    public @ResponseBody Department deleteById(Integer id) {
////        employeeservice.deleteById(id);
////        return "Deleted employee with id=" + id;
////    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public @ResponseBody Department addNewEmployee (@RequestParam Department name,
//                                                @RequestParam Department position,
//                                                @RequestParam Department department,
//                                                @RequestParam Float salary) {
//        Employee e = new Employee();
//        e.setName(name);
//        e.setPosition(position);
//        e.setDepartment(department);
//        e.setSalary(salary);
////        System.out.println(e);
//        employeeservice.save(e);
//        return "Saved";
//    }

    @RequestMapping("/maxinternalsalary")
    public @ResponseBody String queryByMaxInternalSalary() {
        return "<html><body>City of Chicago' Top Internal Earner: " + employeeRepository.queryByMaxInternalSalary() + " <br> <a href='/'>back to home</a></body></html>";
    }

    @RequestMapping(value="/deletebyname", method = RequestMethod.GET)
    public @ResponseBody String deleteByName(@RequestParam String name) {
        employeeRepository.deleteByName(name);
        return "Deleted employee called=" + name;
    }

//    @RequestMapping(value = "/get", method = { RequestMethod.GET, RequestMethod.POST })
//    public @ResponseBody String findOne(@RequestParam Integer id) {
//        return employeeRepository.findOne(id);
//    }
//
//    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
//    public @ResponseBody String updateEmployee(@RequestBody Employee employee) {
//        System.out.println("updating " + employee);
//        Optional<Employee> emp = employeeRepository.f
//
//        Employee emp = employeeRepository.getOne(id);
//        String oldName = emp.getName();
//        emp.setName(name);
//        employeeRepository.saveAndFlush(emp);
//        return "updated oldname=" + oldName + " newname=" + employeeRepository.getOne(id).getName();
//    }


    @RequestMapping(value = "/getname", method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody
    List<Employee> queryByNameIgnoreCase(@RequestParam String name) {
        Page<Employee> emps = employeeRepository.queryByNameIgnoreCase(name, PageRequest.of(0, 100));
        return emps.getContent();
    }

    @RequestMapping(value = "/findbyname", method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Employee findFirstByNameLike(@RequestParam String name) {
        return employeeRepository.findFirstByNameLike(name);
    }

}
