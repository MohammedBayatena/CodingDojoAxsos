package com.example.human;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {
    @RequestMapping("/")
    public String drawmain(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "lastname", required = false) String lastname,
                           Model model) {
        if (name == null) {
            name = "Human";
        } else if (name.equals("")) {
            name = "Human";
        }
        if (lastname== null ){
            lastname="";
        }else if (lastname.equals("")){
            lastname="";
        }
        model.addAttribute("name", name);
        model.addAttribute("lastname", lastname);
        return "home.jsp";
    }


}
