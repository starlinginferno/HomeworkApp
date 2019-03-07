package com.fedex.homeworkapp.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PostController {

    private PostService postService;
    private ModelMapper modelMapper;

    @Autowired
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
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

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public void createPost(@RequestBody PostDTO postDTO){
        PostModel postModel = modelMapper.map(postDTO, PostModel.class);
        postService.createPost(postModel);

    }
}
