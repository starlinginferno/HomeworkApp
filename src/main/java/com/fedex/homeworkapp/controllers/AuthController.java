package com.fedex.homeworkapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping
    public Long getUserIdFromPrincipal(Principal principal) {
        return getUserIdFromPrincipal(principal);
    }
}
