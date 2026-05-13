package com.exam.examsystem.service;

import com.exam.examsystem.model.Exam;
import com.exam.examsystem.repository.ExamRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExamService {
    private final ExamRepository repo;

    public ExamService(ExamRepository repo){

        this.repo=repo;
    }
    public Exam createexam(Exam exam){

        return repo.save(exam);
    }
    public List <Exam> getAll(){

        return repo.findAll();
    }
}
