package com.example.hemraj.technorio_posts.rest;

import com.example.hemraj.technorio_posts.model.Post;
import com.example.hemraj.technorio_posts.model.PostResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Hemraj on 2/7/2017.
 */

public interface ApiInterface {
    @GET("/posts")
    Call<ArrayList<Post>> getAllPosts();

    @GET("/tags")
    Call<List<String>> getTagList();

    @GET("/post/{id}")
    Call<PostResponse> getPostTag(@Path("id") String id);
}