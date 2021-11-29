package com.octest.servlets;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.forms.Client;
import com.octest.forms.Compte;
import com.octest.forms.ConnectedUser;
import com.octest.forms.Consultation;
import com.octest.forms.Inscriptionform;



@WebServlet("/Testservlet")
public class Testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList<Compte> comptes= new ArrayList<>();
	public static ArrayList<Client> clients = new ArrayList<>();

    public Testservlet() {
        super();
    
    }
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		  //Threade t= new Threade(); 
		  //new Thread(t).start();
	
	
String nom=(String)request.getParameter("nom");
		if(nom!=null) {
		ConnectedUser c = new ConnectedUser(nom);
		c.deconnecter();}
		this.getServletContext().getRequestDispatcher("/Authentification.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/jsp");
		
		Inscriptionform inscription = new Inscriptionform();

		String userName= request.getParameter("UserN2");
	
		inscription.connexionC(request);
		int c=inscription.c;
		if(c==1) {
			
			Testservlet.clients.clear();
			Testservlet.comptes.clear();
			Consultation con = new Consultation();
			con.insertion();
		request.setAttribute("nom", userName);
		this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);}
		
		else {
		
		
		inscription.connexion(request);
		int cc= inscription.c;
		if(cc==1) {
		request.setAttribute("nom", userName);
			RequestDispatcher rd = request.getRequestDispatcher("Admin");		
			rd.forward(request, response);
		
		
			
		}
		else {
			request.setAttribute("conn", inscription.getResultat());
			this.getServletContext().getRequestDispatcher("/Authentification.jsp").forward(request, response);
		}
		
		}
		
}

}
