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

    @GET("liste-tous-les-bakelistes")
    Call<BakeliList> getAllBakeliste();

    @GET("pointages")
    Call<BakeliModelPresence> getAllBakelistePresence();

    @GET("pointages")
    Call<BakeliPresenceList> getAllBakelistePresenceList();

    @GET("liste-tous-les-bakelistes")
    Call<List<BakeliList>> getAllBakelist();

    @GET("liste-tous-les-bakelistes")
    Call<List<BakeliModel>> getListePresence();

    @POST("liste-tous-les-bakelistes")
    Call<BakeliModel> createBakeli(@Body BakeliModel bakeliModel);

    @POST("pointages")
    Call<BakeliModelPresence> createBakeliPresence(@Body BakeliModelPresence bakeliModelPresence);

    @FormUrlEncoded
    @POST("pointages")
    Call<BakeliModelPresence> createBakeliPresence(
            @Field("date") String date,
            @Field("heure_arrivee") String heure_arrivee,
            @Field("heure_depart") String heure_depart,
            @Field("bakeliste_id") String bakeliste_id,
            @Field("lieu_formation") String lieu_formation,
            @Field("status") String status
    );

    @PUT("pointages/{id}")
    Call<BakeliModelPresence> putBakeliPresence(@Path("id") String id, @Body BakeliModelPresence bakeliModelPresence);

    @PATCH("pointages/{id}")
    Call<BakeliModelPresence> patchBakeliPresence(@Path("id") String id, @Body BakeliModelPresence bakeliModelPresence);

}
