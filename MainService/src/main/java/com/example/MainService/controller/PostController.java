package com.example.MainService.controller;


import com.example.MainService.request.PostRequest;
import com.example.MainService.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity save(
            @RequestBody PostRequest postRequest
            ) {

        try {

            postService.savePost(postRequest);
            return new ResponseEntity(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping
    public ResponseEntity update(
            @RequestBody PostRequest postRequest
    ) {

        try {

            postService.updatePost(postRequest);
            return new ResponseEntity(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @DeleteMapping
    public ResponseEntity delete(
            @RequestParam("id") Long id
    ) {

        try {

            postService.deletePost(id);
            return new ResponseEntity(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
