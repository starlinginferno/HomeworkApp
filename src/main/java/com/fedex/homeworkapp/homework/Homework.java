package com.fedex.homeworkapp.homework;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fedex.homeworkapp.post.Subject;
import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "homework")
@Getter
@Setter
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Subject subject;
    private String topic;
    private String title;
    private String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser homeworksUser;
}
