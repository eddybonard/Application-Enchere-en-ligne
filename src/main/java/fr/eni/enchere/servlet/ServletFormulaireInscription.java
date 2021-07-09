package fr.eni.enchere.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletFormulaireInscription
 */
@WebServlet("/jsp/ServletFormulaireInscription")
public class ServletFormulaireInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/formulaireInscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom =	request.getParameter("prenom");	
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue =request.getParameter("rue");	
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse =	request.getParameter("motDePasse");	
		String confmotDePasse = request.getParameter("confmotDePasse"); 
		int credit = Integer.parseInt(request.getParameter("credit"));
		
		
		
		//check parameters
		System.out.println(pseudo);
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(email);
		System.out.println(telephone);
		System.out.println(rue);
		System.out.println(codePostal);
		System.out.println(ville);
		System.out.println(motDePasse);
		System.out.println(confmotDePasse);
		System.out.println(credit);
		
		if(motDePasse.equals(confmotDePasse) && motDePasse.length() >= 5 && motDePasse.length() <= 20 && credit == 500) {
			
		UtilisateurManager um = new UtilisateurManager();
		Utilisateur user = um.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, null); 
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/connexion.jsp");
		rd.forward(request, response);
		}else {
			 String erreur = "les mots de passe ne sont pas identique";
			request.setAttribute("erreur", erreur);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/formulaireInscription.jsp");
			rd.forward(request, response);
		}
	
	}

}
