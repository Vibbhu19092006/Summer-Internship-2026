package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.Component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudent() {

        List<Student> list = new ArrayList<>();

        list.add(new Student(1, "Ram", "Jack"));
        list.add(new Student(2, "Sam", "John"));
        list.add(new Student(3, "Arun", "Kumar"));

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}