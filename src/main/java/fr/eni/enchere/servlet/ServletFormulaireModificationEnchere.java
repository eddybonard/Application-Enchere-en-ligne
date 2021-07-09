package fr.eni.enchere.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.RetraitManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;

/**
 * Servlet implementation class ServletFormulaireModificationEnchere
 */
@WebServlet("/jsp/ServletFormulaireModificationEnchere")
public class ServletFormulaireModificationEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int noArticle = 12 /*(int) session.getAttribute("noArticle");*/;
		String article = (String) session.getAttribute("article");
		String description = (String) session.getAttribute("description");
		int prix = (int) session.getAttribute("prix");
		LocalDate dateDebut = (LocalDate) session.getAttribute("dateDebut");
		LocalDate dateFin = (LocalDate) session.getAttribute("dateFin");
		String rue = (String) session.getAttribute("rue");
		String ville = (String) session.getAttribute("ville");
		String codePostal = (String) session.getAttribute("codePostal");
		System.out.println(session);
		System.out.println(noArticle);
		
		ArticleManager um = new ArticleManager();
		um.supprimerArticle(noArticle);
		
		session.setAttribute("noArticle",noArticle );
		session.setAttribute("article", article);
		session.setAttribute("description", description);
		session.setAttribute("prix", prix);
		session.setAttribute("dateDebut", dateDebut);
		session.setAttribute("dateFin", dateFin);
		session.setAttribute("rue", rue);
		session.setAttribute("ville", ville);
		session.setAttribute("codePostal", codePostal);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/enchereSuprimee.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int noArticle = (int) session.getAttribute("noArticle");
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		int prix = Integer.parseInt(request.getParameter("prix"));
		LocalDate dateDebut = LocalDate.parse(request.getParameter("debutEnchere"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("finEnchere"));
		String rue =  request.getParameter("rue");
		String ville =  request.getParameter("ville");
		String codePostal =  request.getParameter("codePostal");
		System.out.println(noArticle);
		System.out.println(article);
		System.out.println(description);
		System.out.println(prix);
		System.out.println(dateDebut);
		System.out.println(dateFin);
		System.out.println(rue);
		System.out.println(ville);
		System.out.println(codePostal);
		
		ArticleManager um = new ArticleManager();
		ArticleVendu av =  um.modifierArticle(article, description, dateDebut, dateFin, prix, noArticle);
		
		RetraitManager rm = new RetraitManager();
		Retrait retrait =  rm.modifierRetrait(noArticle, rue, codePostal, ville);
		
		
		
		session.setAttribute("article", article);
		session.setAttribute("description", description);
		session.setAttribute("prix", prix);
		session.setAttribute("dateDebut", dateDebut);
		session.setAttribute("dateFin", dateFin);
		session.setAttribute("rue", rue);
		session.setAttribute("ville", ville);
		session.setAttribute("codePostal", codePostal);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/afficherDetailEnchere.jsp");
		rd.forward(request, response);
	}

}
