package com.example.MainService.service;

import com.example.MainService.interfaces.Posts;
import com.example.MainService.request.PostRequest;
import com.example.MainService.response.PostXMLResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    @Qualifier("retrofitXml")
    private final Retrofit retrofitXml;

    @Qualifier("retrofitPostJson")
    private final Retrofit retrofitPostJson;

    public PostXMLResponse getPosts(Long userId) throws Exception {
        Posts posts = retrofitXml.create(Posts.class);
        Call<PostXMLResponse> postXMLResponseCall = posts.getUser(userId);
        try {

            Response<PostXMLResponse> response = postXMLResponseCall.execute();
            PostXMLResponse postXMLResponse = response.body();

            return postXMLResponse;

        } catch (Exception e) {
            log.error("Error occured when calling post service",e);
            throw new Exception("Unexpected error occured");
        }
    }

    public void savePost(PostRequest postRequest) throws Exception {
        Posts posts = retrofitPostJson.create(Posts.class);
        Call<Void> postXMLResponseCall = posts.save(postRequest);
        try {

            Response response = postXMLResponseCall.execute();
            if(response.code() != HttpStatus.CREATED.value()){
                throw new Exception("Unexpected error occurred");
            }
        } catch (Exception e) {
            log.error("Error occurred when calling post service",e);
            throw new Exception("Unexpected error occurred");
        }
    }

    public void updatePost(PostRequest postRequest) throws Exception {
        Posts posts = retrofitPostJson.create(Posts.class);
        Call<Void> postXMLResponseCall = posts.update(postRequest);
        try {

            Response response = postXMLResponseCall.execute();
            if(response.code() != HttpStatus.CREATED.value()){
                throw new Exception("Unexpected error occurred");
            }
        } catch (Exception e) {
            log.error("Error occurred when calling post service",e);
            throw new Exception("Unexpected error occurred");
        }
    }

    public void deletePost(Long id) throws Exception {
        Posts posts = retrofitPostJson.create(Posts.class);
        Call<Void> postXMLResponseCall = posts.delete(id);
        try {

            Response response = postXMLResponseCall.execute();
            if(response.code() != HttpStatus.OK.value()){
                throw new Exception("Unexpected error occurred");
            }
        } catch (Exception e) {
            log.error("Error occurred when calling post service",e);
            throw new Exception("Unexpected error occurred");
        }
    }

}
