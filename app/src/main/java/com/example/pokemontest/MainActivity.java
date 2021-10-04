package com.example.pokemontest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showResults(View view){
        //Question 1
        //Проверяем состояние каждого чекбокса

        CheckBox pokemonType1 = (CheckBox) findViewById(R.id.type_1);
        CheckBox pokemonType2 = (CheckBox) findViewById(R.id.type_2);
        CheckBox pokemonType3 = (CheckBox) findViewById(R.id.type_3);
        CheckBox pokemonType4 = (CheckBox) findViewById(R.id.type_4);


        if (pokemonType1.isChecked() && pokemonType2.isChecked() &&
                pokemonType3.isChecked() && !pokemonType4.isChecked()) {
            points += 1;
        }


        //Question 2
        RadioGroup pokemonFood = (RadioGroup) findViewById(R.id.releaseType_radio_group);
        if (pokemonFood.getCheckedRadioButtonId() == R.id.apricorn) {
            points += 1;
        }

        //Question 3
        RadioGroup enemyTeam = (RadioGroup) findViewById(R.id.evil_radio_group);
        if (enemyTeam.getCheckedRadioButtonId() == R.id.team_R) {
            points += 1;
        }

        //Question 4
        RadioGroup pokemonAmount = (RadioGroup) findViewById(R.id.amount_radio_group);
        if (pokemonAmount.getCheckedRadioButtonId() == R.id.all_amount_true) {
            points += 1;
        }

        //Question 5
        RadioGroup evolutionsAmount = (RadioGroup) findViewById(R.id.ev_radio_group);
        if (evolutionsAmount.getCheckedRadioButtonId() == R.id.evo_true) {
            points += 1;
        }

        //Question 6
        EditText mainHero_et = (EditText) findViewById(R.id.main_hero_tf);
        String mainHeroName = mainHero_et.getText().toString().trim();

        if (mainHeroName.equalsIgnoreCase("Эш")
                || mainHeroName.equalsIgnoreCase("Ash")) {
            points += 1;
        }

        //Question 7
        RadioGroup pokemonMeaning = (RadioGroup) findViewById(R.id.meaning_radio_group);
        if (pokemonMeaning.getCheckedRadioButtonId() == R.id.meaning_true) {
            points += 1;
        }

        //Question 8
        RadioGroup pokemonSleeping = (RadioGroup) findViewById(R.id.snorlax_radio_group);
        if (pokemonSleeping.getCheckedRadioButtonId() == R.id.snorlax_true) {
            points += 1;
        }

        //Question 9
        RadioGroup pikachuEnemy = (RadioGroup) findViewById(R.id.pika_enemy_radio_group);
        if (pikachuEnemy.getCheckedRadioButtonId() == R.id.enemy_true) {
            points += 1;
        }

        //Question 10
        RadioGroup authorInspiration = (RadioGroup) findViewById(R.id.inspiration_radio_group);
        if (pokemonMeaning.getCheckedRadioButtonId() == R.id.inspiration_true) {
            points += 1;
        }

        //Финальный счёт игрока
        int score = points * 10;

        Intent intent = new Intent(this, Results.class);
        intent.putExtra("score", score);
        startActivity(intent);



    }
}