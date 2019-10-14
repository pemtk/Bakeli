package com.volkeno.bakeliapi.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.volkeno.bakeliapi.R;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class Dialog_add extends AppCompatDialogFragment {

    TextInputEditText edPrenom, edNom, edEmail, edEcole, edObjectifs, edFormationSuivie;
    TextInputEditText edPhone, edTypeFormation, edCivilite, edMaritusStatus, edAdresse;
    TextInputEditText edDate, edHeureArrivee, edHeureDepart;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_layout, null);

        builder.setView(view)
                .setTitle("Formulaire dinscription")
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Enrégister", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        edPrenom = view.findViewById(R.id.ed_prenom);
        edNom = view.findViewById(R.id.ed_nom);
        edEmail = view.findViewById(R.id.ed_email);
        edEcole = view.findViewById(R.id.ed_ecole);
        edObjectifs = view.findViewById(R.id.ed_objectif);
        edFormationSuivie = view.findViewById(R.id.ed_formation_suivie);
        edPhone = view.findViewById(R.id.ed_phone);
        edTypeFormation = view.findViewById(R.id.ed_type_formation);
        edCivilite = view.findViewById(R.id.ed_civilite);
        edMaritusStatus = view.findViewById(R.id.ed_maritus_status);
        edAdresse = view.findViewById(R.id.ed_adresse);
        edDate = view.findViewById(R.id.ed_Date);
        edHeureArrivee = view.findViewById(R.id.ed_heure_arrivee);
        edHeureDepart = view.findViewById(R.id.ed_heure_depart);
        return builder.create();
    }
}
