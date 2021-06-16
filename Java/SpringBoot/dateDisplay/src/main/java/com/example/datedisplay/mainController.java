package com.example.datedisplay;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class mainController {

    @RequestMapping("/")
    public String rendermain() {
        return "WEB-INF/home.jsp";
    }

    @RequestMapping("/time")
    public String rendertime(Model model) {
        Date time=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        System.out.println(sdf.format(time));
        model.addAttribute("time", sdf.format(time));
        return "WEB-INF/time.jsp";
    }

    @RequestMapping("/date")
    public String renderdate(Model model) {
        Date date = new Date();
        model.addAttribute("date", date);
        return "WEB-INF/date.jsp";
    }


}
