package com.fedex.homeworkapp.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fedex.homeworkapp.post.PostModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private PostModel commentsPost;
}
