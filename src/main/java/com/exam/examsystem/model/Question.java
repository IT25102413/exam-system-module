//package com.exam.examsystem.model;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Question {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String questionText;
//    private String optionA;
//    private String optionB;
//    private String optionC;
//    private String optionD;
//    private String correctAnswer;
//
//    @ManyToOne
//    @JoinColumn(name = "exam_id")
//    private Exam exam;
//
//    public Question() {}
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getQuestionText() {
//        return questionText;
//    }
//
//    public String getOptionA() {
//        return optionA;
//    }
//
//    public String getOptionB() {
//        return optionB;
//    }
//
//    public String getOptionC() {
//        return optionC;
//    }
//
//    public String getOptionD() {
//        return optionD;
//    }
//
//    public String getCorrectAnswer() {
//        return correctAnswer;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setQuestionText(String questionText) {
//        this.questionText = questionText;
//    }
//
//    public void setOptionA(String optionA) {
//        this.optionA = optionA;
//    }
//
//    public void setOptionB(String optionB) {
//        this.optionB = optionB;
//    }
//
//    public void setOptionC(String optionC) {
//        this.optionC = optionC;
//    }
//
//    public void setOptionD(String optionD) {
//        this.optionD = optionD;
//    }
//
//    public void setCorrectAnswer(String correctAnswer) {
//        this.correctAnswer = correctAnswer;
//    }
//}