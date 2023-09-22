package com.example.posts.service;

import com.example.posts.entity.Post;
import com.example.posts.exceptions.DataNotFoundException;
import com.example.posts.repository.PostRepository;
import com.example.posts.request.PostRequest;
import com.example.posts.response.PostResponse;
import com.example.posts.response.PostXMLResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PostXMLResponse findByUserId(Long userId){

        Optional<List<Post>> optionalPosts  = postRepository.findByUserId(userId);

        if(optionalPosts.get().size() == 0) {
            throw new DataNotFoundException("Cannot found post","1000");
        }

        return PostXMLResponse.builder()
                .postResponseList(mapFromPost(optionalPosts.get()))
                .build();

    }

    public void save(PostRequest postRequest) {
        postRepository.save(objectMapper.convertValue(postRequest,Post.class));
    }

    public void update(PostRequest postRequest) {
        Post post = postRepository.findById(postRequest.getId())
                .orElseThrow(() ->new DataNotFoundException("Cannot found post","1000"));
        postRepository.save(objectMapper.convertValue(postRequest,Post.class));
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() ->new DataNotFoundException("Cannot found post","1000"));
        postRepository.delete(post);
    }

    private List<PostResponse> mapFromPost(List<Post> posts) {

        List<PostResponse> postResponses = new ArrayList<>();

        for(Post post : posts) {

            postResponses.add(
                    PostResponse.builder()
                            .id(post.getId())
                            .body(post.getBody())
                            .userId(post.getUserId())
                            .build()
            );

        }

        return postResponses;

    }

}
