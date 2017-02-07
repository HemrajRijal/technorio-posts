package com.example.hemraj.technorio_posts.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemraj.technorio_posts.R;
import com.example.hemraj.technorio_posts.activity.POST.Post1TAg;
import com.example.hemraj.technorio_posts.activity.POST.Post2Tag;
import com.example.hemraj.technorio_posts.activity.POST.Post3Tag;
import com.example.hemraj.technorio_posts.activity.POST.Post4Tag;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Post1TAg.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }

                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Post2Tag.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }

                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Post3Tag.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }

                if (position == 3) {
                    Intent intent = new Intent(view.getContext(), Post4Tag.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }

                if (position == 4) {
                    Toast.makeText(context, "Sorry This post is not associated with any Tag ", Toast.LENGTH_SHORT).show();
                }
            }});
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



}