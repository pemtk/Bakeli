package com.volkeno.bakeliapi.view;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.volkeno.bakeliapi.R;

public class ParametreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pointage");
    }
}
