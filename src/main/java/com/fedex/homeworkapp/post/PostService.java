package com.fedex.homeworkapp.post;

import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;

public interface PostService {

    void createPost(PostModel postModel);

    void editPost(Long id, ApplicationUser applicationUser);

    void deletePost(Long id);

    void votePost(Long id, Boolean vote);

    PostModel findById(Long id);
}
