package org.eclipse.model;

public class Utilisateur {

	private int numero;
	private String nom;
	private String prenom;
	private char sexe;
	private char type;

	public Utilisateur() {
	}

	public Utilisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Utilisateur(String nom, String prenom, char sexe, char type) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.type = type;
	}

	public Utilisateur(int numero, String nom, String prenom, char sexe, char type) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.type = type;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Utilisateur [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", type="
				+ type + "]";
	}

}
