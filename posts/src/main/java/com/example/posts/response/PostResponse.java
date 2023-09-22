package com.example.posts.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostResponse {

    private Long userId;
    private Long id;
    private String title;
    private String body;
}
