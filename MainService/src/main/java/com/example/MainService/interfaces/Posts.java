package com.example.MainService.interfaces;

import com.example.MainService.request.PostRequest;
import com.example.MainService.response.PostXMLResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

public interface Posts {

    @GET("/api/v1/posts")
    Call<PostXMLResponse> getUser(@Query("user") Long userId);

    @POST("/api/v1/posts")
    Call<Void> save(@Body PostRequest postRequest);

    @PUT("/api/v1/posts")
    Call<Void> update(@Body PostRequest postRequest);

    @DELETE("/api/v1/posts")
    Call<Void> delete(@Query("id") Long userId);

}
