package com.example.dojosandninjas.controllers;


import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.services.DojoService;
import com.example.dojosandninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NinjaController {
    private final DojoService dojoServ;
    private final NinjaService ninjaServ;

    public NinjaController(DojoService dojoServ, NinjaService ninjaServ) {
        this.dojoServ = dojoServ;
        this.ninjaServ = ninjaServ;
    }


    @RequestMapping("ninjas/new")
    public String renderNew(@ModelAttribute(name = "ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoServ.getAllDojos());
        return "newninja.jsp";
    }

    @RequestMapping(value = "ninjas/new", method = RequestMethod.POST)
    public String addNew(@ModelAttribute(name = "ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoServ.getAllDojos());
        ninjaServ.createNinja(ninja);
        return "redirect:/ninjas/new";
    }


}
