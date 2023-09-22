package com.example.MainService.interfaces;

import com.example.MainService.response.TodoResponse;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Todos {

    @GET("/todos")
    public Call<List<TodoResponse>> getTodos();

}
