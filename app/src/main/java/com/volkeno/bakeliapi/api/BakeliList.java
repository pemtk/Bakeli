package com.volkeno.bakeliapi.api;

import com.google.gson.annotations.SerializedName;
import com.volkeno.bakeliapi.model.BakeliModel;

import java.util.List;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class BakeliList {

    @SerializedName("data")
    private List<BakeliModel> bakeliModels;

    public BakeliList(List<BakeliModel> bakeliModels) {
        this.bakeliModels = bakeliModels;
    }

    public BakeliList() {

    }

    public List<BakeliModel> getBakeliModels() {
        return bakeliModels;
    }

    public void setBakeliModels(List<BakeliModel> bakeliModels) {
        this.bakeliModels = bakeliModels;
    }
}
