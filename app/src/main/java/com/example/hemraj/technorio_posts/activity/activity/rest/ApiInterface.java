package com.example.hemraj.technorio_posts.activity.activity.rest;

import com.example.hemraj.technorio_posts.activity.activity.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hemraj on 2/7/2017.
 */

public interface ApiInterface {
    @GET("/posts")
    Call<ArrayList<Post>> getAllPosts();



}