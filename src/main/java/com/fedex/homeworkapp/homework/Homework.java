package com.fedex.homeworkapp.homework;

import com.fedex.homeworkapp.post.Subject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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
}
