package com.fedex.homeworkapp.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fedex.homeworkapp.post.PostModel;
import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser commentsUser;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostModel commentsPost;
}
