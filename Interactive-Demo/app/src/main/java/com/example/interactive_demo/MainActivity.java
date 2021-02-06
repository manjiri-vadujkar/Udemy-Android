package com.example.interactive_demo;

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

    public void clickFunc(View view) {
        EditText usernameText = (EditText) findViewById(R.id.usernameText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText); //R = for resources, EditText is imported, nameEditText is our custom id name for text field
        //(EditText) before findViewById creates a EditText type variable nameEditText

        Log.i("Username", usernameText.getText().toString());
        Log.i("Password", passwordText.getText().toString());
        Log.i("ButtonInfo", "Button Clicked!!");

        Toast.makeText(this, "Hi " + usernameText.getText().toString() +". You have logged in.", Toast.LENGTH_SHORT).show();
        //pops up near bottom of the screen.
    }
}