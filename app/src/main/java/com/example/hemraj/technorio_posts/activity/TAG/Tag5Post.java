package com.example.hemraj.technorio_posts.activity.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.hemraj.technorio_posts.R;
import com.example.hemraj.technorio_posts.activity.TagActivity;
import com.example.hemraj.technorio_posts.adapter.PostListAdapter;
import com.example.hemraj.technorio_posts.model.Post;
import com.example.hemraj.technorio_posts.model.Tag;
import com.example.hemraj.technorio_posts.rest.ApiClient;
import com.example.hemraj.technorio_posts.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class Tag5Post extends AppCompatActivity {

    private static final String TAG = Tag1Post.class.getSimpleName();
    private final static String TAG_KEY = "5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

        //Back Navigation will be Displayed
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.post_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        Call<Tag> call = apiService.getTag(TAG_KEY);
        call.enqueue(new Callback<Tag>() {
            @Override
            public void onResponse(Call<Tag> call, Response<Tag> response) {
                int statusCode = response.code();
                List<Post> tags = response.body().getTagPosts();
                recyclerView.setAdapter(new PostListAdapter(tags, R.layout.list_item_post, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Tag> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    //Function to be called while pressing back navigation button
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, TagActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }



}


