package fr.eni.enchere.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ServletAfficherProfilModification
 */
@WebServlet("/jsp/ServletAfficherProfil")
public class ServletAfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String pseudo = (String) session.getAttribute("pseudo");
		String password = (String) session.getAttribute("password");
		
		String prenom = (String) session.getAttribute("prenom");
		String nom = (String) session.getAttribute("nom");
		String email = (String) session.getAttribute("email");
		String telephone = (String) session.getAttribute("telephone");
		String rue = (String) session.getAttribute("rue");
		String ville = (String) session.getAttribute("ville");
		String codePostal = (String) session.getAttribute("codePostal");
		
		
		
		
		
		UtilisateurManager um = new UtilisateurManager();
		Utilisateur user = um.identifierUtilisateur(pseudo, password);
		
		
		
		
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/afficherProfilModification.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/formulaireModificationProfil.jsp");
		rd.forward(request, response);
	}

}
