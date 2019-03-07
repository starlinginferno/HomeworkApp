package com.fedex.homeworkapp.post;

import lombok.Data;

@Data
public class PostDTO {
    private Subject subject;
    private String title;
    private String content;
}
