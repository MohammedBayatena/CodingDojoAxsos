package com.example.dojooverflow.controllers;

import com.example.dojooverflow.AnswerRepository;
import com.example.dojooverflow.models.Answer;
import org.springframework.stereotype.Controller;

@Controller
public class AnswerService {

    private final AnswerRepository answerRepo;

    public AnswerService(AnswerRepository answerRepo) {
        this.answerRepo = answerRepo;
    }

    Answer createAnswer(Answer a) {
        answerRepo.save(a);
        return a;
    }

}
