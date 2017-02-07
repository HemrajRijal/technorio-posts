package com.example.hemraj.technorio_posts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class Post {

    @SerializedName("Pid")
    @Expose
    private String Pid;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose
    private String body;

    public String getPId() {
        return Pid;
    }

    public void setId(String Pid) {
        this.Pid = Pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
