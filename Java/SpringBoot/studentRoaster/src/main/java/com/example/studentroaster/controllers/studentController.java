package com.example.studentroaster.controllers;

import com.example.studentroaster.models.Student;
import com.example.studentroaster.services.studentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class studentController {

    private final studentService studentserv;

    public studentController(studentService studentserv) {
        this.studentserv = studentserv;
    }


    @RequestMapping("students/new")
    public String renderNew(@ModelAttribute(name = "student") Student student, Model model) {
        return "studentNew.jsp";
    }

    @RequestMapping(value = "students/new", method = RequestMethod.POST)
    public String addNew(@ModelAttribute(name = "student") Student student, Model model) {

        //Do Creation Logic Here
        studentserv.CreateStudent(student);
        return "redirect:/students/new";
    }

    @RequestMapping("/students")
    public String renderStudents(Model model) {

        model.addAttribute("students", studentserv.getAllStudents());

        return "studentslist.jsp";
    }


}
