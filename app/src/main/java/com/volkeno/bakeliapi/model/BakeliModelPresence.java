package com.volkeno.bakeliapi.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class BakeliModelPresence  {

    @PrimaryKey
    private String id;

    private String date, heure_arrivee, heure_depart, bakeli_id;

    public BakeliModelPresence(String date, String heure_arrivee, String heure_depart, String bakeli_id) {
        this.date = date;
        this.heure_arrivee = heure_arrivee;
        this.heure_depart = heure_depart;
        this.bakeli_id = bakeli_id;
    }

    public BakeliModelPresence() {
    }

    public String getIdP() {
        return id;
    }

    public void setIdP(String idP) {
        this.id = idP;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure_arrivee() {
        return heure_arrivee;
    }

    public void setHeure_arrivee(String heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public String getBakeliId() {
        return bakeli_id;
    }

    public void setBakeliId(String bakeli_id) {
        this.bakeli_id = bakeli_id;
    }
}
