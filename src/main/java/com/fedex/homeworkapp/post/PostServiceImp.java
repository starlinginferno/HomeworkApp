package com.fedex.homeworkapp.post;

import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PostModel findById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<PostModel> findPostsBySubject(String subject) {
        for (Subject s : Subject.values()) {
            if(s.getName().equals(subject.toUpperCase())) {
                return postRepository.findAllBySubject(s);
            }
        }
        throw new IllegalArgumentException("No such type");
    }

    @Override
    public List<PostModel> findAllPosts() {
        return postRepository.findAll();
    }
}
