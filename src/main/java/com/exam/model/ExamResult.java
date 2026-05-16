package com.exam.model;

public class ExamResult {
    private String studentId;
    private String examName;
    private int score;
    private String grade;
    private String comment;

    public ExamResult(String studentId, String examName, int score, String grade,String comment) {
        this.studentId = studentId;
        this.examName = examName;
        this.score = score;
        this.grade = grade;
        this.comment = comment;
    }

    // These will be used for File Handling later [cite: 109]
    public String getStudentId() {
        return studentId;
    }
    public String getExamName() {
        return examName;
    }
    public int getScore() {
        return score;
    }
    public String getGrade() {
        return grade;
    }
    public String getComment(){
        return comment;
    }
}