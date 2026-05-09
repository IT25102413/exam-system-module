package com.exam.examauthsystem.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Student extends com.exam.examauthsystem.models.User {
    private String indexNumber;
}