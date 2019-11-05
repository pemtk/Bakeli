package com.volkeno.bakeliapi.api;

import com.google.gson.annotations.SerializedName;
import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.model.BakeliModelPresence;

import java.util.List;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class BakeliPresenceList {

    @SerializedName("data")
    private List<BakeliModelPresence> bakeliModelPresences;

    public BakeliPresenceList(List<BakeliModelPresence> bakeliModelPresences) {
        this.bakeliModelPresences = bakeliModelPresences;
    }

    public BakeliPresenceList() {

    }

    public List<BakeliModelPresence> getBakeliModelPresences() {
        return bakeliModelPresences;
    }

    public void setBakeliModels(List<BakeliModelPresence> bakeliModelPresences) {
        this.bakeliModelPresences = bakeliModelPresences;
    }
}
