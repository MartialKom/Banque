package com.octest.forms;

import java.sql.Date;

public class Compte {
public int numero;
public float solde;
public String type;
public Date date;
public String nomU;


public Compte (int numero, float solde, String type, Date date, String nomU) {
	this.date=date;
	this.nomU=nomU;
	this.numero=numero;
	this.solde=solde;
	this.type=type;
}

}
