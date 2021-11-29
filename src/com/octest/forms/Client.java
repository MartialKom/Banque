package com.octest.forms;

public class Client {
public String nom;
public String prenom;
public String mail;
public String user;
public int nbre_compte;

public Client(String nom, String prenom, String mail, String user, int nbreC) {
	this.mail=mail;
	this.nbre_compte=nbreC;
	this.prenom=prenom;
	this.nom=nom;
	this.user=user;
}
}
