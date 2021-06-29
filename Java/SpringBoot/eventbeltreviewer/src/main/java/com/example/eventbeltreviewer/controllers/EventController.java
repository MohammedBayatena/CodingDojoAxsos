package com.example.eventbeltreviewer.controllers;


import com.example.eventbeltreviewer.models.Event;
import com.example.eventbeltreviewer.models.Message;
import com.example.eventbeltreviewer.models.User;
import com.example.eventbeltreviewer.services.EventService;
import com.example.eventbeltreviewer.services.MessageService;
import com.example.eventbeltreviewer.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EventController {

    private final UserService userService;
    private final EventService eventService;
    private final MessageService messageService;

    public EventController(UserService userService, EventService eventService, MessageService messageService) {
        this.userService = userService;
        this.eventService = eventService;
        this.messageService = messageService;
    }

    @RequestMapping(value = "/events/{id}")
    public String renderEventInfo(Model model, HttpSession session,
                                  @ModelAttribute("message") Message message,
                                  @PathVariable("id") Long id) {
        try {
            Event event = eventService.findEventById(id);
            model.addAttribute("event", event);
        } catch (Exception e) {
            System.out.println("Error in getting event from database");
            return "redirect:/";
        }
        return "eventinfo.jsp";
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.POST)
    public String newEvent(Model model, HttpSession session,
                           @Valid @ModelAttribute("message") Message message, BindingResult result,
                           @PathVariable("id") Long id) {

        try {
            Event event = eventService.findEventById(id);
            model.addAttribute("event", event);
            if (result.hasErrors()) {
                return "eventinfo.jsp";
            } else {
                Long userid = (Long) session.getAttribute("userid");
                User user = userService.findUserById(userid);
                message.setAuthor(user.getFirstName() + user.getLastName());
                event.addMessage(message);
//                message.setEvent(event);
                messageService.createMessage(message);
                
            }
        } catch (Exception e) {
            System.out.println("Error in retrieving event from database");
            return "redirect:/";
        }
        return "redirect:/events/" + id;
    }


}


