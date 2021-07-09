package fr.eni.enchere.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;



/**
 * Servlet implementation class ServletFormulaireInscription
 */
@WebServlet("/jsp/ServletFormulaireModification")
public class ServletFormulaireModification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int id = (int) session.getAttribute("id");
		System.out.println(session);
		System.out.println(id);
		
		UtilisateurManager um = new UtilisateurManager();
		um.supprimerUtilisateur(id);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/accueilCompteSuprimer.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String pseudo = request.getParameter("pseudo");
		session.getAttribute("pseudo");
		int id = (int) session.getAttribute("id");
		String nom = request.getParameter("nom");
		String prenom =	request.getParameter("prenom");	
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue =request.getParameter("rue");	
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasseActuel =	request.getParameter("motDePasseActuel");
		String newMotDePasse =	request.getParameter("newMotDePasse");	
		String confmotDePasse = request.getParameter("confmotDePasse");
		String motDePasseSession = (String) session.getAttribute("password");
		int credit = Integer.parseInt(request.getParameter("credit"));
		int oldCredit = (int) session.getAttribute("credit");
		int newCredit = credit + oldCredit;
		
		
		
		
		//check parameters
		System.out.println(pseudo);
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(email);
		System.out.println(telephone);
		System.out.println(rue);
		System.out.println(codePostal);
		System.out.println(ville);
		System.out.println(motDePasseActuel);
		System.out.println(newMotDePasse);
		System.out.println(confmotDePasse);
		System.out.println(motDePasseSession);
		System.out.println(credit);
		
	
			
			
			if(newMotDePasse!= null && newMotDePasse.equals(confmotDePasse)   && newMotDePasse.length() >= 5 && newMotDePasse.length() <= 20) {
				
				UtilisateurManager um = new UtilisateurManager();
				Utilisateur user = um.modifierUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, newMotDePasse, newCredit,null, id);
				session.setAttribute("pseudo", pseudo);
				session.setAttribute("nom", nom);
				session.setAttribute("prenom", prenom);
				session.setAttribute("email", email);
				session.setAttribute("telephone", telephone);
				session.setAttribute("rue", rue);
				session.setAttribute("codePostal", codePostal);
				session.setAttribute("ville", ville);
				session.setAttribute("password", newMotDePasse);
				session.setAttribute("credit", newCredit);
				
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/afficherProfilModification.jsp");
				rd.forward(request, response);
			}else {
				UtilisateurManager um = new UtilisateurManager();
				Utilisateur user = um.modifierUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasseSession, newCredit,null,id);
				session.setAttribute("pseudo", pseudo);
				session.setAttribute("nom", nom);
				session.setAttribute("prenom", prenom);
				session.setAttribute("email", email);
				session.setAttribute("telephone", telephone);
				session.setAttribute("rue", rue);
				session.setAttribute("codePostal", codePostal);
				session.setAttribute("ville", ville);
				session.setAttribute("credit", newCredit);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/afficherProfilModification.jsp");
				rd.forward(request, response);
				
			}
		
		
	}
	

}
