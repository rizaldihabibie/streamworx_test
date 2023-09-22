package com.example.MainService.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

    private Long userId;
    private Long id;
    private String title;
    private String body;

}
