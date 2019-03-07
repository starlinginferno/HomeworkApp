package com.fedex.homeworkapp.controllers;

import com.fedex.homeworkapp.homework.Homework;
import com.fedex.homeworkapp.homework.HomeworkService;
import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;
import com.fedex.homeworkapp.user.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TeacherController {

    private HomeworkService homeworkService;
    private ApplicationUserService applicationUserService;

    @Autowired
    public TeacherController(HomeworkService homeworkService, ApplicationUserService applicationUserService) {
        this.homeworkService = homeworkService;
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("students")
    public List<ApplicationUser> getAllRegisteredStudents() {
        return applicationUserService.findStudents();
    }

    @GetMapping("homework")
    public List<Homework> getAllHomework() {
        return homeworkService.getAllHomework();
    }
}
