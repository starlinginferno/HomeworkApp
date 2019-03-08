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
    public PostDTO getPostById(@PathVariable("id") Long id) {
        PostDTO dto = new PostDTO();
        PostModel model = postService.findById(id);
        dto.setTitle(model.getTitle());
        dto.setContent(model.getContent());
        dto.setSubject(model.getSubject());
        return dto;
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public void createPost(@RequestBody PostDTO postDTO){
        PostModel postModel = modelMapper.map(postDTO, PostModel.class);
        postService.createPost(postModel);

    }
}
