package com.example.gestiondecontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Acceuil extends AppCompatActivity implements  View.OnClickListener {
    Button ajt , aff;
    EditText user ;
     static ArrayList <Contact> data = new  ArrayList <Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        charger();
        ajt = (Button)findViewById(R.id.ajout);
        aff = (Button) findViewById(R.id.afficher);
        user= (EditText)findViewById(R.id.id_user);
    }

    private void charger() {

        if(ContextCompat.checkSelfPermission(Acceuil.this, Manifest.permission.WRITE_EXTERNAL_STORAGE )!= PackageManager.PERMISSION_GRANTED)
        { ActivityCompat.requestPermissions(Acceuil.this , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE} , 1);}


        String dir = Environment.getExternalStorageDirectory().getPath();
        File f = new File(dir, "fichier.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String ligne = null;
            ligne = br.readLine();
            while ((ligne = br.readLine()) != null) {
                String[] t = ligne.split("#");
                data.add(new Contact(t[0], t[1], t[2]));
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            Log.e("msg", e.getMessage());
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        sauvgarder();
        super.onDestroy();
    }

    private void sauvgarder() {
        String dir = Environment.getExternalStorageDirectory().getPath();
        File f = new File(dir, "fichier.txt");
        try{
        FileWriter fw = new FileWriter(f ,false);
        BufferedWriter bw = new BufferedWriter(fw);
     for ( int i=0 ; i<data.size() ; i++){bw.write((data.get(i).nom + "#" +data.get(i).prenom + "#"+ data.get(i).tel + "\n"));}
        bw.close();
        fw.close();
    }
        catch(IOException e){
        Log.e ("msg" , e.getMessage());
    }
    }
}
