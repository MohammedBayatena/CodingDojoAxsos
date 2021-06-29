package com.example.authentication.controllers;

import com.example.authentication.models.User;
import com.example.authentication.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "index.jsp";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route

        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            userService.registerUser(user);
            session.setAttribute("userid", user.getId());
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page

        if (userService.authenticateUser(email, password)) {
            try {
                User user = userService.findByEmail(email);
                session.setAttribute("userid", user.getId());
                model.addAttribute("user", user);
            } catch (Exception e) {
                System.out.println("Error in retrieving from session or adding user");
                return "redirect:/";
            }
            return "homePage.jsp";
        } else {
            System.out.println("wrong Combo");
            return "redirect:/";
        }
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
        try {
            Long userid = (Long) session.getAttribute("userid");
            User user = userService.findUserById(userid);
            model.addAttribute("user", user);
        } catch (Exception e) {
            System.out.println("Error in retrieving from session");
            return "redirect:/";
        }
        return "homePage.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
        session.invalidate();
        return "redirect:/";
    }

}



