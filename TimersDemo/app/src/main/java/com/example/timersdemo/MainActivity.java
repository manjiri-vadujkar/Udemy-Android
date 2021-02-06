package com.example.timersdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1st way
        /* Handler handler = new Handler();

        //Handler runs the code that is under runnable
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Hey its us", "A second has passed!");
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run); */

        //2nd way
        new CountDownTimer(10000, 1000) {
            public void onTick(long millisecondsUntilDone) {
                Log.i("Seconds left", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish() {
                Log.i("We're done", "No more countdown");
            }
        }.start();
    }
}