package com.cliffgor.mv_series.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.cliffgor.mv_series.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.net.URI;

public class MoviePlayerActivity extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer simpleExoPlayer;
    public static final String VIDEO_TEST_URL="\n" +
            "http://208.113.129.24/static/media/videos/868557a5-9315-4afa-b165-ece90c5f1601/868557a5-9315-4afa-b165-ece90c5f1601.mpd";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFullScreen();
        


        setContentView(R.layout.activity_movie_player);
        hideActionbar();

        iniExoPlayer();

    }

    private void hideActionbar() {
        getSupportActionBar().hide();
    }

    private void setFullScreen() {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    private void iniExoPlayer() {
        playerView = findViewById(R.id.movie_exo_player);
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(simpleExoPlayer);
        DataSource.Factory dataSourceFactory= new DefaultDataSourceFactory(this,
                Util.getUserAgent(this,"appname"));
        MediaSource videosSource = new DashMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(VIDEO_TEST_URL));
        simpleExoPlayer.prepare(videosSource);
        simpleExoPlayer.setPlayWhenReady(true);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }
}
