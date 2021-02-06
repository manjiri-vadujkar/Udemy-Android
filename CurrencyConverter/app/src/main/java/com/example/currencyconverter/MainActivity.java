package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertFunc(View view) {
        EditText amt = (EditText) findViewById(R.id.amtTextView);
        double val = Double.parseDouble(amt.getText().toString());
        val = val * 87.81;
        //we can also reconvert it to string before we display it. Using String.format does convert double to string.
        Toast.makeText(this, "Converted Value = " + String.format("%.2f", val) + " INR", Toast.LENGTH_LONG).show();
    }
}