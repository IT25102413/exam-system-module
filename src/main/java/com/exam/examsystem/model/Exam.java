package com.exam.examsystem.model;
import jakarta.persistence.*;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String exam_name;
    private int duration;

    public Exam(){}

    public long getId() {
        return id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
