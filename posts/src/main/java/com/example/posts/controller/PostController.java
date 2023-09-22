package com.example.posts.controller;

import com.example.posts.request.PostRequest;
import com.example.posts.response.PostXMLResponse;
import com.example.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<PostXMLResponse> getPost(
            @RequestParam("user") Long userId
    ) {

        return ResponseEntity.ok(postService.findByUserId(userId));

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePost(
            @RequestBody PostRequest postRequest
            ) {

        postService.save(postRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePost(
            @RequestBody PostRequest postRequest
    ) {

        postService.update(postRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<?> deletePost(
            @RequestParam("id") Long id
    ) {

        postService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
