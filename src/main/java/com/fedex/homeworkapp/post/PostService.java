package com.fedex.homeworkapp.post;

public interface PostService {

    void createPost(PostModel postModel);

    void editPost(Long id, ApplicationUser applicationUser);

    void deletePost(Long id);

    void votePost(Long id, Boolean vote);
}
