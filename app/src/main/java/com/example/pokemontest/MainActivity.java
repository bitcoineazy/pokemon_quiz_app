package com.example.pokemontest;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    int points = 0;
    CheckBox pokemonType1;
    CheckBox pokemonType2;
    CheckBox pokemonType3;
    CheckBox pokemonType4;
    RadioGroup pokemonFood;
    RadioGroup enemyTeam;
    RadioGroup pokemonAmount;
    RadioGroup evolutionsAmount;
    EditText mainHero_et;
    RadioGroup pokemonMeaning;
    RadioGroup pokemonSleeping;
    RadioGroup pikachuEnemy;
    RadioGroup authorInspiration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Сбрасываем ответы если начали новую игру
        // (при вызове finish по пункту меню в Results активити)
        if (points > 0) {
            points = 0;
            pokemonType1.setChecked(false);
            pokemonType2.setChecked(false);
            pokemonType3.setChecked(false);
            pokemonType4.setChecked(false);
            pokemonFood.clearCheck();
            enemyTeam.clearCheck();
            pokemonAmount.clearCheck();
            evolutionsAmount.clearCheck();
            mainHero_et.getText().clear();
            pokemonMeaning.clearCheck();
            pokemonSleeping.clearCheck();
            pikachuEnemy.clearCheck();
            authorInspiration.clearCheck();
        }
    }

    public void showResults(View view){
        //Question 1
        //Проверяем состояние каждого чекбокса
        pokemonType1 = findViewById(R.id.type_1);
        pokemonType2 = findViewById(R.id.type_2);
        pokemonType3 = findViewById(R.id.type_3);
        pokemonType4 = findViewById(R.id.type_4);

        if (pokemonType1.isChecked() && pokemonType2.isChecked() &&
                pokemonType3.isChecked() && !pokemonType4.isChecked()) {
            points += 1;
        }

        //Question 2
        // Проверяем правильный ID в RadioGroup
        pokemonFood = findViewById(R.id.releaseType_radio_group);
        if (pokemonFood.getCheckedRadioButtonId() == R.id.apricorn) {
            points += 1;
        }

        //Question 3
        enemyTeam = findViewById(R.id.evil_radio_group);
        if (enemyTeam.getCheckedRadioButtonId() == R.id.team_R) {
            points += 1;
        }

        //Question 4
        pokemonAmount = findViewById(R.id.amount_radio_group);
        if (pokemonAmount.getCheckedRadioButtonId() == R.id.all_amount_true) {
            points += 1;
        }

        //Question 5
        evolutionsAmount = findViewById(R.id.ev_radio_group);
        if (evolutionsAmount.getCheckedRadioButtonId() == R.id.evo_true) {
            points += 1;
        }

        //Question 6
        mainHero_et = findViewById(R.id.main_hero_tf);
        String mainHeroName = mainHero_et.getText().toString().trim();

        if (mainHeroName.equalsIgnoreCase("Эш")
                || mainHeroName.equalsIgnoreCase("Ash")) {
            points += 1;
        }

        //Question 7
        pokemonMeaning = findViewById(R.id.meaning_radio_group);
        if (pokemonMeaning.getCheckedRadioButtonId() == R.id.meaning_true) {
            points += 1;
        }

        //Question 8
        pokemonSleeping = findViewById(R.id.snorlax_radio_group);
        if (pokemonSleeping.getCheckedRadioButtonId() == R.id.snorlax_true) {
            points += 1;
        }

        //Question 9
        pikachuEnemy = findViewById(R.id.pika_enemy_radio_group);
        if (pikachuEnemy.getCheckedRadioButtonId() == R.id.enemy_true) {
            points += 1;
        }

        //Question 10
        authorInspiration = findViewById(R.id.inspiration_radio_group);
        if (authorInspiration.getCheckedRadioButtonId() == R.id.inspiration_true) {
            points += 1;
        }

        //Финальный счёт игрока
        int score = points * 10;
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("score", score);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.new_game_group, false);
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}