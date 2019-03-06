package com.fedex.homeworkapp.controllers;

import com.fedex.homeworkapp.homework.Homework;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class StudentController {

    @GetMapping("homework")
    public Homework getHomework() {
        return homework;
    }
}
