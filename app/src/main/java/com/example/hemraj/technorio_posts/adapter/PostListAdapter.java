package com.example.hemraj.technorio_posts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hemraj.technorio_posts.R;
import com.example.hemraj.technorio_posts.model.Post;

import java.util.List;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {

    private List<Post> posts;
    private int rowLayout;
    private Context context;


    public static class PostViewHolder extends RecyclerView.ViewHolder{
        LinearLayout postLayout;
        TextView postTitle;
        TextView postBody;


        public PostViewHolder(View v) {
            super(v);
            postLayout = (LinearLayout) v.findViewById(R.id.post_layout);
            postTitle = (TextView) v.findViewById(R.id.title);
            postBody = (TextView) v.findViewById(R.id.body);

        }


    }

    public PostListAdapter(List<Post> posts, int rowLayout, Context context) {
        this.posts = posts;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PostListAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PostViewHolder(view);


    }


    @Override
    public void onBindViewHolder(PostViewHolder holder, final int position) {
        holder.postTitle.setText(posts.get(position).getTitle());
        holder.postBody.setText(posts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



}