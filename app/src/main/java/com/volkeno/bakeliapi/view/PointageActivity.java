package com.volkeno.bakeliapi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.volkeno.bakeliapi.R;
import com.volkeno.bakeliapi.api.BakeliList;
import com.volkeno.bakeliapi.api.RetrofitBakeli;
import com.volkeno.bakeliapi.model.BakeliModel;
import com.volkeno.bakeliapi.model.BakeliModelPresence;

import java.util.Date;
import java.util.UUID;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointageActivity extends AppCompatActivity {

    private Button btnValider;
    private TextInputEditText ptPhone;
    private Realm realm;
    private BakeliList list;
    String number, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pointage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pointage");

        btnValider = findViewById(R.id.btn_valider);
        ptPhone = findViewById(R.id.pt_phone);

        Realm.init(this);
        realm = Realm.getDefaultInstance();

        list = new BakeliList();

        /**
         * btnValider permet de pointer un bakeliste et d'enrégistrer dans Realm et dans l'api bakeli_presences
         */
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final android.text.format.DateFormat dateF = new android.text.format.DateFormat();
                final android.text.format.DateFormat arrive = new android.text.format.DateFormat();
                final android.text.format.DateFormat depart = new android.text.format.DateFormat();

                number = ptPhone.getText().toString().trim();

                RetrofitBakeli.getBakeli().getAllBakeliste().enqueue(new Callback<BakeliList>() {
                    @Override
                    public void onResponse(Call<BakeliList> call, Response<BakeliList> response) {

                        list = response.body();
                        for (int i=0; i<list.getBakeliModels().size(); i++){
                            if (number.equals(list.getBakeliModels().get(i).getPhone())){

                                Toast.makeText(PointageActivity.this, String.format(dateF.format("HH:mm:ss a", new Date())+"Bienvenue %s %s",
                                                                                    list.getBakeliModels().get(i).getFirst_name(),
                                                                                    list.getBakeliModels().get(i).getLast_name()), Toast.LENGTH_SHORT).show();
                                realm.beginTransaction();

                                /**
                                 * ajouter element dans realm
                                 */
                                id = UUID.randomUUID().toString();
                                BakeliModel bakeliste = realm.createObject(BakeliModel.class, id);
                                bakeliste.setPhone(number);
                                bakeliste.setIdUser(list.getBakeliModels().get(i).getId().toString());
                                bakeliste.setFirst_name(list.getBakeliModels().get(i).getFirst_name().toString().trim());
                                bakeliste.setEmail(list.getBakeliModels().get(i).getEmail().toString().trim());
                                bakeliste.setDate(dateF.format("yyyy-MM-dd", new Date()).toString());
                                bakeliste.setHeure_arrivee(arrive.format("HH:mm:ss", new Date()).toString());
                                bakeliste.setHeure_depart("inefini");
                                bakeliste.setLieu_formation(list.getBakeliModels().get(i).getLieu_formation().toString().trim());
                                bakeliste.setStatus(list.getBakeliModels().get(i).getStatus().toString().trim());

                                //Toast.makeText(PointageActivity.this, list.getBakeliModels().get(i).getId().toString(),Toast.LENGTH_SHORT).show();
                                realm.commitTransaction();

                                /**
                                 * Ajouter dans l'api bakeli_presences
                                 */

                                Call<BakeliModelPresence> calll = RetrofitBakeli.getBakeli().createBakeliPresence(bakeliste.getDate().toString().trim(), bakeliste.getHeure_arrivee().toString().trim(),bakeliste.getHeure_depart().toString().trim(),bakeliste.getIdUser().toString().trim(),bakeliste.getLieu_formation().toString().trim(),bakeliste.getStatus().toString().trim());

                                calll.enqueue(new Callback<BakeliModelPresence>() {
                                    @Override
                                    public void onResponse(Call<BakeliModelPresence> call, Response<BakeliModelPresence> response) {
                                        Toast.makeText(PointageActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<BakeliModelPresence> call, Throwable t) {
                                        Toast.makeText(PointageActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<BakeliList> call, Throwable t) {
                        Toast.makeText(PointageActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}

