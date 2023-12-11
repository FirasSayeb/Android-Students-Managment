package com.example.examen;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Inscription extends Activity implements OnClickListener {

	Button bOK,bAN;
	EditText epn,en,ec,eg,el,epass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inscription);
		
		 bOK=(Button)findViewById(R.id.bok);
	        bAN=(Button)findViewById(R.id.ban);
	         epn=(EditText)findViewById(R.id.eprenom);
	         en=(EditText)findViewById(R.id.enom);
	         ec=(EditText)findViewById(R.id.eclasse);
	         eg=(EditText)findViewById(R.id.egroupe);
	         el=(EditText)findViewById(R.id.elogin);
	         epass=(EditText)findViewById(R.id.epassword);
	         
	        bOK.setOnClickListener(this);
	        bAN.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getId()== R.id.bok) {
			Etudiant e = new Etudiant(epn.getText().toString(),
					en.getText().toString(),
					ec.getText().toString(),
					eg.getText().toString(),
					el.getText().toString(),
					epass.getText().toString()

			);
			EtudiantDBHandler eh = new EtudiantDBHandler(this);
			eh.insert(e);
			setResult(RESULT_OK);
			finish();


		}

			setResult(RESULT_CANCELED);
			finish();
			

			
		}
	}


