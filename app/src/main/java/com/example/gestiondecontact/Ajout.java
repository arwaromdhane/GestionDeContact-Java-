package com.example.gestiondecontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajout extends AppCompatActivity implements  View.OnClickListener {
    Button valider , quitter;
    EditText  nom , prenom, tele ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        valider = (Button)findViewById(R.id.vali);
        quitter = (Button) findViewById(R.id.quitt);
        nom = (EditText)findViewById(R.id.nom);
         prenom = (EditText)findViewById(R.id.prenom);
        tele = (EditText)findViewById(R.id.tel);

        valider.setOnClickListener(this);
        quitter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == valider){
            Contact c = new Contact(nom.getText().toString() ,prenom.getText().toString() , tele.getText().toString());
            Acceuil.data.add(c);
            Toast.makeText(Ajout.this , "Taille =" + Acceuil.data.size() ,Toast.LENGTH_SHORT).show();

        }
    }
}
