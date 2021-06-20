package com.example.languages.controllers;


import com.example.languages.models.Language;
import com.example.languages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/languages")
    public String renderHome(@ModelAttribute("language") Language language, Model model) {

        List<Language> languages = languageService.getAllLanguages();
        model.addAttribute("languages", languages);
        return "home.jsp";
    }

    //CREATE LANGUAGE
    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("languages", languageService.getAllLanguages());
            return "home.jsp";
        } else {
            languageService.addLanguage(language);
            return ("redirect:/languages");
        }
    }
    //does rendering
    @RequestMapping("/languages/{id}/edit")
    public String renderEdit(@ModelAttribute("language") Language language,
                             @PathVariable(value = "id") Long id,
                             Model model) {
        model.addAttribute("lang", languageService.findLanguage(id));
        return "edit.jsp";
    }

    //UPDATE LANGUAGE (PUT)
    @RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)
    public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result,
                                 @PathVariable(value = "id") Long id,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("lang", languageService.findLanguage(id));
            return "edit.jsp";
        } else {
            languageService.editLanguage(language);
            return ("redirect:/languages");
        }
    }
    //Show Info (GET)
    @RequestMapping("/languages/{id}")
    public String renderInfo(Model model, @PathVariable(value = "id") Long id) {
        Language language = languageService.findLanguage(id);
        if (language == null) {
            return "redirect:/languages";
        } else {
            model.addAttribute("lang", language);
            return "info.jsp";
        }
    }
    //delete language (DELETE)
    @RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
    public String deleteLanguage(@PathVariable(value = "id") Long id) {
        System.out.println(id);
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }


}
