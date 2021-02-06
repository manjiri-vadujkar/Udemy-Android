package com.example.audiodemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //no audioplayer readily available so we use mediaplayer to make a makeshift audio player
    //mediaplayer had the audio file
    MediaPlayer mediaPlayer;
    //audiomanager is to adjust attributes like volume of the audio
    AudioManager audioManager;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for start and pause functionality
        mediaPlayer = MediaPlayer.create(this, R.raw.marbles);

        //setup audio manager
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        //get max of seeker to set limit
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //get initial volume to set the intial progress of seekbar
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //for Volume seekbar
        SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeSeekBar);
        //set intial position of seekbar
        volumeControl.setProgress(currentVolume);
        //set max for seekerbar
        volumeControl.setMax(maxVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Log.i("Seekbar Changed", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //for progress seekbar
        SeekBar progressControl = (SeekBar) findViewById(R.id.progressControl);

        //set max value
        progressControl.setMax(mediaPlayer.getDuration());

        progressControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Log.i("Progress control", Integer.toString(progress));
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediaPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.start();
            }
        });

        //Timer are used to schedule a repeated event
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                progressControl.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 300);//start without delay and update(execute) every sec or 1000ms
    }

    public void play(View view) {
        mediaPlayer.start();
    }

    public void pause(View view) {
        mediaPlayer.pause();
    }
}