package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2,e3,e4,e5,e6,e7;
    int b3;
    EtudiantDBHandler dbHandler=new EtudiantDBHandler(this);
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
         b1=(Button) findViewById(R.id.b1);
         b2=(Button) findViewById(R.id.b2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
         e1=(EditText) findViewById(R.id.e1);
         e2=(EditText) findViewById(R.id.e2);
       e3=(EditText) findViewById(R.id.e3);
         e4=(EditText) findViewById(R.id.e4);
        e5=(EditText) findViewById(R.id.e5);
         e6=(EditText) findViewById(R.id.e6);
        e7=(EditText) findViewById(R.id.e7);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.b1){
          if(e1.getText().toString().length()==0){
              Toast.makeText(this,"Id Obligatoire",Toast.LENGTH_SHORT).show();
          }
          else{

              Etudiant etudiant=dbHandler.getEtudiant(Integer.parseInt(e1.getText().toString()));
             // e1.setText(etudiant.getId());
              e2.setText(etudiant.getPrenom());
              e3.setText(etudiant.getNom());
              e4.setText(etudiant.getClasse());
              e5.setText(etudiant.getGroupe());
              e6.setText(etudiant.getLogin());
              e7.setText(etudiant.getPassword());
              b1.setText("Update");



              b1.setId(b3);


          }
        }
        else if(v.getId()==R.id.b2){
            setResult(RESULT_CANCELED);
            finish();
        }
        else if(v.getId()==b3){
            Etudiant etudiant1=new Etudiant();
            etudiant1.setId(Integer.parseInt(e1.getText().toString()));
            etudiant1.setPrenom(e2.getText().toString());
            etudiant1.setNom(e3.getText().toString());
            etudiant1.setClasse(e4.getText().toString());
            etudiant1.setGroupe(e5.getText().toString());
            etudiant1.setPrenom(e6.getText().toString());
            etudiant1.setPrenom(e7.getText().toString());
            dbHandler.updateEtudiant(etudiant1);
            setResult(RESULT_OK);
            finish();
        }
    }
}