package com.example.higherlower_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }

    public void generateRandomNumber() {
        Random rand = new Random();
        n = rand.nextInt(20) + 1;
    }

    public void checkAnswer(View view) {
        EditText ans = (EditText) findViewById(R.id.getNumber);
        int num = Integer.parseInt(ans.getText().toString());
        //Log.i("value", "n = " + n); for debugging
        if(num == n) {
            Toast.makeText(this, "Right Answer!!", Toast.LENGTH_SHORT).show();
        }
        else if(num > n) {
            Toast.makeText(this, "Guess Lower!!", Toast.LENGTH_SHORT).show();
        }
        else if(num < n) {
            Toast.makeText(this, "Guess Higher!!", Toast.LENGTH_SHORT).show();
        }
    }
}