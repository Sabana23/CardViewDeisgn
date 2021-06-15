package com.example.cardviewdesign;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;


public class ManualActivity1 extends AppCompatActivity {
    VideoView video;
    String video_url="http://cdn.tamilvideosda.net/files/Tamil%20Movie%20Trailers/Paava%20Kadhaigal%20Movie%20Trailer/Paava%20Kadhaigal%20Movie%20Trailer%20720p%20HD.mp4" ;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video=(VideoView)findViewById(R.id.video);
        pd=new ProgressDialog(ManualActivity1.this);
        pd.setMessage("Buffering Video Please Wait");
        pd.show();
        //creating mediacontroller
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);
        //Set MediaController and Video Uri
        video.setMediaController(mediaController);
        Uri uri=Uri.parse(video_url);
        video.setVideoURI(uri);
        video.start();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();
            }
        });
    }
}
