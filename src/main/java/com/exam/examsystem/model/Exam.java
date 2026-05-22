package com.exam.examsystem.model;
import jakarta.persistence.*;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String examName;


    public Exam(){}

    public long getId() {
        return id;
    }

    public String getExamName() {
        return examName;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

}
