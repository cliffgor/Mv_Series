package com.cliffgor.mv_series.utils;

import com.cliffgor.mv_series.R;
import com.cliffgor.mv_series.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    public static List<Movie> getPopularMovies(){

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Aladin", R.drawable.aladin,R.drawable.ghostrecon));
        lstMovies.add(new Movie("Glass",R.drawable.glass, R.drawable.ghostrecon));
        lstMovies.add(new Movie("US",R.drawable.us));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        return lstMovies;



    }

    public static List<Movie> getWeekMovies() {

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Aladin", R.drawable.ghostrecon,R.drawable.ghostrecon));
        lstMovies.add(new Movie("Glass",R.drawable.glass, R.drawable.ghostrecon));
        lstMovies.add(new Movie("US",R.drawable.us));
        lstMovies.add(new Movie("aladin",R.drawable.avengersendgame));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        lstMovies.add(new Movie("aladin",R.drawable.aladin));
        return lstMovies;

    }
}
