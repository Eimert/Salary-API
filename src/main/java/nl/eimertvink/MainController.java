package nl.eimertvink;

import nl.eimertvink.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello world <html><body><br> <a href='/topinternalearner'>top internal earner</a>  </body></html>";
    }

    @Autowired
    private EmployeeService employeeservice;

    @RequestMapping("/topinternalearner")
    @ResponseBody
    public String topInternalEarner() {
        return "<html><body> City of Chicago' Top Internal Earner: " + employeeservice.topInternalEarner() + " <br> <a href='/'>back to home</a>  </body></html>";
    }

}
