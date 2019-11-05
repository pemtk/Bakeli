package com.volkeno.bakeliapi.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.adapter.BakeliAdapter;
import com.volkeno.bakeliapi.api.BakeliList;
import com.volkeno.bakeliapi.api.RetrofitBakeli;
import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.model.BakeliModelPresence;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Formulaire_Activity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private BakeliList list;
    private BakeliModel bakeliModel;
    private BakeliAdapter adapter;
    TextInputEditText edPrenom, edNom,ed_email,ed_ecole,ed_objectif, ed_formation_suivie;
    TextInputEditText ed_phone, ed_type_formation,ed_civilite, ed_maritus_status,ed_adresse;
    TextInputEditText ed_Date, ed_heure_arrivee,ed_heure_depart;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Formulaire D'inscription");

        edPrenom = findViewById(R.id.ed_prenom);
        edNom = findViewById(R.id.ed_nom);
        ed_email = findViewById(R.id.ed_email);
        ed_ecole = findViewById(R.id.ed_ecole);
        ed_objectif = findViewById(R.id.ed_objectif);
        ed_formation_suivie = findViewById(R.id.ed_formation_suivie);
        ed_phone = findViewById(R.id.ed_phone);
        ed_type_formation = findViewById(R.id.ed_type_formation);
        ed_civilite = findViewById(R.id.ed_civilite);
        ed_maritus_status = findViewById(R.id.ed_maritus_status);
        ed_adresse = findViewById(R.id.ed_adresse);
        ed_Date = findViewById(R.id.ed_Date);
        ed_heure_arrivee = findViewById(R.id.ed_heure_arrivee);
        ed_heure_depart = findViewById(R.id.ed_heure_depart);


        recyclerView = findViewById(R.id.recyclerview);
        list = new BakeliList();
        button = findViewById(R.id.enregistrer);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String prenom = edPrenom.getText().toString().trim();
        String nom = edNom.getText().toString().trim();
        String email = ed_email.getText().toString().trim();
        String ecole = ed_ecole.getText().toString().trim();
        String objectifs = ed_objectif.getText().toString().trim();
        String formationSuivie = ed_formation_suivie.getText().toString().trim();
        String phone = ed_phone.getText().toString().trim();
        String typeFormation = ed_type_formation.getText().toString().trim();
        String civilite = ed_civilite.getText().toString().trim();
        String maritusStatus = ed_maritus_status.getText().toString().trim();
        String adresse = ed_adresse.getText().toString().trim();
        String date = ed_Date.getText().toString().trim();
        String heureArrivee = ed_heure_arrivee.getText().toString().trim();
        String heureDepart = ed_heure_depart.getText().toString().trim();

        //bakeliModel = new BakeliModel(prenom, nom, email, ecole, objectifs,formationSuivie,phone,typeFormation,civilite,maritusStatus,adresse);

        RetrofitBakeli.getBakeli().createBakeli(bakeliModel).enqueue(new Callback<BakeliModel>() {
            @Override
            public void onResponse(Call<BakeliModel> call, Response<BakeliModel> response) {

                 Toast.makeText(Formulaire_Activity.this, ""+response.code(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<BakeliModel> call, Throwable t) {
                Toast.makeText(Formulaire_Activity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
