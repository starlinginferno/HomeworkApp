package com.fedex.homeworkapp.post;

import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostModel postModel) {
        postRepository.save(postModel);
    }

    @Override
    public void editPost(Long id, ApplicationUser applicationUser) {


    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public void votePost(Long id, Boolean vote) {

    }
}
