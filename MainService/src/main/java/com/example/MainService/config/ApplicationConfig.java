package com.example.MainService.config;

import com.example.MainService.model.User;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Configuration
public class ApplicationConfig {

    @Value("${post.base.url}")
    private String postBaseUrl;

    @Value("${todo.base.url}")
    private String todoBaseUrl;

    @Bean("retrofitXml")
    public Retrofit retrofitXml(){
        return new Retrofit.Builder()
                .baseUrl(postBaseUrl)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

    }

    @Bean("retrofitPostJson")
    public Retrofit retrofitPostJson(){
        com.google.gson.Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(postBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    @Bean("retrofitJson")
    public Retrofit retrofitJson(){
        com.google.gson.Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(todoBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate(){
        RedisTemplate<String, User> userTemplate = new RedisTemplate<>();
        userTemplate.setConnectionFactory(redisConnectionFactory());
        return userTemplate;
    }
}
