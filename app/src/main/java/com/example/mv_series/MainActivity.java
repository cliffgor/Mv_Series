package com.example.mv_series;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Slide> lstSlides ;
    private ViewPager sliderpager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sliderpager = findViewById(R.id.slider_pager);



        //    PREPARE A LIST OF SLIDES
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.sautisol, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.maia, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.sautisol, "Slide Title /more text here"));
        lstSlides.add(new Slide(R.drawable.maia, "Slide Title /more text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderpager.setAdapter(adapter);


    }


}
