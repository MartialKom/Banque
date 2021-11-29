package com.octest.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;


public class Inscriptionform {
public String resultat;
public int c;


public void inscrire(HttpServletRequest request){
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


	String nom=request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	String mail=request.getParameter("email");
	String UserN = request.getParameter("user");
	String motPasse= request.getParameter("Pass");
	String compte = request.getParameter("a");
	String solde=  request.getParameter("solde");
	
	String req="insert into clients (nom,Prenom,mail,username,password) values(?,?,?,?,MD5(?))";
    String req1="insert into comptes(solde,type,user,dateCreation) values(?,?,?,now())";
  
	if(nom!=null) {
	try {
		connexion.setAutoCommit(false);
		PreparedStatement prepare=(PreparedStatement) connexion.prepareStatement(req);
		prepare.setString(1, nom);
		prepare.setString(2, prenom);
		prepare.setString(3, mail);
		prepare.setString(4, UserN);
		prepare.setString(5, motPasse);	
		prepare.executeUpdate();
		PreparedStatement prepare2= (PreparedStatement) connexion.prepareStatement(req1);
		prepare2.setString(1, solde);
		prepare2.setString(2,compte);
		prepare2.setString(3, UserN);
		prepare2.executeUpdate();
		
	
			resultat="Inscription réussi";
			c=1;
			connexion.commit();
			Consultation conn = new Consultation();
			conn.insertion();
			

		
	} catch (SQLException e) {
	resultat=e.getMessage();
	c=3;
	try {
		connexion.rollback();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	}
	
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


public void connexionC(HttpServletRequest request) {
	
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
	
	
	
	String userConn = request.getParameter("UserN2");
	String passConn = request.getParameter("pass2");
	String req="select * from clients where username=?";
	if(userConn!=null) {
	try {
		connexion.setAutoCommit(false);
		PreparedStatement prepare= (PreparedStatement) connexion.prepareStatement(req);
		
		prepare.setString(1, userConn);
		connexion.setAutoCommit(false);
		ResultSet r=prepare.executeQuery();
		if(!r.next()) {
			resultat="Mauvaise authentification";
			connexion.rollback();}
			
			else {
		
	
	
	String conn="{? = call connexionClient (?,?)}";
	
	
		
		CallableStatement state = (CallableStatement) connexion.prepareCall(conn);
		state.registerOutParameter(1, Types.INTEGER);
		state.setString(2, passConn);
		state.setString(3, userConn);
		state.execute();
		
		int a = state.getInt(1);
		c=a;
		if(c==0) {
			resultat="Mauvaise authentification";
			connexion.rollback();
		}
		else
		connexion.commit();}
	} catch (SQLException e) {
resultat=e.getMessage();
	}
	}
	}






public void connexion(HttpServletRequest request) {
	
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
	
	
	
	String userConn = request.getParameter("UserN2");
	String passConn = request.getParameter("pass2");
	String req="select * from userAdmin where user_name=?";
	if(userConn!=null) {
	try {
		connexion.setAutoCommit(false);
		PreparedStatement prepare= (PreparedStatement) connexion.prepareStatement(req);
		
		prepare.setString(1, userConn);
		connexion.setAutoCommit(false);
		ResultSet r=prepare.executeQuery();
		if(!r.next()) {
			resultat="Mauvaise authentification";
			connexion.rollback();}
			
			else {
		
	
	
	String conn="{? = call connexion (?,?)}";
	
	
		
		CallableStatement state = (CallableStatement) connexion.prepareCall(conn);
		state.registerOutParameter(1, Types.INTEGER);
		state.setString(2, passConn);
		state.setString(3, userConn);
		state.execute();
		
		int a = state.getInt(1);
		c=a;
		if(c==0) {
			resultat="Mauvaise authentification";
			connexion.rollback();
		}
		else
		connexion.commit();}
	} catch (SQLException e) {
resultat=e.getMessage();
	}
	}
	}

public String getResultat() {
	return this.resultat;
}

public void setResultat(String resultat) {
	this.resultat = resultat;
}

public void creationCompte(HttpServletRequest request){
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
	
	String UserN = request.getParameter("user1");
	String motPasse= request.getParameter("Pass1");
	String compte = request.getParameter("a1");
	String solde=  request.getParameter("solde1");
	
	String req="insert into comptes(solde,type,user,dateCreation) values(?,?,?,now())";
	String req1="select * from clients where username=?";
	
	
	if(UserN!=null) {
	try {	
		connexion.setAutoCommit(false);
PreparedStatement prepare= (PreparedStatement) connexion.prepareStatement(req1);
		
		prepare.setString(1, UserN);
		connexion.setAutoCommit(false);
		ResultSet r=prepare.executeQuery();
		if(!r.next()) {
			resultat="Mauvaise authentification";
			c=3;
			connexion.rollback();;}
		else {
	
String conn="{? = call connexionClient (?,?)}";
	
	
		
		CallableStatement state = (CallableStatement) connexion.prepareCall(conn);
		state.registerOutParameter(1, Types.INTEGER);
		state.setString(2, motPasse);
		state.setString(3, UserN);
		state.execute();
		
		int a = state.getInt(1);
		c=a;
		if(c==0) {
			resultat="Mauvaise authentification";
			c=3;
			connexion.rollback();
		}
		else {
		connexion.setAutoCommit(false);
		PreparedStatement prepare1=(PreparedStatement) connexion.prepareStatement(req);
		prepare1.setString(1, solde);
		prepare1.setString(2, compte);
		prepare1.setString(3, UserN);
	
		prepare1.executeUpdate();
		
		/*PreparedStatement prepare3= (PreparedStatement) connexion.prepareStatement(req2);
		prepare3.setString(1, UserN);
		prepare3.executeUpdate();*/
			resultat="Création réussi";
			c=1;
			
			connexion.commit();
			Consultation cons = new Consultation();
			cons.insertion();
			

		}
		}
	} catch (SQLException e) {
	resultat=e.getMessage();
	c=3;
	try {
		connexion.rollback();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	try {
		connexion.rollback();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}	
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
