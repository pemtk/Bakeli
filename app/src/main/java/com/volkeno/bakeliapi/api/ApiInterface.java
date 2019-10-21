package com.volkeno.bakeliapi.api;

import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.model.LoginResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @FormUrlEncoded
    @POST("/api/bakelistes")
    Call<BakeliModel> userLogin(
            @Field("phone") String phone
    );
}
