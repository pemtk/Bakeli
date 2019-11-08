package com.volkeno.bakeliapi.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.menu.DataModel;
import com.volkeno.bakeliapi.menu.RecyclerViewAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menu");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMain);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Inscription", R.drawable.ic_person_add, "#009688"));
        arrayList.add(new DataModel("Pointage", R.drawable.ic_touch_app, "#ff9800"));
        arrayList.add(new DataModel("Liste Présence", R.drawable.ic_format_list_bulleted, "#f44336"));
        arrayList.add(new DataModel("Parametre", R.drawable.ic_settings, "#817F7E"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(HomeActivity.this, arrayList, HomeActivity.this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/


        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }


    @Override
    public void onItemClick(DataModel item) {
        /*Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();*/
        if (item.text == "Inscription") {
            Intent intent = new Intent(HomeActivity.this, Formulaire_Activity.class);
            startActivity(intent);
        }
        if (item.text == "Pointage") {
            Intent intent = new Intent(HomeActivity.this, PointageActivity.class);
            startActivity(intent);
        }
        if (item.text == "Liste Présence") {
            Intent intent = new Intent(HomeActivity.this, ListePresence.class);
            startActivity(intent);
        }
        if (item.text == "Parametre") {
            Intent intent = new Intent(HomeActivity.this, ParametreActivity.class);
            startActivity(intent);
        }
    }
}