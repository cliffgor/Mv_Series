package com.example.mv_series;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbailImg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

//        get the data
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        MovieThumbailImg = findViewById(R.id.detail_movie_img);
        MovieThumbailImg.setImageResource(imageResourceId);


    }
}
