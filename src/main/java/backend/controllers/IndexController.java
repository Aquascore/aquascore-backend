package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping( value = "/")
    public String index(Model m){
        m.addAttribute("Body", "Index Body");
        return "index";
    }
}
