package com.fedex.homeworkapp.controllers.excuse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExcuseController {

    private ExcuseService excuseService;

    public ExcuseController(ExcuseService excuseService) {
        this.excuseService = excuseService;
    }

    @GetMapping("/api/excuse")
    public ExcuseDTO showExcuse() throws IOException {
        return excuseService.mapExcuseDTO(excuseService.generateExcuse());
    }
}
