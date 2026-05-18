package com.exam.examsystem.service;

import com.exam.examsystem.repository.QuestionRepository;
import com.exam.examsystem.model.Question;
import com.exam.examsystem.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Question updateQuestion(Long id, Question updateQuestion) {
        Optional<Question> optionaQuestion = repo.findById(id);
        if (optionaQuestion.isPresent()) {
            Question existingQuestion = optionaQuestion.get();

            existingQuestion.setQuestionText(updateQuestion.getQuestionText());
            existingQuestion.setOptionA(updateQuestion.getOptionA());
            existingQuestion.setOptionB(updateQuestion.getOptionB());
            existingQuestion.setOptionC(updateQuestion.getOptionC());
            existingQuestion.setOptionD(updateQuestion.getOptionD());
            existingQuestion.setCorrectAnswer(updateQuestion.getCorrectAnswer());

            return repo.save(existingQuestion);
        } else {
            throw new RuntimeException("Question not found ");
        }
    }

    public void deleteQuestion(Long id){
        repo.deleteById(id);
    }

    public Question getById(Long id){
        return repo.findById(id).orElse(null);
    }
}