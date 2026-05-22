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
import com.exam.examsystem.model.Exam;
import com.exam.examsystem.service.ExamService;

@Controller
public class PageController {
    private final QuestionService service;
    private final ExamService examService;

    public PageController(QuestionService service,ExamService examService){
        this.service=service;
        this.examService=examService;
    }

    @GetMapping("/add-question")
    public String addQuestionPage(Model model) {
        List<Exam>exams=examService.getAll();
        model.addAttribute("exams",exams);
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

    @GetMapping("/select-exam")
        public String selectExam(){
        return "select-exam";
    }
    @PostMapping("/save-exam")
    public String saveExam (@ModelAttribute Exam exam){
        Exam savedExam=examService.saveExam(exam);
        return "redirect:/add-question?examId=" + savedExam.getId();
    }

}
