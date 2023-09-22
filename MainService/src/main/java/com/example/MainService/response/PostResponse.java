package com.example.MainService.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Transient;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    @JsonIgnore
    private Long userId;
    private Long id;
    private String title;
    private String body;

}
