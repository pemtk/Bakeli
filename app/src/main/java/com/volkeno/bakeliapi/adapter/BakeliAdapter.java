package com.volkeno.bakeliapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.api.BakeliList;
import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.view.ListePresence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class BakeliAdapter extends RecyclerView.Adapter<BakeliAdapter.BakeliViewHolder> {

    private BakeliList bakeliLists;
    BakeliModel bakeliModel;
    private Context context;
    List<BakeliModel> bakeliModelList;
    Realm realm;

    public BakeliAdapter(BakeliList bakeliLists, Context context) {
        this.bakeliLists = bakeliLists;
        this.context = context;
    }

    public BakeliAdapter(List<BakeliModel> bakeliModelList, ListePresence context) {
        this.context = context;
        this.bakeliModelList = bakeliModelList;
    }

    @Override
    public BakeliViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, null);
        BakeliViewHolder bakeliViewHolder = new BakeliViewHolder(view);
        return bakeliViewHolder;
    }

    @Override
    public void onBindViewHolder(final BakeliViewHolder holder, final int position) {

        Realm.init(context);
        realm = Realm.getDefaultInstance();
        android.text.format.DateFormat dateF = new android.text.format.DateFormat();
        android.text.format.DateFormat arrive = new android.text.format.DateFormat();
        final android.text.format.DateFormat depart = new android.text.format.DateFormat();

        bakeliModel = realm.where(BakeliModel.class).equalTo("id", bakeliModelList.get(position).getId()).findFirst();
        holder.prenom.setText(bakeliModelList.get(position).getPrenom());


        holder.parentLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final RealmResults<BakeliModel> results = realm.where(BakeliModel.class).findAll();
                realm.executeTransaction(new Realm.Transaction() {
                @Override
                    public void execute(Realm realm) {

                            results.get(position).setHeure_depart(depart.format("HH:mm:ss a", new Date()).toString());
                    }
                 });
                holder.heure_depart.setText("heure départ "+results.get(position).getHeure_depart());
                return false;
            }
        });
        holder.heure_depart.setText("heure départ "+bakeliModelList.get(position).getHeure_depart());
        //holder.nom.setText(bakeliLists.getBakeliModels().get(position).getNom());
        holder.email.setText(bakeliModelList.get(position).getEmail());
        holder.date.setText("date : "+bakeliModelList.get(position).getDate());
        holder.heure_arrivee.setText("HeureArriv "+bakeliModelList.get(position).getHeure_arrivee());

        /*
        holder.ecole.setText(bakeliLists.getBakeliModels().get(position).getEcole());
        holder.objectifs.setText(bakeliLists.getBakeliModels().get(position).getObjectifs());
        holder.formation_suivie.setText(bakeliLists.getBakeliModels().get(position).getFormation_suivie());
        holder.phone.setText(bakeliLists.getBakeliModels().get(position).getPhone());
        holder.type_formation.setText(bakeliLists.getBakeliModels().get(position).getType_formation());
        holder.civilite.setText(bakeliLists.getBakeliModels().get(position).getCivilite());
        holder.maritus_status.setText(bakeliLists.getBakeliModels().get(position).getMaritus_status());
        holder.adresse.setText(bakeliLists.getBakeliModels().get(position).getAdresse());*/
    }

    @Override
    public int getItemCount() {
         return bakeliModelList.size();
    }

    public class BakeliViewHolder extends RecyclerView.ViewHolder{
        private TextView email, prenom, id, nom, ecole, objectifs, formation_suivie, phone, type_formation;
        private TextView civilite,maritus_status, adresse,date, heure_arrivee, heure_depart;
        private RelativeLayout parentLayout;

        public BakeliViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.user_list_item);
            prenom = itemView.findViewById(R.id.tv_bakeli_nom);
            email = itemView.findViewById(R.id.tv_bakeli_email);
            date = itemView.findViewById(R.id.tv_bakeli_date);
            heure_arrivee = itemView.findViewById(R.id.tv_bakeli_heure_arrivee);
            heure_depart = itemView.findViewById(R.id.tv_bakeli_heure_depart);

            /*
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
