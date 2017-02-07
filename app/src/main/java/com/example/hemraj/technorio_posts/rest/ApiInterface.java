package com.example.hemraj.technorio_posts.rest;

import com.example.hemraj.technorio_posts.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hemraj on 2/7/2017.
 */

public interface ApiInterface {
    @GET("/posts")
    Call<ArrayList<Post>> getAllPosts();

    @GET("/tags")
    Call<List<String>> getTagList();

}