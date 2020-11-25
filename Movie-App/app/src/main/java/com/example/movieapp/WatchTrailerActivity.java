package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class WatchTrailerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String API_KEY="AIzaSyCgGZKSdykJEkbIUrTHqCTCVFjK6DFknRM";
    String Trailer_ID ="Q6iK6DjV_iE";
    private PlayerView playerView;
    private SimpleExoPlayer simpleExoPlayer;
    public static final String TrailerURL ="http://clips.vorwaerts-gmbh.de/VfE_html5.mp4";


    private YouTubePlayerView youTubePlayerView;
    int Request = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen();
        setContentView(R.layout.activity_watch_trailer);

//        iniPlayer();

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.movie_trailer);
        youTubePlayerView.initialize(API_KEY , this);
    }








    private void fullScreen(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//        youTubePlayer.cueVideo("Q6iK6DjV_iE");
        if (!b)youTubePlayer.loadVideo(Trailer_ID);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(WatchTrailerActivity.this , Request);
        }
        else {
            Toast.makeText(this , " Error" , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Request){
            youTubePlayerView.initialize(API_KEY , WatchTrailerActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    //    private void iniPlayer(){
//        playerView = findViewById(R.id.movie_trailer);
//        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
//        playerView.setPlayer(simpleExoPlayer);
//        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this ,
//                Util.getUserAgent(this , "Movie-App"));
//        MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).
//                createMediaSource(Uri.parse(TrailerURL));
//        simpleExoPlayer.prepare(mediaSource);
//        simpleExoPlayer.setPlayWhenReady(true);
//    }
//    protected  void onDestroy(){
//        super.onDestroy();
//        simpleExoPlayer.release();
//    }
}