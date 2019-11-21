package com.example.gestiondecontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   Button bte , bval;
   EditText  ednom , edmdp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bte = (Button)findViewById(R.id.btn_quitt);
        bval = (Button) findViewById(R.id.btn_val);
        ednom = (EditText)findViewById(R.id.btn_nom);
        edmdp = (EditText)findViewById(R.id.btn_mdp);

        bte.setOnClickListener(this);
        bval.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == bte){this.finish();}
        else{
            Toast.makeText(this , "",Toast.LENGTH_SHORT).show();
            String nom = ednom.getText().toString() ;
            String mp = edmdp.getText().toString() ;
            if (nom.equals("issat")){ if (mp.equals("123")){
                Toast.makeText(MainActivity.this , "Bienvenu" + nom ,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this , Acceuil.class);
                startActivity(i);

            } }
        }

    }
}
