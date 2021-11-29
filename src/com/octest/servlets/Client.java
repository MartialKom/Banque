package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.forms.Calculer;
import com.octest.forms.Consultation;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Client")
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Client() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String compteD = request.getParameter("numcompteD");
		String compteR = request.getParameter("numcompteR");
		String montant = request.getParameter("montant");
		String numero= request.getParameter("numeroCompte");
		String montantC=request.getParameter("montantCredit");
		String montantD=request.getParameter("montantDebit");
		String numeroD=request.getParameter("numeroCompteD");
		
		String numeroE = request.getParameter("numeroCompteE");
		String montantE =  request.getParameter("montantE");
		
		Calculer calcul =new Calculer();
		
		if(compteD!=null) {
		calcul.virement(compteD, compteR, montant);}
		
		if(montantC!=null) {
			calcul.crediter(numero, montantC);
		}
		
		if(montantD!=null) {
			calcul.debiter(numeroD, montantD);
		}
		
		if(montantE!= null) {
			calcul.emprunter(numeroE, montantE);
		}
		Testservlet.clients.clear();
		Testservlet.comptes.clear();
		Consultation con = new Consultation();
		con.insertion();
		if(calcul.c==1) {
			request.setAttribute("conn", calcul.resultat);
			this.getServletContext().getRequestDispatcher("/carousel.jsp").forward(request, response);
		}
		if(calcul.c==3) {
			request.setAttribute("conn", calcul.resultat);
			this.getServletContext().getRequestDispatcher("/carousel.jsp").forward(request, response);
		}
	}

	}


