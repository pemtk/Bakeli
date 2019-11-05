package com.volkeno.bakeliapi.api;

import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.model.BakeliModelPresence;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public interface ApiInterface {

    @GET("/api/bakelis")
    Call<BakeliList> getAllBakeliste();

    @GET("/api/bakelistes")
    Call<BakeliModelPresence> getAllBakelistePresence();

    @GET("/api/bakeli_presences")
    Call<BakeliPresenceList> getAllBakelistePresenceList();

    @GET("/api/bakelis")
    Call<List<BakeliList>> getAllBakelist();

    @GET("/api/bakelis")
    Call<List<BakeliModel>> getListePresence();

    @POST("/api/bakelistes")
    Call<BakeliModel> createBakeli(@Body BakeliModel bakeliModel);

    @POST("/api/bakeli_presences")
    Call<BakeliModelPresence> createBakeliPresence(@Body BakeliModelPresence bakeliModelPresence);

    @FormUrlEncoded
    @POST("/api/bakeli_presences")
    Call<BakeliModelPresence> createBakeliPresence(
            @Field("date") String date,
            @Field("heure_arrivee") String heure_arrivee,
            @Field("heure_depart") String heure_depart,
            @Field("bakeli_id") String bakeli_id
    );

    @PUT("/api/bakeli_presences/{id}")
    Call<BakeliModelPresence> putBakeliPresence(@Path("id") String id, @Body BakeliModelPresence bakeliModelPresence);

    @PATCH("/api/bakelistes/{id}")
    Call<BakeliModelPresence> patchBakeliPresence(@Path("id") String id, @Body BakeliModelPresence bakeliModelPresence);

}
