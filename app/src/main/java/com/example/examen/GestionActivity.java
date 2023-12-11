package com.example.examen;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GestionActivity extends Activity  implements OnClickListener{

	Button bins,bcons,bu;
	
	
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		switch (requestCode){
			case (1): 
				switch (resultCode){
					case RESULT_OK:
					Toast.makeText(this,"Inscription valider", Toast.LENGTH_LONG).show();
					break;
					case RESULT_CANCELED:
					Toast.makeText(this,"Inscription Annuler", Toast.LENGTH_LONG).show();
					break;
				}
			break;
		
			
		}switch (requestCode){
			case(4):{
				switch (resultCode){
					case RESULT_OK:
						Toast.makeText(this,"Mise a jour reussi", Toast.LENGTH_LONG).show();
						break;
					case RESULT_CANCELED:
						Toast.makeText(this,"Mise a jour  Annuler", Toast.LENGTH_LONG).show();
						break;
				}
			}
		}
	}


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);
        
        bins=(Button)findViewById(R.id.bins);
         bcons=(Button)findViewById(R.id.bcons);
         bins.setOnClickListener(this);
          bcons.setOnClickListener(this);
		  bu=(Button)  findViewById(R.id.bup);
		  bu.setOnClickListener(this);
    /*******************************/  
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }


	@Override
	public void onClick(View arg0) {
	

		if(arg0.getId()==R.id.bins) {


			Intent i1 = new Intent(this, Inscription.class);
			startActivityForResult(i1, 1);

		}
		

			else if(arg0.getId()==R.id.bcons) {
			Intent i3 = new Intent(this, ConsulterActivity.class);
			startActivityForResult(i3, 3);
		}
		else{
			Intent intent=new Intent(this, updateActivity.class);
			startActivityForResult(intent,4);
		}
		/*****************************************/
		}
		
	}
    

