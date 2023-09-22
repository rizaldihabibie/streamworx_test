package com.example.MainService.service;

import com.example.MainService.interfaces.Todos;
import com.example.MainService.response.TodoResponse;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {

    @Qualifier("retrofitJson")
    private final Retrofit retrofitJson;

    public List<TodoResponse> getTodo(Long userId) throws Exception {
        Todos todos = retrofitJson.create(Todos.class);
        Call<List<TodoResponse>> todosCall = todos.getTodos();
        try {

            Response<List<TodoResponse>> response = todosCall.execute();
            List<TodoResponse> todoResponses= response.body();

            List<TodoResponse> result = new ArrayList<>();
            for (TodoResponse todoResponse : todoResponses) {
                if(todoResponse.getUserId() == userId) {
                    result.add(todoResponse);
                }
            }

            return result;

        } catch (Exception e) {

            log.error("Error occurred when calling post service",e);
            throw new Exception("Unexpected error occurred");

        }
    }
}
