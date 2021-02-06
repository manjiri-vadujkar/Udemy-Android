package com.example.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout gameLayout;
    Button goBtn;
    Button playAgainBtn;
    TextView sumTextView;
    TextView scoreTextView;
    TextView resultTextView;
    TextView timerTextView;
    Random random;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    int correctAnsTag;
    int score;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameLayout = findViewById(R.id.gameLayout);
        goBtn = findViewById(R.id.goButton);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        sumTextView = findViewById(R.id.sumTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        resultTextView = findViewById(R.id.resultTextView);
        timerTextView = findViewById(R.id.timerTextView);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        gameLayout.setVisibility(View.INVISIBLE);
        goBtn.setVisibility(View.VISIBLE);
    }

    public void start(View view) {
        goBtn.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        setupGame();
    }

    public void setupGame() {
        score = 0;
        total = 0;
        String startScore = score + "/" + total;
        timerTextView.setText("30s");
        resultTextView.setText("");
        scoreTextView.setText(startScore);
        playAgainBtn.setVisibility(View.INVISIBLE);
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        createQues();
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String remTime = millisUntilFinished/1000 + "s";
                timerTextView.setText(remTime);
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Game Over");
                playAgainBtn.setVisibility(View.VISIBLE);
                btn0.setEnabled(false);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
            }
        }.start();
    }
    public void createQues() {
        random = new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);

        String ques = a + " + " + b;
        sumTextView.setText(ques);

        //createChoices
        ArrayList<Integer> choices = new ArrayList<Integer>();
        correctAnsTag = random.nextInt(4);
        //GridLayout gl = findViewById(R.id.gridLayout);
        //Button choice;
        choices.clear();
        for(int i=0;i<4;i++) {
            if(i == correctAnsTag) {
                //choice = gl.findViewWithTag(Integer.toString(i));
                //choice.setText(Integer.toString(a+b));
                choices.add(a+b);
            }
            else {
                int wrongAns = random.nextInt(40);
                while(wrongAns == a+b) {
                    wrongAns = random.nextInt(40);
                }
                //choice = gl.findViewWithTag(Integer.toString(i));
                //choice.setText(Integer.toString(wrongAns));
                choices.add(wrongAns);
            }
        }
        btn0.setText(Integer.toString(choices.get(0)));
        btn1.setText(Integer.toString(choices.get(1)));
        btn2.setText(Integer.toString(choices.get(2)));
        btn3.setText(Integer.toString(choices.get(3)));
    }

    public void chooseAnswer(View view) {
        //Log.i("its us", view.getTag().toString());
        if(Integer.toString(correctAnsTag).equals(view.getTag().toString())){
            //Log.i("Result", "Right");
            resultTextView.setText("Correct!");
            score++;
            total++;
        }
        else {
            //Log.i("Result", "Wrong");
            resultTextView.setText("Wrong:(");
            total++;
        }
        String newScore = score + "/" + total;
        scoreTextView.setText(newScore);
        createQues();
    }

    public void playAgain(View view) {
        setupGame();
    }
}