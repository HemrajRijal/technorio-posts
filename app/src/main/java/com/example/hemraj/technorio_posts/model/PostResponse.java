package com.example.hemraj.technorio_posts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class PostResponse {

    @SerializedName("post")
    @Expose
    private Post post;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}

