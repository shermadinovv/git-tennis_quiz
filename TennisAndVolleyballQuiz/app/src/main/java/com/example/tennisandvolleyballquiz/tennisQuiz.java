package com.example.tennisandvolleyballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class tennisQuiz extends AppCompatActivity {

    static int score = 0;
    int count = 0;

    Array array = new Array();
    result result_nesne = new result();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        score = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tennis_quiz);

        TextView q = findViewById(R.id.q);
        Button buttonA = (Button) findViewById(R.id.buttonA);
        Button buttonB = (Button) findViewById(R.id.buttonB);
        Button buttonC = (Button) findViewById(R.id.buttonC);
        Button buttonNext = (Button) findViewById(R.id.bt_next);

        Button[] buttons = {
                buttonA,
                buttonB,
                buttonC,
        };

        q.setText(array.quetions[count]);

        for(int i = 0; i < 3; i++){
            buttons[i].setText(array.answers[count][i]);
        }

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i = 0; i < 3; i++){
                    buttons[i].setEnabled(true);
                    buttons[i].setBackgroundResource(R.drawable.button_stroke_answer_press);
                }

                count++;

                if(count < 10){
                    q.setText(array.quetions[count]);

                    for(int i = 0; i < 3; i++){
                        buttons[i].setText(array.answers[count][i]);
                    }
                }

                if(count == 9)
                {
                    buttonNext.setText(R.string.finish);
                }
                if(count == 10){
                    result_nesne.setScore(score);
                    try {
                        Intent intent = new Intent(tennisQuiz.this, result.class);
                        startActivity(intent); finish();

                    }catch (Exception e){

                    }
                }

            }
        });

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrect(array.answers[count][0],array.correctAnswers[count])){
                    score ++;
                    buttonA.setBackgroundResource(R.drawable.button_stroke_correct_press);
                }
                else{
                    buttonA.setBackgroundResource(R.drawable.button_stroke_incorrect_press);
                }

                for(int i = 0; i < 3; i++){
                    buttons[i].setEnabled(false);
                    if(isCorrect(array.answers[count][i],array.correctAnswers[count])){
                        buttons[i].setBackgroundResource(R.drawable.button_stroke_correct_press);
                    }
                }
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrect(array.answers[count][1],array.correctAnswers[count])){
                    score ++;
                    buttonB.setBackgroundResource(R.drawable.button_stroke_correct_press);
                }
                else{
                    buttonB.setBackgroundResource(R.drawable.button_stroke_incorrect_press);
                }

                for(int i = 0; i < 3; i++){
                    buttons[i].setEnabled(false);
                    if(isCorrect(array.answers[count][i],array.correctAnswers[count])){
                        buttons[i].setBackgroundResource(R.drawable.button_stroke_correct_press);
                    }
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrect(array.answers[count][2],array.correctAnswers[count])){
                    score ++;
                    buttonC.setBackgroundResource(R.drawable.button_stroke_correct_press);
                }
                else{
                    buttonC.setBackgroundResource(R.drawable.button_stroke_incorrect_press);
                }

                for(int i = 0; i < 3; i++){
                    buttons[i].setEnabled(false);
                    if(isCorrect(array.answers[count][i],array.correctAnswers[count])){
                        buttons[i].setBackgroundResource(R.drawable.button_stroke_correct_press);
                    }
                }
            }
        });



        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    boolean isCorrect(int a, int b){
        if(a == b){
            return true;
        }
        else{
            return false;
        }
    }
}