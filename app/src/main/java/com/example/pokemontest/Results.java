package com.example.pokemontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    TextView player_rank;
    TextView result_tv;
    ImageView metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        result_tv = findViewById(R.id.result_tv);
        player_rank = findViewById(R.id.rank);
        metrics = findViewById(R.id.metrics_iv);
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        Log.d("Score", "Score is: " + score);

        switch (score ) {
            case 0:
                resultRookie();
                break;
            case 10:
            case 20:
                resultBeginner();
                break;
            case 30:
            case 40:
                resultIntermediate();
                break;
            case 50:
            case 60:
                resultProf();
                break;
            case 70:
            case 80:
                resultVeteran();
                break;
            case 90:
                resultExpert();
                break;
            case 100:
                resultMaster();
                break;
        }
    }
    public void resultRookie() {
        player_rank.setText(R.string.rookie_r);
        result_tv.setText(R.string.rookie);
        metrics.setImageResource(R.drawable.percent_0);
    }

    public void resultBeginner() {
        player_rank.setText(R.string.beginner_r);
        result_tv.setText(R.string.beginner);
        metrics.setImageResource(R.drawable.percent_20);
    }

    public void resultIntermediate() {
        player_rank.setText(R.string.intermediate_r);
        result_tv.setText(R.string.intermediate);
        metrics.setImageResource(R.drawable.percent_40);
    }

    public void resultProf() {
        player_rank.setText(R.string.prof_r);
        result_tv.setText(R.string.prof);
        metrics.setImageResource(R.drawable.percent_60);
    }

    public void resultVeteran() {
        player_rank.setText(R.string.veteran_r);
        result_tv.setText(R.string.veteran);
        metrics.setImageResource(R.drawable.percent_80);
    }

    public void resultExpert() {
        player_rank.setText(R.string.expert_r);
        result_tv.setText(R.string.expert);
        metrics.setImageResource(R.drawable.percent_90);
    }

    public void resultMaster() {
        player_rank.setText(R.string.master_r);
        result_tv.setText(R.string.master);
        metrics.setImageResource(R.drawable.percent_100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.exit_group, false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_new_game) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}