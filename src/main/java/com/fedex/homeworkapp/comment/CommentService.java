package com.fedex.homeworkapp.comment;

public interface CommentService {

    void saveComment(CommentModel commentModel);

    void editComment(Long id);

    void deleteComment(Long id);
}
