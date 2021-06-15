package com.example.gettingfamiliar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {

    @RequestMapping("")
    public String handleRoot() {
        return "Hello Coding Dojo!";
    }

    @RequestMapping("python")
    public String handlePython() {
        return "Python/Django was awesome!";
    }

    @RequestMapping("java")
    public String handleJava() {
        return "Java/Spring is better!";
    }


}
