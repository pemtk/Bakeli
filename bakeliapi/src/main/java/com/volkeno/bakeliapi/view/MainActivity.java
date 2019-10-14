package com.volkeno.bakeliapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.controller.DataCallController;
import com.volkeno.bakeliapi.controller.MainController;
import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.utils.BakeliAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BakeliViewInterface {

    String TAG = MainActivity.class.getSimpleName();
    private List<BakeliModel> listOfBakeli;
    private RecyclerView recyclerView;
    BakeliAdapter adapter;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.bakeli_rv);
        controller = new MainController(this, new DataCallController());
        getControllerBakeli();
    }

    private  void getControllerBakeli(){
        controller.getUsersFromDataSource();
    }

    @Override
    public void setUpAdapterAndView(List<BakeliModel> listOfBakeli) {
        this.listOfBakeli = listOfBakeli;
        if(this.listOfBakeli != null){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new BakeliAdapter(this, listOfBakeli);
            recyclerView.setAdapter(adapter);
        }
        else{
            Log.i(TAG, "user list is empty");
        }
    }
}
