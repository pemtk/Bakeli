package com.volkeno.bakeliapi.api;

import com.volkeno.bakeliapi.model.BakeliModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public interface ApiInterface {

    @GET("/api/bakelistes")
    Call<BakeliList> getAllBakeliste();

    @GET("/api/bakelistes")
    Call<List<BakeliList>> getAllBakelist();

    @GET("/api/bakelistes")
    Call<List<BakeliModel>> getListePresence();

    @POST("/api/bakelistes")
    Call<BakeliModel> createBakeli(@Body BakeliModel bakeliModel);

}
