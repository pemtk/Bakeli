package com.volkeno.bakeliapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.api.BakeliList;
import com.volkeno.bakeliapi.model.BakeliModel;

import java.util.List;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class BakeliAdapter extends RecyclerView.Adapter<BakeliAdapter.BakeliViewHolder> {

    private BakeliList bakeliLists;
    private Context context;

    public BakeliAdapter(BakeliList bakeliLists, Context context) {
        this.bakeliLists = bakeliLists;
        this.context = context;
    }

    @Override
    public BakeliViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, null);
        BakeliViewHolder bakeliViewHolder = new BakeliViewHolder(view);
        return bakeliViewHolder;
    }

    @Override
    public void onBindViewHolder(BakeliViewHolder holder, final int position) {
        holder.prenom.setText(bakeliLists.getBakeliModels().get(position).getPrenom());
        //holder.nom.setText(bakeliLists.getBakeliModels().get(position).getNom());
        holder.email.setText(bakeliLists.getBakeliModels().get(position).getEmail());/*
        holder.ecole.setText(bakeliLists.getBakeliModels().get(position).getEcole());
        holder.objectifs.setText(bakeliLists.getBakeliModels().get(position).getObjectifs());
        holder.formation_suivie.setText(bakeliLists.getBakeliModels().get(position).getFormation_suivie());
        holder.phone.setText(bakeliLists.getBakeliModels().get(position).getPhone());
        holder.type_formation.setText(bakeliLists.getBakeliModels().get(position).getType_formation());
        holder.civilite.setText(bakeliLists.getBakeliModels().get(position).getCivilite());
        holder.maritus_status.setText(bakeliLists.getBakeliModels().get(position).getMaritus_status());
        holder.adresse.setText(bakeliLists.getBakeliModels().get(position).getAdresse());
        holder.date.setText(bakeliLists.getBakeliModels().get(position).getDate());
        holder.heure_arrivee.setText(bakeliLists.getBakeliModels().get(position).getHeure_arrivee());
        holder.heure_depart.setText(bakeliLists.getBakeliModels().get(position).getHeure_depart());*/
    }

    @Override
    public int getItemCount() {
        return bakeliLists.getBakeliModels().size();
    }


    public class BakeliViewHolder extends RecyclerView.ViewHolder{
        private TextView email, prenom, id, nom, ecole, objectifs, formation_suivie, phone, type_formation;
        private TextInputEditText civilite,maritus_status, adresse,date, heure_arrivee, heure_depart;

        public BakeliViewHolder(View itemView) {
            super(itemView);
            prenom = itemView.findViewById(R.id.tv_bakeli_nom);
            email = itemView.findViewById(R.id.tv_bakeli_email);
            id = itemView.findViewById(R.id.tv_bakeli_id);/*
            nom = itemView.findViewById(R.id.ed_nom);
            ecole = itemView.findViewById(R.id.ed_ecole);
            objectifs = itemView.findViewById(R.id.ed_objectif);
            formation_suivie = itemView.findViewById(R.id.ed_formation_suivie);
            phone = itemView.findViewById(R.id.ed_phone);
            type_formation = itemView.findViewById(R.id.ed_type_formation);
            civilite = itemView.findViewById(R.id.ed_civilite);
            maritus_status = itemView.findViewById(R.id.ed_maritus_status);
            adresse = itemView.findViewById(R.id.ed_adresse);
            date = itemView.findViewById(R.id.ed_Date);
            heure_arrivee = itemView.findViewById(R.id.ed_heure_arrivee);
            heure_depart = itemView.findViewById(R.id.ed_heure_depart);*/
        }
    }
}
