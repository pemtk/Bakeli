package com.volkeno.bakeliapi.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.volkeno.bakeliapi.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextInputEditText login, mdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login");

        btnLogin = findViewById(R.id.btn_login);
        login = findViewById(R.id.ed_login);
        mdp = findViewById(R.id.ed_mdp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().trim().equals("admin") && mdp.getText().toString().trim().equals("bakeli1234")){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Login ou Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
