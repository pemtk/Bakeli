package com.volkeno.bakeliapi.api;

import com.volkeno.bakeliapi.adapter.BakeliAdapter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class RetrofitBakeli {

    private static Retrofit retrofit = null;
    private static RetrofitBakeli apiManager;

    public static ApiInterface getBakeli() {

        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://bakeli2.000webhostapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;
    }

    public static RetrofitBakeli getInstance() {
        if (apiManager == null) {
            apiManager = new RetrofitBakeli();
        }
        return apiManager;
    }

}
