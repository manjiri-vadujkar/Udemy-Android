package com.example.numbershape_game;

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

    class checkNumber{
        int num;

        public boolean isTriangular(){
            //triangular no series = 1,3,6,10,15 i.e diff increases by 1
            int x = 1;
            int triangularnum = 1;
            while(triangularnum < num) {
                x++;
                triangularnum = triangularnum + x;
            }
            if(triangularnum == num) {
                return true;
            }
            else{
                return false;

            }
        }

        public boolean isSquare(){
            double squareRoot = Math.sqrt(num);
            if(squareRoot % 1 == 0){ //other way squareRoot == Math.floor(squareRoot)
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void callCheckFunc(View view) {
        checkNumber myNum = new checkNumber();
        //EditText n = (EditText) findViewById(R.id.getNumber);
        EditText ans = (EditText) findViewById(R.id.getNumber);
        myNum.num = Integer.parseInt(ans.getText().toString());
        if(myNum.isTriangular() && myNum.isSquare()){
            Toast.makeText(this, myNum.num + " is a triangular number and also a square number!!", Toast.LENGTH_LONG).show();
        }
        else if(myNum.isTriangular() && !myNum.isSquare()){
            Toast.makeText(this, myNum.num + " is a triangular number but not a square number!", Toast.LENGTH_LONG).show();
        }
        else if(!myNum.isTriangular() && myNum.isSquare()){
            Toast.makeText(this, myNum.num + " is not a triangular number but is a square number!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, myNum.num + " is neither a triangular number nor a square number", Toast.LENGTH_LONG).show();
        }
    }
}