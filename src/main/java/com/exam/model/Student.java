package com.exam.model;

// Demonstrates Inheritance: Student inherits from User
public class Student extends User {
    private String email;

    public Student(String id, String name, String email) {
        // Calls the parent (User) constructor
        super(id, name);
        this.email = email;
    }

    public String getEmail() { return email; }
}