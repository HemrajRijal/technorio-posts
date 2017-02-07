package com.example.hemraj.technorio_posts.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.hemraj.technorio_posts.R;
import com.example.hemraj.technorio_posts.adapter.TagAdapter;
import com.example.hemraj.technorio_posts.rest.ApiClient;
import com.example.hemraj.technorio_posts.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hemraj on 2/7/2017.
 */

public class TagActivity extends AppCompatActivity {

    private static final String TAG = TagActivity.class.getSimpleName();

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


        Call<List<String>> languagesCall = apiService.getTagList();
        languagesCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> languages = response.body();
                recyclerView.setAdapter(new TagAdapter(languages, R.layout.activity_tag, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

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


