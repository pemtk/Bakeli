package com.volkeno.bakeliapi.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.adapter.BakeliAdapter;
import com.volkeno.bakeliapi.api.BakeliList;
import com.volkeno.bakeliapi.api.RetrofitBakeli;
import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.model.LoginResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointageActivity extends AppCompatActivity {

    private Button btnValider;
    private TextInputEditText ptPhone;
    private Realm realm;
    private RecyclerView recyclerView;
    private BakeliList list;
    private BakeliModel bakeliModel;
    String number, id, prenom, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pointage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pointage");

        btnValider = findViewById(R.id.btn_valider);
        ptPhone = findViewById(R.id.pt_phone);
        recyclerView = findViewById(R.id.recyclerview);

        Realm.init(this);
        realm = Realm.getDefaultInstance();

        list = new BakeliList();

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final android.text.format.DateFormat dateF = new android.text.format.DateFormat();
                final android.text.format.DateFormat arrive = new android.text.format.DateFormat();
                final android.text.format.DateFormat depart = new android.text.format.DateFormat();

                number = ptPhone.getText().toString().trim();

                RetrofitBakeli.getBakeli().getAllBakeliste().enqueue(new Callback<BakeliList>() {
                    @Override
                    public void onResponse(Call<BakeliList> call, Response<BakeliList> response) {

                        list = response.body();
                        for (int i=0; i<list.getBakeliModels().size(); i++){
                            if (number.equals(list.getBakeliModels().get(i).getPhone())){

                                realm.beginTransaction();

                                id = UUID.randomUUID().toString();
                                BakeliModel bakeliste = realm.createObject(BakeliModel.class, UUID.randomUUID().toString());
                                // bakeliste.setId(realmDb.getNextKey());
                                bakeliste.setPhone(number);
                                bakeliste.setPrenom(list.getBakeliModels().get(i).getPrenom().toString().trim());
                                bakeliste.setEmail(list.getBakeliModels().get(i).getEmail().toString().trim());
                                bakeliste.setDate(dateF.format("dd-MM-yyyy", new Date()).toString());
                                bakeliste.setHeure_arrivee(arrive.format("HH:mm:ss a", new Date()).toString());
                                bakeliste.setHeure_depart("inefini");

                                realm.commitTransaction();
                                Toast.makeText(PointageActivity.this, String.format(dateF.format("HH:mm:ss a", new Date())+"Bienvenue %s %s",
                                                                                    list.getBakeliModels().get(i).getPrenom(),
                                                                                    list.getBakeliModels().get(i).getNom()), Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<BakeliList> call, Throwable t) {
                        Toast.makeText(PointageActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    public void ajouter(){
        realm.beginTransaction();

        id = UUID.randomUUID().toString();
        BakeliModel bakeliste = realm.createObject(BakeliModel.class, UUID.randomUUID().toString());
        // bakeliste.setId(realmDb.getNextKey());
        bakeliste.setPhone(number);

        realm.commitTransaction();
    }

}

