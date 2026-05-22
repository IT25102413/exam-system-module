//package com.exam.examsystem.controller;
//
//import com.exam.examsystem.model.Question;
//import com.exam.examsystem.service.QuestionService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class PageController {
//    private final QuestionService service;
//
//    public PageController(QuestionService service){
//        this.service=service;
//    }
//
//    @GetMapping("/add-question")
//    public String addQuestionPage(){
//        return "add-question";
//    }
//    @PostMapping("/questions/save")
//    public String saveQuestion(@ModelAttribute Question q){
//        service.addQuestion(q);
//        return "redirect:/add-question";
//    }
//}
