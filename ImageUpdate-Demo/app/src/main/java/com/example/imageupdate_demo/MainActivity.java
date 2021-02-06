package com.example.imageupdate_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchBTS(View view) {
        Log.i("switchButton", "Button works!!!");

        ImageView image = (ImageView) findViewById(R.id.btsImageView);
        image.setImageResource(R.drawable.bts2);
    }
}