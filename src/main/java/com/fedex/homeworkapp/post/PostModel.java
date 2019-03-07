package com.fedex.homeworkapp.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fedex.homeworkapp.comment.CommentModel;
import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Subject subject;
    private String title;
    private String content;
    private Integer score;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser postsUser;

    @JsonManagedReference
    @OneToMany(mappedBy = "commentsPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentModel> postsComments;
}
