package com.fedex.homeworkapp.post;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostListDTO {
    private List<PostModel> posts;
}
