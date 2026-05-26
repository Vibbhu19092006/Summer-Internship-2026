package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.Component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/student")
    public ResponseEntity<Student> getstudent() {

        Student student = new Student(1, "Ram", "Jack");

        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}