package com.example.examen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class EtudiantDBHandler extends SQLiteOpenHelper {

	// All Static variables
		// Database Version
		private static final int DATABASE_VERSION = 1;
		// Database Name
		private static final String DATABASE_NAME = "DB_Etudiants";
		private static final String TABLE_ETUDIANTS = "table_etudiants";
		private static final String COLONNE_ID = "id";
		private static final String COLONNE_NOM = "nom";
		private static final String COLONNE_PRENOM = "prenom";
		private static final String COLONNE_CLASSE = "classe";
		private static final String COLONNE_GROUPE = "groupe";
		private static final String COLONNE_LOGIN = "login";
		private static final String COLONNE_PASSWORD= "password";
		
		private static final int COLONNE_ID_ID = 0;
		private static final int COLONNE_NOM_ID = 2;
		private static final int COLONNE_PRENOM_ID = 1;
		private static final int COLONNE_CLASSE_ID = 3;
		private static final int COLONNE_GROUPE_ID = 4;
		private static final int COLONNE_LOGIN_ID = 5;
		private static final int COLONNE_PASSWORD_ID= 6;
		
		private static final String REQUETE_CREATION_BD = "create table "+ TABLE_ETUDIANTS + 
		" (" + COLONNE_ID+ " integer primary key autoincrement, " +
		COLONNE_PRENOM + " TEXT not null, " +
		COLONNE_NOM + " TEXT not null, " +
		COLONNE_CLASSE + " TEXT not null, " +
		COLONNE_GROUPE + " TEXT not null, " +
		COLONNE_LOGIN  + " TEXT not null, " +
		COLONNE_PASSWORD+ " TEXT not null); ";
		
		public EtudiantDBHandler(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		public EtudiantDBHandler(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase arg0) {
			// TODO Auto-generated method stub
			arg0.execSQL(REQUETE_CREATION_BD);
			

		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE" + TABLE_ETUDIANTS + ";");
			// Cr�ation de la nouvelle structure.
			onCreate(db);

		}
		public void updateEtudiant(Etudiant e){
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues values=new ContentValues();
			values.put("id",e.getId());
			values.put("nom",e.getNom());
			values.put("prenom",e.getPrenom());
			values.put("classe",e.getClasse());
			values.put("groupe",e.getGroupe());
			values.put("login",e.getLogin());
			values.put("password",e.getPassword());
			db.update(TABLE_ETUDIANTS, values,
					COLONNE_ID + " = "
							+ e.getId(), null);

		}
		public void removeEtudiant(int i)
		{
			
		}
		public void removeEtudiant(String login)
		{
			
		}
		public boolean insert(Etudiant e)
		{
			SQLiteDatabase maBD = this.getWritableDatabase();
			ContentValues valeurs = new ContentValues();
			valeurs.put(COLONNE_PRENOM, e.getPrenom());
			valeurs.put(COLONNE_NOM, e.getNom());
			valeurs.put(COLONNE_CLASSE, e.getClasse());
			valeurs.put(COLONNE_GROUPE, e.getGroupe());
			valeurs.put(COLONNE_LOGIN, e.getLogin());
			valeurs.put(COLONNE_PASSWORD, e.getPassword());
		
			maBD.insert(TABLE_ETUDIANTS, null, valeurs);
			maBD.close();
			
			return true;
		}
		
		public ArrayList<Etudiant> getAllEtudiants()
		{
			SQLiteDatabase maBD = this.getReadableDatabase();
			Cursor c = maBD.query(TABLE_ETUDIANTS,
			new String[] { COLONNE_ID, COLONNE_PRENOM, COLONNE_NOM,COLONNE_CLASSE,COLONNE_GROUPE,
					COLONNE_LOGIN,COLONNE_PASSWORD },null, null, null,null, null);
			if (c==null||c.getCount() == 0)
				return new ArrayList<Etudiant>(0);
			ArrayList<Etudiant> le = new ArrayList<Etudiant>(c.getCount());
			c.moveToFirst();
			do {
				Etudiant e = new Etudiant();
				e.setId(c.getInt(COLONNE_ID_ID));
				e.setPrenom(c.getString(COLONNE_PRENOM_ID));
				e.setNom(c.getString(COLONNE_NOM_ID));
				e.setClasse(c.getString(COLONNE_CLASSE_ID));
				e.setGroupe(c.getString(COLONNE_GROUPE_ID));
				e.setLogin(c.getString(COLONNE_LOGIN_ID));
				e.setPassword(c.getString(COLONNE_PASSWORD_ID));
				
				
				le.add(e);
			} while (c.moveToNext());
				// Ferme le curseur pour lib�rer les ressources.
			c.close();
			return le;
			
			
		}
		public Etudiant getEtudiant(int eid)
		{
			Etudiant e = new Etudiant();
			
			SQLiteDatabase db=this.getReadableDatabase();
			Cursor c=db.query(TABLE_ETUDIANTS,new String[]{
							COLONNE_ID,COLONNE_PRENOM,COLONNE_NOM,COLONNE_CLASSE,COLONNE_GROUPE,COLONNE_LOGIN,COLONNE_PASSWORD}
					,COLONNE_ID+"="+eid,null,null,null,null);

			c.moveToFirst();
			e.setId(c.getInt(0));
			e.setPrenom(c.getString(1));
			e.setNom(c.getString(2));
			e.setClasse(c.getString(3));
			e.setGroupe(c.getString(4));
			e.setLogin(c.getString(5));
			e.setPassword(c.getString(6));
			return e;
			
			
			
		}
		public Etudiant getEtudiant(String log)
		{
			Etudiant e = new Etudiant();
			///
			
			
			return e;
			
			
			
		}

}
