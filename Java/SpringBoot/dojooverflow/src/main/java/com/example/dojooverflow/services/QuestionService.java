package com.example.dojooverflow.services;

import com.example.dojooverflow.models.Question;
import com.example.dojooverflow.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepo;

    public QuestionService(QuestionRepository questionRepo) {
        this.questionRepo = questionRepo;
    }


    public Question createQuestion(Question q) {
        questionRepo.save(q);
        return q;
    }

    public List<Question> getall() {
        return questionRepo.findAll();
    }

    public Question getQuestion(Long id) {
        Optional<Question> question = questionRepo.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            return null;
        }
    }
}
