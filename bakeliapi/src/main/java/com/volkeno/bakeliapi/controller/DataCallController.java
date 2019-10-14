package com.volkeno.bakeliapi.controller;

import android.util.Log;

import com.volkeno.bakeliapi.api.ApiManager;
import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.view.BakeliViewInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class DataCallController {
    private ApiManager manager = new ApiManager();

    String TAG = DataCallController.class.getSimpleName();

    public void getBakeli(final BakeliViewInterface viewInterface){
        Call<List<BakeliModel>> call = manager.getService().listBakeli();
        call.enqueue(new Callback<List<BakeliModel>>() {
            @Override
            public void onResponse(Call<List<BakeliModel>> call, Response<List<BakeliModel>> response) {

                if (!response.isSuccessful()){
                    Log.i(TAG, "Unsuccessful, code: "+response.code());
                    return;
                }
                else{
                    List<BakeliModel> bakeli = response.body();
                    viewInterface.setUpAdapterAndView(bakeli);
                }
            }
            @Override
            public void onFailure(Call<List<BakeliModel>> call, Throwable t) {
                Log.i(TAG, "Error : " + t.getLocalizedMessage());
            }
        });    }

}
