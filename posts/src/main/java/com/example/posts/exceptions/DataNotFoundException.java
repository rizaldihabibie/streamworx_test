package com.example.posts.exceptions;

import java.io.Serial;

public class DataNotFoundException extends RuntimeException{

    private String code;
    @Serial
    private static final long serialVersionUID = 5212038896500975665L;

    public DataNotFoundException(String message, String code){
        super(message);
        this.code = code;
    }


}
