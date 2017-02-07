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

import java.util.List;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.Tag_ViewHolder> {

    private List<String> Tags;
    private int rowLayout;
    private Context context;
    private static final String TAG = TagAdapter.class.getSimpleName();
    public int positions;

    public static class Tag_ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout postLayout;
        TextView tagName;

        public Tag_ViewHolder(View v) {
            super(v);
            postLayout = (LinearLayout) v.findViewById(R.id.post_layout);
            tagName = (TextView) v.findViewById(R.id.tag_name);

        }


    }

    public TagAdapter(List<String> Tags, int rowLayout, Context context) {
        this.Tags = Tags;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public TagAdapter.Tag_ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new TagAdapter.Tag_ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TagAdapter.Tag_ViewHolder holder, final int position) {
        holder.tagName.setText(Tags.get(position));

    }

    @Override
    public int getItemCount() {
        return Tags.size();
    }


}
