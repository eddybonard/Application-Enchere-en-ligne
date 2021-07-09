package fr.eni.enchere.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.RetraitManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Retrait;

/**
 * Servlet implementation class ServletNouvelleEnchere
 */
@WebServlet("/jsp/ServletNouvelleEnchere")
public class ServletNouvelleEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
        HttpSession session = request.getSession();
        String rue = (String) session.getAttribute("rue");
        String ville = (String) session.getAttribute("ville");
        String codePostal = (String) session.getAttribute("codePostal");

		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/nouvelleEnchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int id = (int) session.getAttribute("id");
		
		
		
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		Boolean photo =	Boolean.valueOf(request.getParameter("photo"));	
		int prix = Integer.parseInt(request.getParameter("prix"));
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateDebut = LocalDate.parse(request.getParameter("debutEnchere"),dtf1);
		LocalDate dateFin = LocalDate.parse(request.getParameter("finEnchere"),dtf1);
		
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String codePostal =	request.getParameter("codePostal");	
		
		
		
		
		
		//check parameters
		System.out.println(article);
		System.out.println(description);
		System.out.println(categorie);
		System.out.println(photo);
		System.out.println(prix);
		System.out.println(dateDebut);
		System.out.println(dateFin);

		System.out.println(rue);
		System.out.println(ville);
		System.out.println(codePostal);
		System.out.println(id);
		
	
		
		//CategorieManager cm = new CategorieManager();
		//Categorie categorieArticle = cm.ajouterCategorie(categorie);
		
		ArticleManager am = new ArticleManager();
		ArticleVendu articleVendu = am.ajouterArticle(article, description, dateDebut, dateFin, prix, 0, id,categorie);
		
		session.setAttribute("noArticle", articleVendu.getNoArticle());
		session.setAttribute("article", article);
		session.setAttribute("description", description);
		session.setAttribute("prix", prix);
		session.setAttribute("dateDebut", dateDebut);
		session.setAttribute("dateFin", dateFin);
		session.setAttribute("rue", rue);
		session.setAttribute("ville", ville);
		session.setAttribute("codePostal", codePostal);
		int noArticle = (int) session.getAttribute("noArticle");
		
	
	
		RetraitManager rm = new RetraitManager();
		Retrait retrait = rm.ajouterRetrait(noArticle,rue, codePostal, ville);
		
		session.setAttribute("listArticle", articleVendu);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/enchereAjoutee.jsp");
		rd.forward(request, response);
		
	}

}
