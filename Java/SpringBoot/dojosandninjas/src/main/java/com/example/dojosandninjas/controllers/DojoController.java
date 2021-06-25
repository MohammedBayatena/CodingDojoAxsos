package com.example.dojosandninjas.controllers;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.services.DojoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
public class DojoController {

    private final DojoService dojoServ;

    public DojoController(DojoService dojoServ) {
        this.dojoServ = dojoServ;
    }


    @RequestMapping("dojos/new")
    public String renderNew(@ModelAttribute(name = "dojo") Dojo dojo) {
        return "newdojo.jsp";
    }

    @RequestMapping(value = "dojos/new", method = RequestMethod.POST)
    public String createNew(@ModelAttribute(name = "dojo") Dojo dojo) {

        //Do logic Here
        dojoServ.createDojo(dojo);

        return "redirect:/dojos/new";
    }

    @RequestMapping("dojos/{id}")
    public String renderdojoinfo(Model model, @PathVariable(name = "id") Long id) {

        Dojo dojo = dojoServ.findDojoById(id);
        if (dojo == null) {
            return "redirect:/dojos/new";
        } else {
            model.addAttribute("dojo", dojo);
            return "dojoinfo.jsp";
        }
    }

    @RequestMapping("/")
    public String renderInfo(Model model) {

        List<Dojo> dojos = dojoServ.getAllDojos();
        HashMap<String, Long> info = new HashMap<>();

        for (Dojo item : dojos) {
            info.put(item.getName(), Long.parseLong(String.valueOf(item.getNinjas().size())));
//            info.put(item.getName(), dojoServ.nativequery(item.getId()));
//            info.put(item.getName(), dojoServ.jpqlquery(item.getId()));
        }
        model.addAttribute("info", info);

        return "information.jsp";


    }


}
