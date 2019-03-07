package com.fedex.homeworkapp.post;

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
@RequestMapping("/")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("forum/{subject}")
    public PostListDTO getAllPostsBySubject(@PathVariable("subject") String subject) {
        PostListDTO postListDTO = new PostListDTO();
        postListDTO.setPosts(postService.findPostsBySubject(subject));
        return postListDTO;
    }

    @GetMapping("post/{id}")
    public PostModel getPostById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }
}
