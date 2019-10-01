package com.example.mv_series;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener  {

    private List<Slide> lstSlides ;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);



        //    PREPARE A LIST OF SLIDES
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.sautisol, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.maia, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.sautisol, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.maia, "Slide Title /more text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderpager.setAdapter(adapter);

//        SETUP TIMER

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000,6000);
        indicator.setupWithViewPager(sliderpager, true);


//        RECYCLERVIEW SETUP

//        ini Data
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Aladin",R.drawable.aladin));
        lstMovies.add(new Movie("Glass",R.drawable.glass));
        lstMovies.add(new Movie("US",R.drawable.us));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));

        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));




    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
//        SEND MOVIE INFORMATION TO DETAIL ACTIVITY 


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
