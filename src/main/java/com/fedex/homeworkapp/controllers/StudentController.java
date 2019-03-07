package com.fedex.homeworkapp.controllers;

import com.fedex.homeworkapp.homework.Homework;
import com.fedex.homeworkapp.homework.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/homework")
public class StudentController {

    private HomeworkService homeworkService;

    @Autowired
    public StudentController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping("{applicationUserId}")
    public Homework getHomework(@PathVariable("applicationUserId") Long studentId) {
        return homeworkService.findByStudent(studentId);
    }
}
