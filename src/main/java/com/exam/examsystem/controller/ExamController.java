package com.exam.examsystem.controller;

import com.exam.examsystem.model.Exam;
import com.exam.examsystem.service.ExamService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService service;

    public ExamController(ExamService service){

        this.service=service;
    }
    @PostMapping
    public Exam create (@RequestBody Exam exam){

        return service.createexam(exam);
    }
    @GetMapping
    public List<Exam> getAll(){

        return service.getAll();
    }
}
