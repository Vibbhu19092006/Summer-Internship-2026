package com.eduhub.eduhub_backend.Component;

public class Student {

    public int id;
    public String firstname;
    public String lastname;

    // Default constructor
    public Student() {

    }

    // Parameterized constructor
    public Student(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Getter method
    public int getId() {
        return id;
    }
    public void intId(int id) {
        this.id = id;
    }
}