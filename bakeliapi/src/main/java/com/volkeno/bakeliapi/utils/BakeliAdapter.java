package com.volkeno.bakeliapi.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.model.BakeliModel;

import java.util.List;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class BakeliAdapter extends RecyclerView.Adapter<BakeliAdapter.BakeliViewHolder>{

    private Context context;
    private List<BakeliModel> listOfBakeli;

    public BakeliAdapter(Context context, List<BakeliModel> listOfBakeli) {
        this.context = context;
        this.listOfBakeli = listOfBakeli;
    }

    @NonNull
    @Override
    public BakeliViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.bakeli_list, viewGroup, false);
        return new BakeliViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BakeliViewHolder holder, int i) {

        BakeliModel currentBakeli = listOfBakeli.get(i);
        holder.tv_bakeli_nom.setText(currentBakeli.getNom());
        holder.tv_bakeli_email.setText(currentBakeli.getEmail());
        holder.tv_bakeli_id.setText(String.valueOf(currentBakeli.getId()));
    }

    @Override
    public int getItemCount() {
        return listOfBakeli.size();
    }

    public class BakeliViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_bakeli_nom;
        private TextView tv_bakeli_email;
        private TextView tv_bakeli_id;
        public BakeliViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tv_bakeli_nom = itemView.findViewById(R.id.tv_bakeli_nom);
            this.tv_bakeli_email = itemView.findViewById(R.id.tv_bakeli_email);
            this.tv_bakeli_id = itemView.findViewById(R.id.tv_bakeli_id);
        }
    }
}
