package com.eduhub.eduhub_backend.Component;

public class Course {

    private String courseCode;
    private String subjectName;
    private int credits;

    // Default constructor
    public Course() {

    }

    // Parameterized constructor
    public Course(String courseCode, String subjectName, int credits) {
        this.courseCode = courseCode;
        this.subjectName = subjectName;
        this.credits = credits;
    }

    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}