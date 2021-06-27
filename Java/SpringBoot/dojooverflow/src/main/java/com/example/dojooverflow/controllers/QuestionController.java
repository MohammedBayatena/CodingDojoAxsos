package com.example.dojooverflow.controllers;


import com.example.dojooverflow.models.Answer;
import com.example.dojooverflow.models.Question;
import com.example.dojooverflow.models.Tag;
import com.example.dojooverflow.services.QuestionService;
import com.example.dojooverflow.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    private final TagService tagServ;
    private final QuestionService questionServ;
    private final AnswerService answerServ;

    public QuestionController(TagService tagServ, QuestionService questionServ, AnswerService answerServ) {
        this.tagServ = tagServ;
        this.questionServ = questionServ;
        this.answerServ = answerServ;
    }

    @RequestMapping("/questions")
    public String renderDashboard(Model model) {
        model.addAttribute("questions", questionServ.getall());
        return "questions.jsp";
    }

    @RequestMapping("/questions/new")
    public String renderNew() {
        return "newquestion.jsp";
    }

    @RequestMapping(value = "/questions/new", method = RequestMethod.POST)
    public String addNew(@RequestParam(name = "tags") String tags,
                         @RequestParam(name = "text") String text, RedirectAttributes redirectAttributes,
                         Model model
    ) {
        int error = 0;
        if (tags.equals("")) {
            redirectAttributes.addFlashAttribute("tagerror", "Enter at least 1 tag!");
            error = 1;
        } else if (!tags.matches("^[a-z]+[0-9]*(,[a-z]+[0-9]*)?(,[a-z]+[0-9]*)?$")) {
            error = 1;
            long count = tags.chars().filter(ch -> ch == ',').count();
            if (count > 2) {
                redirectAttributes.addFlashAttribute("tagerror", "Question can at max have 3 tags");
            } else {
                redirectAttributes.addFlashAttribute("tagerror", "multiple tags should be lowercase comma separated values with no spaces ");
            }
        }
        if (text.equals("")) {
            error = 1;
            redirectAttributes.addFlashAttribute("texterror", "Question can not be empty!");
        }
        if (error == 0) {
            Question question = new Question();
            question.setText(text);
            List<Tag> tagslist = new ArrayList<>();
            for (String tag : tags.split(",")) {
                Tag t = new Tag();
                t.setSubject(tag);
                if (tagServ.createTag(t) != null) {
                    tagslist.add(t); // Transient data cause there is an object
                    // in this list but the database doesn't have it
                }
            }
            question.setTags(tagslist);
            questionServ.createQuestion(question);
        }
        return "redirect:/questions/new";
    }

    @RequestMapping("/questions/{id}")
    //dont mix names inside model attribute and the attributes inside the model attribute
    public String renderInfo(@ModelAttribute("answero") Answer answer, Model model, @PathVariable("id") Long id) {
        Question question = questionServ.getQuestion(id);
        if (question == null) {
            return "redirect:/questions/new";
        }
        model.addAttribute("question", question);
        return "questioninfo.jsp";
    }

    @RequestMapping(value = "/questions/{id}", method = RequestMethod.POST)
    public String addanswer(@Valid @ModelAttribute("answero") Answer answer, BindingResult result, Model model, @PathVariable("id") Long id) {
        Question question = questionServ.getQuestion(id);
        if (question == null) {
            return "redirect:/questions/new";
        }
        model.addAttribute("question", question);

        if (result.hasErrors()) {
            return "questioninfo.jsp";
        } else {
            answer.setQuestion(question);
            answerServ.createAnswer(answer);
//            question.getAnswers().add(answer);
//            questionServ.createQuestion(question);
//            System.out.println(question.getAnswers());
            //TODO Find Why it adds from the filed and not from the list too like previous assignment
        }
        return "redirect:/questions/" + id;
    }

}
