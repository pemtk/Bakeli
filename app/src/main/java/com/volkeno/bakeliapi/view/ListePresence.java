package com.volkeno.bakeliapi.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.adapter.BakeliAdapter;
import com.volkeno.bakeliapi.api.RetrofitBakeli;
import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.model.BakeliModelPresence;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListePresence extends AppCompatActivity {

    private static final String TAG = "ListedePresence";

    private RecyclerView recyclerView;
    private BakeliModelPresence bakeliModelPresence;
    private List<BakeliModel> bakeliModelList;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_presence);

        Realm.init(this);
        realm = Realm.getDefaultInstance();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Liste de Présence");

        bakeliModelList = new ArrayList<>();
        afficher();

    }

    /**
     * initialisation de RecyclerView
     */
    private void initRecyclerView(){

        Log.d(TAG, "initRecyclerView: init recyclerview.");

        recyclerView = findViewById(R.id.recyclerview_liste_presence);
        BakeliAdapter usersAdapter = new BakeliAdapter( bakeliModelList, ListePresence.this);
        recyclerView.setAdapter(usersAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Méthode afficher des element de Realm
     */
    public void afficher(){
        Log.d(TAG, "initImageBitmap: preparing bitmap.");

        RealmResults<BakeliModel> results = realm.where(BakeliModel.class).findAll();

        for(BakeliModel bakeliste : results){

            BakeliModel Prenom = new BakeliModel(bakeliste.getPrenom(), bakeliste.getNom(), bakeliste.getEmail(), bakeliste.getEcole(), bakeliste.getObjectifs(), bakeliste.getFormation_suivie(), bakeliste.getPhone(), bakeliste.getType_formation(), bakeliste.getCivilite(), bakeliste.getMaritus_status(), bakeliste.getAdresse(), bakeliste.getDate(), bakeliste.getHeure_arrivee(), bakeliste.getHeure_depart());
            bakeliModelList.add(Prenom);
        }
        initRecyclerView();
    }
}
