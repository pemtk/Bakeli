package com.volkeno.bakeliapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class BakeliModel {

    private String prenom, nom, email, ecole, objectifs, formation_suivie, phone, type_formation;
    private String civilite, maritus_status, adresse, date, heure_arrivee, heure_depart, created_at, updated_at;
    private Integer id;

    public BakeliModel(String prenom, String nom, String email, String ecole, String objectifs, String formation_suivie, String phone, String type_formation, String civilite, String maritus_status, String adresse, String date, String heure_arrivee, String heure_depart) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.ecole = ecole;
        this.objectifs = objectifs;
        this.formation_suivie = formation_suivie;
        this.phone = phone;
        this.type_formation = type_formation;
        this.civilite = civilite;
        this.maritus_status = maritus_status;
        this.adresse = adresse;
        this.date = date;
        this.heure_arrivee = heure_arrivee;
        this.heure_depart = heure_depart;
    }

    public BakeliModel(String number) {
        this.phone=number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(String objectifs) {
        this.objectifs = objectifs;
    }

    public String getFormation_suivie() {
        return formation_suivie;
    }

    public void setFormation_suivie(String formation_suivie) {
        this.formation_suivie = formation_suivie;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType_formation() {
        return type_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getMaritus_status() {
        return maritus_status;
    }

    public void setMaritus_status(String maritus_status) {
        this.maritus_status = maritus_status;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
}
