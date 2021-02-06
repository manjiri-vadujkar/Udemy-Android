package com.example.timestableapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar numSelector = (SeekBar) findViewById(R.id.numSelector);
        int seekBarMaxValue = 20;
        int seekBarMinValue = 1;
        int seekBarStartValue = 10;
        numSelector.setMax(seekBarMaxValue);
        numSelector.setMin(seekBarMinValue);
        numSelector.setProgress(seekBarStartValue);
        generateTables(seekBarStartValue);
        numSelector.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Log.i("Seekbar Changed", Integer.toString(progress));
                generateTables(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
    public void generateTables(int progress){
        ListView myListView = findViewById(R.id.myListView);
        ArrayList<Integer> tables = new ArrayList<Integer>();
        for(int i=1;i<=10;i++) {
            tables.add(progress * i);
        }
        //bridge to connect the array to the list view
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, tables);

        //set the arrayadapter to listview
        myListView.setAdapter(arrayAdapter);
    }
}