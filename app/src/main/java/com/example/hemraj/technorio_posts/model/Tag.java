package com.example.hemraj.technorio_posts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class Tag {
    @SerializedName("tag")
    @Expose
    private String tag;

    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Post> getTagPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
