package com.example.counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class mainController {
    @RequestMapping("/")
    public String homeHandler(HttpSession session) {
        try {
            session.setAttribute("counter", (int) session.getAttribute("counter") + 1);
        } catch (NullPointerException e) {
            session.setAttribute("counter", 0);
        }
        return ("WEB-INF/home.jsp");
    }

    @RequestMapping("/counter")
    public String counterHandler(HttpSession session) {
        try {
            session.getAttribute("counter");
        } catch (NullPointerException e) {
            session.setAttribute("counter", 0);
        }
        return ("WEB-INF/counter.jsp");
    }

}
