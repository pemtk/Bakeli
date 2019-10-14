package com.volkeno.bakeliapi.view;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.adapter.BakeliAdapter;
import com.volkeno.bakeliapi.api.BakeliList;
import com.volkeno.bakeliapi.api.RetrofitBakeli;
import com.volkeno.bakeliapi.model.BakeliModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListePresence extends AppCompatActivity {

    private TextView tv_email, tv_prenom, tv_phone, tv_nom;
    private String prenom, nom, phone;

    private RecyclerView recyclerView;
    private BakeliList list;
    private BakeliModel bakeliModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_presence);

        recyclerView = findViewById(R.id.recyclerview_liste_presence);
        list = new BakeliList();

        phone = getIntent().getStringExtra("key_phone");

        RetrofitBakeli.getBakeli().getAllBakeliste().enqueue(new Callback<BakeliList>() {
            @Override
            public void onResponse(Call<BakeliList> call, Response<BakeliList> response) {

                list = response.body();

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListePresence.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                BakeliAdapter usersAdapter = new BakeliAdapter(list, ListePresence.this);
                recyclerView.setAdapter(usersAdapter);
            }

            @Override
            public void onFailure(Call<BakeliList> call, Throwable t) {
                Toast.makeText(ListePresence.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
