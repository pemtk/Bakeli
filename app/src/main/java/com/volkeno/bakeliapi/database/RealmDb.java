package com.volkeno.bakeliapi.database;

import android.app.Application;
import android.content.Context;

import com.volkeno.bakeliapi.model.BakeliModel;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class RealmDb extends Application {

    private static RealmDb instance = null;
    private static final String TAG = "RealmDb";
    private BakeliModel bakeliste;

    private Realm realm;
    private Context context;

    public static RealmDb getInstance(Context ctx){
        if (instance == null) instance = new RealmDb(ctx.getApplicationContext());
        return instance;
    }

    public RealmDb(Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
        this.context = context;
    }


}
