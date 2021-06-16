package com.example.thecode;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class mainController {

    @RequestMapping("/")
    public String homepagehandler() {
        return "WEB-INF/home.jsp";
    }

    @RequestMapping(value = "/secret", method = RequestMethod.POST)
    public String secrethandler(@RequestParam(value = "code") String code) {

        if (code.equals("bushido")) {
            return "WEB-INF/secret.jsp";
        } else {
            return "redirect:/wrong";
        }
    }

    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public String secretredirect() {
        return "redirect:/";
    }

    @RequestMapping("/wrong")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "You must train harder!");
        return "redirect:/";
    }
}
