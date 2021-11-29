package com.octest.forms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.octest.servlets.Testservlet;

public class Consultation {
	int resultat=1;

	public void insertion() {
		
		String lien="jdbc:mysql://localhost:3306/Banques";
		String user="root";
		String pass="mercip@p@123";
		Connection connexion=null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
		
		}
		try {
			connexion=DriverManager.getConnection(lien, user, pass);
		} catch (SQLException e1) {
			
		}
		
		try {
			statement= (Statement) connexion.createStatement();
			
			
		} catch (SQLException e) {
			
		}
		
		String req="select * from clients order by nbre_compte desc lock in share mode";
		String req2="select * from comptes lock in share mode";
		
		try {
			ResultSet r=statement.executeQuery(req);
			
			
			
			while(r.next()) {
				String nom=r.getString("nom");
				String prenom=r.getString("prenom");
				String mail=r.getString("mail");
				String userN=r.getString("username");
				int nbreC=r.getInt("nbre_compte");
				Client c = new Client(nom,prenom,mail,userN,nbreC);
				Testservlet.clients.add(c);
				
			}
			ResultSet r1=statement.executeQuery(req2);
			while(r1.next()) {
				int numero = r1.getInt("numero");
				Date date = r1.getDate("dateCreation");
				String nomU = r1.getString("user");
				String type = r1.getString("type");
				float solde = r1.getFloat("solde");
				
				Compte c1 = new Compte(numero,solde,type, date, nomU);
				Testservlet.comptes.add(c1);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
