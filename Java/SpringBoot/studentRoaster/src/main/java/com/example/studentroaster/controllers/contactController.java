package com.example.studentroaster.controllers;


import com.example.studentroaster.models.Contact;
import com.example.studentroaster.services.ContactService;
import com.example.studentroaster.services.studentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class contactController {

    private final ContactService contactServ;
    private studentService studentServ;


    public contactController(ContactService contactServ, studentService studentServ) {
        this.contactServ = contactServ;
        this.studentServ = studentServ;
    }

    @RequestMapping("contact/new")
    public String renderNew(@ModelAttribute(name = "contact") Contact contact, Model model) {
        model.addAttribute("students", studentServ.getnotmapped());
        return "contactNew.jsp";
    }

    @RequestMapping(value = "contact/new", method = RequestMethod.POST)
    public String addNew(@ModelAttribute(name = "contact") Contact contact, Model model) {
        model.addAttribute("students", studentServ.getnotmapped());
        contactServ.createContact(contact);
        return "redirect:/contact/new";
    }


}
