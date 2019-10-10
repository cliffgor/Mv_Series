package com.cliffgor.mv_series.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;


import com.cliffgor.mv_series.models.Movie;
import com.cliffgor.mv_series.adapters.MovieAdapter;
import com.cliffgor.mv_series.adapters.MovieItemClickListener;
import com.cliffgor.mv_series.R;
import com.cliffgor.mv_series.models.Slide;
import com.cliffgor.mv_series.adapters.SliderPagerAdapter;
import com.cliffgor.mv_series.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides ;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV, moviesRvWeek;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);
        moviesRvWeek = findViewById(R.id.rv_movies_week);



        //    PREPARE A LIST OF SLIDES
        iniSlider();
        iniPopularMovies();
        iniWeekMovies();


    }

    private void iniWeekMovies() {

        MovieAdapter weekMovieAdapter = new MovieAdapter(this,DataSource.getWeekMovies(),this);
        moviesRvWeek.setAdapter(weekMovieAdapter);
        moviesRvWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    }

    private void iniPopularMovies() {
        //        RECYCLERVIEW SETUP

//        ini Data
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(), this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniSlider() {
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.sautisol, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.maia, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.sautisol, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.maia, "Slide Title /more text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderpager.setAdapter(adapter);

//        SETUP TIMER

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000,6000);
        indicator.setupWithViewPager(sliderpager, true);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
//        SEND MOVIE INFORMATION TO DETAIL ACTIVITY
        Intent intent = new Intent(this, MovieDetailActivity.class);
//        SEND MOVIE INFO TO THE DETAILACTIVITY
         intent.putExtra("title",movie.getTitle());
         intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

//         startActivity(intent);
//         Transition animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,movieImageView ,"sharedName");


        startActivity(intent,options.toBundle());


//        A small test to see if the click function works
        Toast.makeText(this, "item clicked: " + movie.getTitle(), Toast.LENGTH_LONG).show();


    }

    class SliderTimer extends TimerTask {



        @Override
        public void run(){

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                        if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                            sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                        }
                        else
                            sliderpager.setCurrentItem(0);
                }
            });

        }
    }


}
