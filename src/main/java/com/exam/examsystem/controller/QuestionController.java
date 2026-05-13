package com.exam.examsystem.controller;

import com.exam.examsystem.service.QuestionService;
import com.exam.examsystem.model.Question;
import com.exam.examsystem.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {

        this.service = service;
    }

    @PostMapping
    public Question add(@RequestBody Question q) {

        return service.addQuestion(q);
    }

    @GetMapping
    public List<Question> getAll() {

        return service.getAll();
    }
}