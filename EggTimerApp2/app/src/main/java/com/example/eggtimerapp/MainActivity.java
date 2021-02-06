package com.example.eggtimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekbar;
    TextView timerTextView;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerSeekbar = findViewById(R.id.timerSeekBar);
        timerTextView = findViewById(R.id.timerTextView);

        timerSeekbar.setMax(600);
        timerSeekbar.setProgress(30);

        timerSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void updateTimer(int progress) {
        int mins = progress / 60;
        int secs = progress % 60;
        String minuteString = Integer.toString(mins);
        if(minuteString.length() == 1) {
            minuteString = "0" + minuteString;
        }
        String secondString = Integer.toString(secs);
        if(secondString.length() == 1) {
            secondString = "0" + secondString;
        }
        String text = minuteString + ":" + secondString;
        //Log.i("updatedTimer",text);
        timerTextView.setText(text);
    }

    public void resetTimer() {
        countDownTimer.cancel();
        timerSeekbar.setProgress(30);
        updateTimer(30);
        timerSeekbar.setEnabled(true);
        counterIsActive = false;
        btn.setText("Start");
    }

    public void onClickFunc(View view) {
        //Log.i("Button Pressed", "Nice");

        btn = (Button) findViewById(R.id.timerButton);

        if(!counterIsActive) {
            counterIsActive = true;
            timerSeekbar.setEnabled(false);
            btn.setText("Stop");
            countDownTimer = new CountDownTimer(timerSeekbar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    int remSecs = (int)millisUntilFinished / 1000;
                    updateTimer(remSecs);
                }

                @Override
                public void onFinish() {
                    //Log.i("Finished", "No More CountDown");
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmsounds);
                    mplayer.start();
                    resetTimer();
                }
            }.start();
        }
        else {
            resetTimer();
        }
    }
}