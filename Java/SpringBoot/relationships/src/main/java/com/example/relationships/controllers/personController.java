package com.example.relationships.controllers;


import com.example.relationships.models.Person;
import com.example.relationships.services.personService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class personController {

    private final personService personServ;

    public personController(personService personServ) {
        this.personServ = personServ;
    }

    @RequestMapping("persons/new")
    public String renderNew(@ModelAttribute(name = "person") Person person) {
        return "newperson.jsp";
    }

    @RequestMapping(value = "persons/new", method = RequestMethod.POST)
    public String createNew(@ModelAttribute(name = "person") Person person) {
        //Create HERE if no errors
        personServ.createPerson(person);
        return "newperson.jsp";
    }

    @RequestMapping("/persons/{id}")
    public String renderPerson(Model model, @PathVariable(name = "id") Long id) {

        //Do logic Here
        model.addAttribute("person", personServ.getPerson(id));
        if (personServ.getPerson(id) != null) {
            return "personinfo.jsp";
        } else {
            return "redirect:/persons/new";
        }
    }
}
