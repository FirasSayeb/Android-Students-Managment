package com.example.examen;

public class Etudiant {
	private int id;
	private String prenom,nom,classe,groupe,login,password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Etudiant(int id, String prenom, String nom, String classe,
			String groupe, String login, String password) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.classe = classe;
		this.groupe = groupe;
		this.login = login;
		this.password = password;
	}
	public Etudiant(String prenom, String nom, String classe,
			String groupe, String login, String password) {
		
		
		this.prenom = prenom;
		this.nom = nom;
		this.classe = classe;
		this.groupe = groupe;
		this.login = login;
		this.password = password;
	}
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "[ID=" + id + ", PRENOM=" + prenom + ", NOM=" + nom
				+ ", CLASSE=" + classe + ", G=" + groupe + ", LOGIN="
				+ login + ", PWD=" + password + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
