package com.fedex.homeworkapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeacherController {

    @GetMapping("/students")
    public List<Student> getAllRegisteredStudents() {
        return (List<Student>) students;
    }

    @GetMapping("/homeworks")
    public List<Homework> getAllHomeworks() {
        return (List<Homework>) homeworks;
    }
}
