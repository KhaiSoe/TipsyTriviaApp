package com.android.tipsytrivia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.felipecsl.gifimageview.library.GifImageView;

public class RightResultActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private TextView textView;

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_results);

        textView = findViewById(R.id.right_text_results);



        gifImageView = findViewById(R.id.correct);
        Glide.with(this).load(R.raw.correct).into(gifImageView);

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), CategoryPageActivity.class));
                finish();
            }

        };
        handler = new Handler();
        handler.postDelayed(runnable, 5000);
    }
    @Override
    protected void onStart() {
        super.onStart();
        MediaPlayer right = MediaPlayer.create(this, R.raw.yay);
        right.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) ;
        handler.removeCallbacks(runnable);
    }
}