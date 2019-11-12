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

    private String date, heure_arrivee, heure_depart, bakeliste_id, lieu_formation, status;

    /**
     * Constructor
     *
     * @param date
     * @param heure_arrivee
     * @param heure_depart
     * @param bakeliste_id
     * @param lieu_formation
     * @param status
     */
    public BakeliModelPresence(String date, String heure_arrivee, String heure_depart, String bakeliste_id, String lieu_formation, String status) {
        this.date = date;
        this.heure_arrivee = heure_arrivee;
        this.heure_depart = heure_depart;
        this.bakeliste_id = bakeliste_id;
        this.lieu_formation = lieu_formation;
        this.status = status;
    }

    /**
     * Getter Setter
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBakeliste_id() {
        return bakeliste_id;
    }

    public void setBakeliste_id(String bakeliste_id) {
        this.bakeliste_id = bakeliste_id;
    }

    public String getLieu_formation() {
        return lieu_formation;
    }

    public void setLieu_formation(String lieu_formation) {
        this.lieu_formation = lieu_formation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
