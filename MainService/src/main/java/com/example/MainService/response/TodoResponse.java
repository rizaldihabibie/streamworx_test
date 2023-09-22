package com.example.MainService.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoResponse {

    @JsonIgnore
    private Long userId;
    private Long id;
    private String title;
    private boolean completed;
}
