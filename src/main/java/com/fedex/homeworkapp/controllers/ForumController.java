package com.fedex.homeworkapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ForumController {

    @GetMapping("forum/{subject}")
    public List<PostModel> getAllPostsBySubject(@PathVariable("subject") String subject) {
        return (List<PostModel>) posts;
    }

    @GetMapping("post/{id}")
    public PostModel getPostById(@PathVariable("id") Long postId) {
        return PostModel;
    }
}
