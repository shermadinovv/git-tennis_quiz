package com.example.tennisandvolleyballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textView = findViewById(R.id.result_text);
        Button buttonBack = (Button) findViewById(R.id.btn_back);

        textView.setText("Вы набрали " + score + " баллов из 10");

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(result.this, MainActivity.class);
                    startActivity(intent); finish();

                }catch (Exception e){

                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public static void setScore(int score) {
        result.score = score;
    }
}