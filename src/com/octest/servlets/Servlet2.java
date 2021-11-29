package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.forms.ConnectedUser;
import com.octest.forms.Consultation;
import com.octest.forms.Inscriptionform;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		String name=(String) request.getAttribute("nom");
		Inscriptionform inscription = new Inscriptionform();
		inscription.inscrire(request);
		inscription.creationCompte(request);
		
		Testservlet.clients.clear();
		Testservlet.comptes.clear();
		Consultation con = new Consultation();
		con.insertion();
		if(inscription.c==1 ) {
			request.setAttribute("conn", inscription.getResultat());
		this.getServletContext().getRequestDispatcher("/carousel.jsp").forward(request, response);

		}
		else if(inscription.c==3) {
			request.setAttribute("conn", inscription.getResultat());
			this.getServletContext().getRequestDispatcher("/consultation.jsp").forward(request, response);
		}
	
	else {
		ConnectedUser c = new ConnectedUser(name);
		c.connecter();
		
		request.setAttribute("nom", name);
		this.getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
	}
		
	}
}
