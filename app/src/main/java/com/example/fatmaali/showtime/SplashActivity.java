package com.example.fatmaali.showtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashImage = (ImageView) findViewById(R.id.splashImage);
        final Intent splashIntent = new Intent(this, MainActivity.class);
        Animation animationSplash = AnimationUtils.loadAnimation(this, R.anim.spash_trans);
        splashImage.startAnimation(animationSplash);
        Thread timerSplash = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(splashIntent);
                    finish();
                }
            }
        };
        timerSplash.start();
    }
}
