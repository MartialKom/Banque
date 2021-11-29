package com.octest.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class ConnectedUser {
	public String nom;
public ConnectedUser(String nom) {
	this.nom=nom;
}
	public void connecter() {
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
		
		String req="insert into connectedUser values(?)";
		try {
		PreparedStatement prepare = (PreparedStatement) connexion.prepareStatement(req);
		prepare.setString(1, nom);
		connexion.setAutoCommit(false);
		prepare.executeUpdate();
		connexion.setAutoCommit(true);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connexion.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void deconnecter() {
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
		
		String req="delete from connectedUser where nomUser=? ";
		try {
		PreparedStatement prepare = (PreparedStatement) connexion.prepareStatement(req);
		prepare.setString(1, nom);
		connexion.setAutoCommit(false);
		prepare.executeUpdate();
		connexion.setAutoCommit(true);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connexion.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
