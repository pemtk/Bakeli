package com.volkeno.bakeliapi.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.volkeno.bakeliapi.R;

public class HomeActivity extends AppCompatActivity {

    CardView cardInscription, cardListe, cardPointage, cardParametre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menu");

        cardInscription = findViewById(R.id.cardInsciption);
        cardListe = findViewById(R.id.card_liste);
        cardPointage = findViewById(R.id.card_pointage);

        cardListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cardInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Formulaire_Activity.class);
                startActivity(intent);
            }
        });

        cardPointage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PointageActivity.class);
                startActivity(intent);
            }
        });
    }
}
