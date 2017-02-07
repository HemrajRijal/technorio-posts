package com.example.hemraj.technorio_posts.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.hemraj.technorio_posts.R;
import com.example.hemraj.technorio_posts.adapter.PostListAdapter;
import com.example.hemraj.technorio_posts.model.Post;
import com.example.hemraj.technorio_posts.rest.ApiClient;
import com.example.hemraj.technorio_posts.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class PostActivity extends AppCompatActivity {

    private static final String TAG = PostActivity.class.getSimpleName();

    private final static String Post_1 = "1";


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

        Call<ArrayList<Post>> call = apiService.getAllPosts();
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                int statusCode = response.code();
                List<Post> posts = response.body();
                Log.d(TAG, response.body().toString());
                recyclerView.setAdapter(new PostListAdapter(posts, R.layout.list_item_post, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                Log.e(TAG, t.toString());

            }


        });


    }

    //Function to be called while pressing back navigation button
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }



}

