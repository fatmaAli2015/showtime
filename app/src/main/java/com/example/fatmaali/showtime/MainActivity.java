package com.example.fatmaali.showtime;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
   FloatingActionButton FAbuttonHeart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FAbuttonHeart = (FloatingActionButton) findViewById(R.id.floatingHeart);
        FAbuttonHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent FAbuttonHeartIntent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(FAbuttonHeartIntent);
            }
        });
    }
}
