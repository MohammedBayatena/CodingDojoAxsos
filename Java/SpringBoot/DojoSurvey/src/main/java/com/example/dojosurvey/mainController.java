package com.example.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class mainController {

    @RequestMapping("/")
    public String redirect() {
        return "redirect:/render";
    }

    @RequestMapping("/render")
    public String renderHome() {
        return "index.jsp";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String handleData(Model model, @RequestParam(value = "name") String name,
                             @RequestParam(value = "dojolocation") String dojolocation,
                             @RequestParam(value = "favlang") String favlang,
                             @RequestParam(value = "gridRadios") String gridRadios,
                             @RequestParam(value = "comments") String comments,
                             @RequestParam(value = "gridCheck") String gridCheck) {

        model.addAttribute("name", name);
        model.addAttribute("dojolocation", dojolocation);
        model.addAttribute("favlang", favlang);
        model.addAttribute("gender", gridRadios);
        model.addAttribute("comments", comments);
        model.addAttribute("hearaboutus", gridCheck);

        return "info.jsp";
    }


}
