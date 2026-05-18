package com.exam.examsystem.controller;

import com.exam.examsystem.model.Question;
import com.exam.examsystem.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    private final QuestionService service;

    public PageController(QuestionService service){
        this.service=service;
    }

    @GetMapping("/add-question")
    public String addQuestionPage(){
        return "add-question";
    }

    @PostMapping("/questions/save")
    public String saveQuestion(@ModelAttribute Question q){
        service.addQuestion(q);
        return "redirect:/add-question";
    }

    @GetMapping("/view-questions")
    public String viewQuestions(Model model){
        List<Question>questions=service.getAll();
        model.addAttribute("questions",questions);
        return "view-questions";
    }

    @GetMapping("/delete-question/{id}")
    public String deleteQuestion(@PathVariable long id){
        service.deleteQuestion(id);
        return "redirect:/view-questions";
    }

    @GetMapping("/edit-question/{id}")
    public String editQuestion(@PathVariable long id,Model model){
        Question question=service.getById(id);
        if (question==null){
            return "redirect:/view-questions";
        }
        model.addAttribute("question",question);
        return "edit-question";
    }

    @PostMapping("/update-question/{id}")
    public String updateQuestion (@PathVariable long id,@ModelAttribute Question question){
        service.updateQuestion(id,question);
        return "redirect:/view-questions";
    }
}
