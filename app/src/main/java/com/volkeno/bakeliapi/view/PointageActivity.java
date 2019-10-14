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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pointage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pointage");

        btnValider = findViewById(R.id.btn_valider);
        ptPhone = findViewById(R.id.pt_phone);

        recyclerView = findViewById(R.id.recyclerview);
        list = new BakeliList();

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String number = ptPhone.getText().toString().trim();

                RetrofitBakeli.getBakeli().getAllBakeliste().enqueue(new Callback<BakeliList>() {
                    @Override
                    public void onResponse(Call<BakeliList> call, Response<BakeliList> response) {

                        list = response.body();
                        /*for (BakeliModel bakeliModel : list.getBakeliModels()){
                            if (number.equals(bakeliModel.getPhone().trim())){
                                Toast.makeText(PointageActivity.this, "ok", Toast.LENGTH_SHORT).show();
                            }
                            if (number == null){
                                Toast.makeText(PointageActivity.this, "Entrer un numéro svp", Toast.LENGTH_SHORT).show();
                            }
                        }*/

                        for (int i=0; i<list.getBakeliModels().size(); i++){
                            if (number.equals(list.getBakeliModels().get(i).getPhone())){

                                Toast.makeText(PointageActivity.this, "ok", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(PointageActivity.this, ListePresence.class);
                                intent.putExtra("key_phone", number);
                                startActivity(intent);
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
        Bakeliste bakeliste = realm.createObject(Bakeliste.class, UUID.randomUUID().toString());
        // bakeliste.setId(realmDb.getNextKey());
        bakeliste.setPrenom(prenom);
        bakeliste.setNom(nom);
        bakeliste.setEmail(email);
        bakeliste.setTelephone(telephone);
        bakeliste.setAdresse(adresse);

        realm.commitTransaction();
    }

    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }
}

