package com.volkeno.bakeliapi.view;

import android.app.Application;

import com.volkeno.bakeliapi.api.RetrofitBakeli;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class MainApplication extends Application {

    public static RetrofitBakeli apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = RetrofitBakeli.getInstance();
    }

}
