package com.example.MainService.service;

import com.example.MainService.model.User;
import com.example.MainService.response.PostXMLResponse;
import com.example.MainService.response.TodoResponse;
import com.example.MainService.response.ResponseHome;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final PostService postService;
    private final TodoService todoService;
    private final UserService userService;

    public ResponseHome getDataHome(Long userId) throws Exception {

        User user = userService.findUser(userId);
        if(null != user){

            PostXMLResponse postXMLResponse = postService.getPosts(userId);
            List<TodoResponse> todoResponse = todoService.getTodo(userId);

            ResponseHome responseHome = ResponseHome.builder()
                    .id(user.getId())
                    .address(user.getAddress())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .name(user.getName())
                    .username(user.getUsername())
                    .todos(todoResponse)
                    .posts(postXMLResponse.getPostResponseList())
                    .build();

            return responseHome;

        } else {
            throw new Exception("Data not found");
        }

    }

}
