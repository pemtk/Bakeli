package com.volkeno.bakeliapi.api;

import com.volkeno.bakeliapi.model.BakeliModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public interface ApiService {
    @GET("api/bakelistes")
    Call<List<BakeliModel>> listBakeli();
}
