package com.fedex.homeworkapp.post;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @JsonManagedReference
    @OneToMany(mappedBy = "commentsPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostModel> postsComments;
}
