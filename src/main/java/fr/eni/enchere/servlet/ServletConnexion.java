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
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/jsp/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/connexion.jsp");
		rd.forward(request, response);
		
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		String pseudo = request.getParameter("identifiant");
		String password = request.getParameter("password");
		
		UtilisateurManager um = new UtilisateurManager();
        Utilisateur userConnected = um.identifierUtilisateur(pseudo, password);
        if (userConnected != null) {
            // ??? On integre l'idUser ou l'Utilisateur complet dans le contexte de session ???
            HttpSession session = request.getSession();
            session.setAttribute("pseudo", pseudo);
            session.setAttribute("password", password);
            
            session.setAttribute("id", userConnected.getNoUtilisateur());
            session.setAttribute("prenom", userConnected.getPrenom());
            session.setAttribute("nom", userConnected.getNom());
            session.setAttribute("email", userConnected.getEmail());
            session.setAttribute("telephone", userConnected.getTelephone());
            session.setAttribute("rue", userConnected.getRue());
            session.setAttribute("ville", userConnected.getVille());
            session.setAttribute("codePostal", userConnected.getCodePostal());
            session.setAttribute("credit", userConnected.getCredit());
            session.setAttribute("listArticle", userConnected.getVente());
            
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/accueilConnecte.jsp");
            rd.forward(request, response);
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/connexion.jsp");
            rd.forward(request, response);
        }
	}

}
