package com.example.pokemontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    TextView result_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        result_tv = (TextView) findViewById(R.id.result_tv);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        Log.d("Score", "Score is: " + score);

        switch (score ) {
            case 0:
                result_tv.setText(R.string.no_knowledge);
            case 10:
            case 20:
                result_tv.setText(R.string.beginner);
            case 30:
            case 40:
                result_tv.setText(R.string.intermediate);
            case 50:
            case 60:
                result_tv.setText(R.string.prof);
            case 70:
            case 80:
                result_tv.setText(R.string.veteran);
            case 90:
                result_tv.setText(R.string.expert);
            case 100:
                result_tv.setText(R.string.guru);
        }
    }

    public void resultBeginner() {

    }
}