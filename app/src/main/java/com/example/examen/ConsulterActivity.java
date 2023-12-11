package com.example.examen;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ConsulterActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consulter);
		EtudiantDBHandler eh=new EtudiantDBHandler(this);
		List<Etudiant> l= eh.getAllEtudiants();
		String s="";
		for(Etudiant e:l)
		{
			s+=e.toString()+"\n";
		}

		TextView t=(TextView)findViewById(R.id.le);
		//Toast.makeText(this,"ETUDIANTS "+l.size()+": "+s, Toast.LENGTH_LONG).show();
		t.setText(s);
		Button b=(Button)findViewById(R.id.bcan);
		b.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		setResult(RESULT_CANCELED);
		finish();
	}

}
