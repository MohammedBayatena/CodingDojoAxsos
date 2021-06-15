package com.example.human;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {
    @RequestMapping("/")
    public String drawmain(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name == null) {
            name = "Unknown";
        } else if (name.equals("")) {
            name = "EmptyField";
        }
        model.addAttribute("name", name);
        return "home.jsp";
    }


}
