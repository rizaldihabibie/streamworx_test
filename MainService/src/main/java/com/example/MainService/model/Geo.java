package com.example.MainService.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Geo implements Serializable {

    private String lat;
    private String lang;

}
