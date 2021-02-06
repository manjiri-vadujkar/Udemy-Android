package com.example.layouts_demo;

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
        //ImageView firstImageView = (ImageView) findViewById(R.id.firstImageView); //for task
        //firstImageView.animate().translationXBy(-1100); //for task
        //firstImageView.setX(-1100); //another way of above line
    }
    boolean flag = false;
    public void fadeInNewImage(View view) {
        //Log.i("Info", "Image tapped");
        ImageView firstImageView = (ImageView) findViewById(R.id.firstImageView);
        ImageView secondImageView = (ImageView) findViewById(R.id.secondImageView);

        //to toggle images with fadein animation
        /*if(!flag) {
            firstImageView.animate().alpha(0).setDuration(2000);
            secondImageView.animate().alpha(1).setDuration(2000);
            flag = true;
        }
        else if(flag) {
            firstImageView.animate().alpha(1).setDuration(2000);
            secondImageView.animate().alpha(0).setDuration(2000);
            flag = false;
        }*/

        //firstImageView.animate().translationXBy(-1100).setDuration(2000);//move left

        //firstImageView.animate().rotation(1000).setDuration(2000); //rotate image

        //firstImageView.animate().scaleX(0.3f).scaleY(0.3f).setDuration(2000); //scale image

        //Task
        //position firstimage to -1000 on left constraint and put secondimage to alpha=0
        //before starting
        //firstImageView.animate().translationXBy(1100).rotation(1800).setDuration(2000);

    }
}