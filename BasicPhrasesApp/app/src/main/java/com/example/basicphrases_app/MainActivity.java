package com.example.basicphrases_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    MediaPlayer mediaPlayer;
    public  void play(View view) {
        Button playedButton = (Button) view;
        String fileName = playedButton.getTag().toString();
        //Log.i("Button Presses", playedButton.getTag().toString());
        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(fileName, "raw", getPackageName()));
        mediaPlayer.start();
        mediaPlayer.setVolume(1.0f,1.0f);
    }
}