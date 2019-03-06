package com.fedex.homeworkapp.controllers;

import com.fedex.homeworkapp.homework.Homework;
import com.fedex.homeworkapp.homework.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TeacherController {

    private HomeworkService homeworkService;

    @Autowired
    public TeacherController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping("students")
    public List<Student> getAllRegisteredStudents() {
        return (List<Student>) students;
    }

    @GetMapping("homeworks")
    public List<Homework> getAllHomeworks() {
        return homeworkService.getAllHomework();
    }
}
