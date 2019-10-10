package nl.eimertvink.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
    @RequestMapping("/")
    public String home() {
        // redirect or forward
        return "redirect:/swagger-ui.html";
    }
}
