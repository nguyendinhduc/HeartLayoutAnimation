package com.ducnd.hearlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ducnd.library.HeartLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Random mRandom = new Random();
    private Timer mTimer = new Timer();
    private HeartLayout mHeartLayout, mHeartLayout2, mHeartLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeartLayout = (HeartLayout) findViewById(R.id.heart_layout);
        mHeartLayout2 = (HeartLayout) findViewById(R.id.heart_layout2);
        mHeartLayout3 = (HeartLayout) findViewById(R.id.heart_layout3);
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mHeartLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        mHeartLayout.addHeart(randomColor());
                        mHeartLayout2.addHeart(randomColor());
                        mHeartLayout3.addHeart(randomColor());
                    }
                });
            }
        }, 500, 200);
    }

    @Override
    protected void onDestroy() {
        mTimer.cancel();
        super.onDestroy();
    }

    private int randomColor() {
        return Color.rgb(mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }


}
