package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.Component.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {


    List<Course> courseList = new ArrayList<>();

    public CourseController() {

        courseList.add(new Course("CS101", "Java", 4));
        courseList.add(new Course("CS102", "Python", 3));
        courseList.add(new Course("CS103", "DBMS", 4));
        courseList.add(new Course("CS104", "Operating System", 4));
        courseList.add(new Course("CS105", "Computer Networks", 3));
    }


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {

        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    // 4 & 5. Get particular course using PathVariable
    @GetMapping("/{courseCode}")
    public ResponseEntity<Course> getCourseByCode(
            @PathVariable String courseCode) {

        for (Course course : courseList) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return new ResponseEntity<>(course, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 5. Get course using RequestParam
    @GetMapping("/search")
    public ResponseEntity<Course> searchCourse(
            @RequestParam String code) {

        for (Course course : courseList) {

            if (course.getCourseCode().equalsIgnoreCase(code)) {
                return new ResponseEntity<>(course, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 6. Add new course
    @PostMapping
    public ResponseEntity<Course> addCourse(
            @RequestBody Course course) {

        courseList.add(course);

        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    // 7. Update a course
    @PutMapping("/{courseCode}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable String courseCode,
            @RequestBody Course updatedCourse) {

        for (Course course : courseList) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {

                course.setSubjectName(updatedCourse.getSubjectName());
                course.setCredits(updatedCourse.getCredits());

                return new ResponseEntity<>(course, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 8. Delete a course
    @DeleteMapping("/{courseCode}")
    public ResponseEntity<String> deleteCourse(
            @PathVariable String courseCode) {

        for (Course course : courseList) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {

                courseList.remove(course);

                return new ResponseEntity<>(
                        "Course Deleted Successfully",
                        HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(
                "Course Not Found",
                HttpStatus.NOT_FOUND);
    }
}