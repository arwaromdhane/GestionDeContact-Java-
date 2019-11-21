package com.example.gestiondecontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class Affichage extends AppCompatActivity  {

    EditText rech ;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        rech = (EditText)findViewById(R.id.ed_rech);
        list = (ListView )findViewById(R.id.lv);
        MonAdapter ad = new MonAdapter(Affichage.this , Acceuil.data); //un constructeur qui prend en paramétre un context
        list.setAdapter(ad);
    }


}
