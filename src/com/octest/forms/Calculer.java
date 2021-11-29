package com.octest.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;

public class Calculer {
	
	public String resultat;
	public int c;
	
	public void virement(String numeroD, String numeroR, String montant) {
					
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
		

		String conn="{? = call virement (?,?,?)}";
		
		
			
			CallableStatement state;
			try {
				state = (CallableStatement) connexion.prepareCall(conn);
				state.registerOutParameter(1, Types.INTEGER);
				state.setString(2, numeroD);
				state.setString(3, numeroR);
				state.setString(4, montant);
				state.execute();
				
				int a = state.getInt(1);
				c=a;
				if(c==1) {
					resultat="Virement effectué";
				}
			} catch (SQLException e) {
				c=3;
			resultat=e.getMessage();
				
			}
			
	
	}
	public void crediter(String numCompte, String montant) {
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
		
		String conn="{? = call crediter (?,?)}";
		CallableStatement state;
		try {
			connexion.setAutoCommit(false);
			state = (CallableStatement) connexion.prepareCall(conn);
			state.registerOutParameter(1, Types.INTEGER);
			state.setString(2, numCompte);
			state.setString(3, montant);
			state.execute();
			
			int a = state.getInt(1);
			c=a;
			if(c==1) {
				resultat="Creditation effectuée";
				connexion.commit();
				
			}
		} catch (SQLException e) {
			c=3;
		resultat=e.getMessage();
		
		try {
			connexion.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			
		}
		
	}

	public void debiter(String numCompte, String montant) {
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
		
		String conn="{? = call debiter (?,?)}";
		CallableStatement state;
		
		try {
			state = (CallableStatement) connexion.prepareCall(conn);
			state.registerOutParameter(1, Types.INTEGER);
			state.setString(2, numCompte);
			state.setString(3, montant);
			state.execute();
			
			int a = state.getInt(1);
			c=a;
			if(c==1) {
				resultat="Débitation effectuée";
			}
		} catch (SQLException e) {
			c=3;
		resultat=e.getMessage();
			
		}
		
	}
	public void emprunter (String numCompte, String montant) {
		
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
		
		String req="insert into pret values (?,?)";
		
		String conn="{? = call emprunter (?,?)}";
		CallableStatement state;
		CallableStatement state1;
		
		try {
		state = (CallableStatement) connexion.prepareCall(conn);
		state.registerOutParameter(1, Types.INTEGER);
		state.setString(2, numCompte);
		state.setString(3, montant);
		state.execute();
		
		int a = state.getInt(1);
		c=a;
		
		if(c==1) {
			resultat="Non Eligible pour le virement";
		}
		else if(c==2) {
			resultat="Vous devez au préalable rembourser votre pret";
			c=2;
		}
		else if(c==0) {
			crediter(numCompte, montant);
			
			if(this.c==1) {
			
			PreparedStatement prepare=(PreparedStatement) connexion.prepareStatement(req);
			prepare.setString(1, numCompte);
			prepare.setString(2, montant);
			prepare.executeUpdate();
			c=1;
			resultat="emprunt effectué";}
		}
		
		}catch(SQLException e) {
			resultat = e.getMessage();
			c=3;
		}
	}
	
}
