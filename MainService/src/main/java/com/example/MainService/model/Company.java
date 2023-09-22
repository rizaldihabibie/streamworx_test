package com.example.MainService.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {

    private String name;
    private String catchPhrase;
    private String bs;
}
