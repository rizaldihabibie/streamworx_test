package com.example.MainService.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
