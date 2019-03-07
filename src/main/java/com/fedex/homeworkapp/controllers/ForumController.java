package com.fedex.homeworkapp.controllers;

import com.fedex.homeworkapp.post.PostModel;
import com.fedex.homeworkapp.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ForumController {

    private PostService postService;

    @Autowired
    public ForumController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("forum/{subject}")
    public List<PostModel> getAllPostsBySubject(@PathVariable("subject") Enum Post) {
        List<PostModel> posts = new ArrayList<>();
        return posts;
    }

    @GetMapping("post/{id}")
    public PostModel getPostById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }
}
