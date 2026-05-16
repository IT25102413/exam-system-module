package com.exam.model;

// Demonstrates Abstraction: You cannot instantiate this class directly
public abstract class User {
    // Demonstrates Encapsulation: Fields are protected/private [cite: 17]
    protected String id;
    protected String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Encapsulation: Using public getters to access private data [cite: 17]
    public String getId() { return id; }
    public String getName() { return name; }
}
