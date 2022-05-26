package com.example.tennisandvolleyballquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStartT = (Button) findViewById(R.id.btn_A);
        Button buttonStartV = (Button) findViewById(R.id.buttonStartV);
        Button buttonInfo = (Button) findViewById(R.id.buttonInfo);

        buttonStartT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, tennisQuiz.class);
                    startActivity(intent); finish();

                }catch (Exception e){

                }
            }
        });

        buttonStartV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, volleyballQuiz.class);
                    startActivity(intent); finish();

                }catch (Exception e){

                }
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, info.class);
                    startActivity(intent); finish();

                }catch (Exception e){

                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}