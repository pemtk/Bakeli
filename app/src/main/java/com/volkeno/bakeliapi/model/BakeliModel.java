package com.volkeno.bakeliapi.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class BakeliModel extends RealmObject {

    @PrimaryKey
    private String id;

    private String first_name, last_name, email, ecole, objectifs, formation_suivie, phone, type_formation;
    private String civility, marital_status , address, date, heure_arrivee, heure_depart, lieu_formation, status;
    private String idUser;

    /**
     * Constructeur
     */

    public BakeliModel(String first_name, String last_name, String email, String ecole, String objectifs, String formation_suivie, String phone, String type_formation, String civility, String marital_status, String address, String date, String heure_arrivee, String heure_depart, String lieu_formation, String status, String idUser) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.ecole = ecole;
        this.objectifs = objectifs;
        this.formation_suivie = formation_suivie;
        this.phone = phone;
        this.type_formation = type_formation;
        this.civility = civility;
        this.marital_status = marital_status;
        this.address = address;
        this.date = date;
        this.heure_arrivee = heure_arrivee;
        this.heure_depart = heure_depart;
        this.lieu_formation = lieu_formation;
        this.status = status;
        this.idUser = idUser;
    }

    public BakeliModel() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     * Getter Setter
     */



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
