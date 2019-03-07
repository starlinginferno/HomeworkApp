package com.fedex.homeworkapp.excuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExcuseController {

    private ExcuseService excuseService;

    @Autowired
    public ExcuseController(ExcuseService excuseService) {
        this.excuseService = excuseService;
    }

    @GetMapping("/api/excuse")
    public ExcuseDTO showExcuse() throws IOException {
        return excuseService.mapExcuseDTO();
    }
}
