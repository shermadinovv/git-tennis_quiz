package com.example.tennisandvolleyballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class volleyballQuiz extends AppCompatActivity {

    static int score = 0;
    int count = 0;

    Array array = new Array();
    result result_nesne = new result();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        score = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volleybal_quiz);

        TextView q = findViewById(R.id.q);
        Button buttonA = findViewById(R.id.buttonA2);
        Button buttonB = findViewById(R.id.buttonB2);
        Button buttonC = findViewById(R.id.buttonC2);
        Button buttonNext = findViewById(R.id.bt_next2);

        Button[] buttons = {
                buttonA,
                buttonB,
                buttonC,
        };

        q.setText(array.quetionsV[count]);

        for(int i = 0; i < 3; i++){
            buttons[i].setText(array.answersV[count][i]);
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
                    q.setText(array.quetionsV[count]);

                    for(int i = 0; i < 3; i++){
                        buttons[i].setText(array.answersV[count][i]);
                    }
                }

                if(count == 9)
                {
                    buttonNext.setText(R.string.finish);
                }
                if(count == 10){
                    result_nesne.setScore(score);
                    try {
                        Intent intent = new Intent(volleyballQuiz.this, result.class);
                        startActivity(intent); finish();

                    }catch (Exception e){

                    }
                }

            }
        });

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrect(array.answersV[count][0],array.correctAnswersV[count])){
                    score ++;
                    buttonA.setBackgroundResource(R.drawable.button_stroke_correct_press);
                }
                else{
                    buttonA.setBackgroundResource(R.drawable.button_stroke_incorrect_press);
                }

                for(int i = 0; i < 3; i++){
                    buttons[i].setEnabled(false);
                    if(isCorrect(array.answersV[count][i],array.correctAnswersV[count])){
                        buttons[i].setBackgroundResource(R.drawable.button_stroke_correct_press);
                    }
                }
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrect(array.answersV[count][1],array.correctAnswersV[count])){
                    score ++;
                    buttonB.setBackgroundResource(R.drawable.button_stroke_correct_press);
                }
                else{
                    buttonB.setBackgroundResource(R.drawable.button_stroke_incorrect_press);
                }

                for(int i = 0; i < 3; i++){
                    buttons[i].setEnabled(false);
                    if(isCorrect(array.answersV[count][i],array.correctAnswersV[count])){
                        buttons[i].setBackgroundResource(R.drawable.button_stroke_correct_press);
                    }
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrect(array.answersV[count][2],array.correctAnswersV[count])){
                    score ++;
                    buttonC.setBackgroundResource(R.drawable.button_stroke_correct_press);
                }
                else{
                    buttonC.setBackgroundResource(R.drawable.button_stroke_incorrect_press);
                }

                for(int i = 0; i < 3; i++){
                    buttons[i].setEnabled(false);
                    if(isCorrect(array.answersV[count][i],array.correctAnswersV[count])){
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