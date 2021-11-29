package com.octest.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;

public class TauxInteret {

	public static void main() {
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
			e.printStackTrace();
		}

		String conn="{? = call ajoutTaux ()}";
		
		
		
		CallableStatement state;
		try {
			state = (CallableStatement) connexion.prepareCall(conn);
			state.registerOutParameter(1, Types.INTEGER);
			state.execute();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}

}
