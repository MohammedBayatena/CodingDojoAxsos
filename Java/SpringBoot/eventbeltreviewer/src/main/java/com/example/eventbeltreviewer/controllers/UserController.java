package com.example.eventbeltreviewer.controllers;


import com.example.eventbeltreviewer.models.Event;
import com.example.eventbeltreviewer.models.User;
import com.example.eventbeltreviewer.services.EventService;
import com.example.eventbeltreviewer.services.UserService;
import com.example.eventbeltreviewer.validators.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final EventService eventService;
    private final UserValidator userValidator;

    public UserController(UserService userService, EventService eventService, UserValidator userValidator) {
        this.userService = userService;
        this.eventService = eventService;
        this.userValidator = userValidator;
    }

    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
        if (session.getAttribute("userid") != null) {
            return "redirect:/events";
        }
        return "index.jsp";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
        userValidator.validate(user, result); // Validator Here -------------------------
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            userService.registerUser(user);
            session.setAttribute("userid", user.getId());
            return "redirect:/events";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page

        if (userService.authenticateUser(email, password)) {
            User user = userService.findByEmail(email);
            session.setAttribute("userid", user.getId());
            return "redirect:/events";
        } else {
            redirectAttributes.addFlashAttribute("loginerrors", "Wrong Password or Email !");
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/events")
    public String renderHome(Model model, HttpSession session, @ModelAttribute("event") Event event) {
        try {
            Long id = (Long) session.getAttribute("userid");
            model.addAttribute("user", userService.findUserById(id));
        } catch (Exception e) {
            System.out.println("Error in retrieving from session or getting user from database");
            return "redirect:/";
        }
        Long id = (Long) session.getAttribute("userid");
        User user = userService.findUserById(id);
        List<Event> nearbyevents = eventService.getinState(user.getState());
        List<Event> farevents = eventService.getnotinState(user.getState());
        model.addAttribute("nearbyevents", nearbyevents);
        model.addAttribute("farevents", farevents);
        return "homePage.jsp";
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public String newEvent(Model model, HttpSession session, @Valid @ModelAttribute("event") Event event, BindingResult result) {
        try {
            Long id = (Long) session.getAttribute("userid");
            model.addAttribute("user", userService.findUserById(id));
        } catch (Exception e) {
            System.out.println("Error in retrieving from session or getting user from database");
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return "homePage.jsp";
        } else {
            try {
                Long id = (Long) session.getAttribute("userid");
                User host = userService.findUserById(id);
                event.setHost(host);
                eventService.createEvent(event);
            } catch (Exception e) {
                System.out.println("Error in retrieving from session or getting user from database");
                return "redirect:/";
            }
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

    @RequestMapping("/join/{id}")
    public String joinEvent(@PathVariable("id") Long eventid, HttpSession session) {
        Long userid = (Long) session.getAttribute("userid");
        Event event = eventService.findEventById(eventid);
        User user = userService.findUserById(userid);
        event.getUsers().add(user);
        eventService.createEvent(event);
        return "redirect:/";
    }

    @RequestMapping("/cancel/{id}")
    public String cancelJoinEvent(@PathVariable("id") Long eventid, HttpSession session) {
        Long userid = (Long) session.getAttribute("userid");
        Event event = eventService.findEventById(eventid);
        User user = userService.findUserById(userid);
        event.getUsers().remove(user);
        eventService.createEvent(event);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long eventid) {
        eventService.deleteEvent(eventid);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String renderEditEvent(@PathVariable("id") Long eventid,
                                  @ModelAttribute("event") Event event,
                                  Model model,
                                  HttpSession session) {

        User user = userService.findUserById((Long) session.getAttribute("userid"));
        Event curevent = eventService.findEventById(eventid);
        if (session.isNew()) {
            return "redirect:/";
        }
        if (curevent.getHost() != user) {
            return "redirect:/";
        }
        model.addAttribute("eventdata", eventService.findEventById(eventid));
        return "editevent.jsp";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String EditEvent(@PathVariable("id") Long eventid,
                            @Valid @ModelAttribute("event") Event event, BindingResult result,
                            Model model) {
        model.addAttribute("eventdata", eventService.findEventById(eventid));
        Event curevent = eventService.findEventById(eventid);
        if (result.hasErrors()) {
            return "editevent.jsp";
        } else {
            curevent.setName(event.getName());
            curevent.setEventDate(event.getEventDate());
            curevent.setLocation(event.getLocation());
            curevent.setState(event.getState());
            eventService.createEvent(curevent);
            return "redirect:/";
        }
    }

}

