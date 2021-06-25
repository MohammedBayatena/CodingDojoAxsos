package com.example.relationships.controllers;

import com.example.relationships.models.License;
import com.example.relationships.services.licenseService;
import com.example.relationships.services.personService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class licenseController {

    private final personService personServ;
    private final licenseService licenseServ;

    public licenseController(personService personServ, licenseService licenseServ) {
        this.personServ = personServ;
        this.licenseServ = licenseServ;
    }

    @RequestMapping("/licenses/new")
    public String RenderNew(@ModelAttribute(name = "license") License license, Model model) {
        model.addAttribute("persons", personServ.getAll());
        return "newlicense.jsp";
    }

    @RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
    public String createNew(@ModelAttribute(name = "license") License license, Model model) {
        //Do licence logic here
//        license.setNumber("xx");
        licenseServ.createLicense(license);
        String number = String.format("%06d", license.getId());
        license.setNumber(number);
        licenseServ.updateLicense(license);
        model.addAttribute("persons", personServ.getAll());
        return "redirect:/licenses/new";
    }


}
