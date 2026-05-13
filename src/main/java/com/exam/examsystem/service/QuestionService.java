package com.exam.examsystem.service;

import com.exam.examsystem.repository.QuestionRepository;
import com.exam.examsystem.model.Question;
import com.exam.examsystem.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public Question addQuestion(Question q) {
        return repo.save(q);
    }

    public List<Question> getAll() {
        return repo.findAll();
    }
}