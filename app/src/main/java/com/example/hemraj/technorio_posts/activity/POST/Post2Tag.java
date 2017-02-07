package com.example.hemraj.technorio_posts.activity.POST;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.hemraj.technorio_posts.R;
import com.example.hemraj.technorio_posts.activity.PostActivity;
import com.example.hemraj.technorio_posts.adapter.TagAdapter;
import com.example.hemraj.technorio_posts.model.PostResponse;
import com.example.hemraj.technorio_posts.rest.ApiClient;
import com.example.hemraj.technorio_posts.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class Post2Tag extends AppCompatActivity {

    private static final String TAG = Post2Tag.class.getSimpleName();

    private final static String Post = "2";


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


        Call<PostResponse> call = apiService.getPostTag(Post);
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                int statusCode = response.code();
                List<String> tags = response.body().getTags();
                recyclerView.setAdapter(new TagAdapter(tags, R.layout.activity_tag, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
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
                Intent homeIntent = new Intent(this, PostActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }



}

