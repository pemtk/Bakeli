package com.volkeno.bakeliapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class RetrofitBakeli {

    private final static String BASE_URL = "http://192.168.1.10:8000/";

    private static Retrofit retrofit = null;
    private static RetrofitBakeli apiManager;

    public static ApiInterface getBakeli() {

        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;
    }

    /*public static ApiInterface getBakeliPresence() {

        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.43.56:8000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;
    }*/

    public static RetrofitBakeli getInstance() {
        if (apiManager == null) {
            apiManager = new RetrofitBakeli();
        }
        return apiManager;
    }

}
