package fr.eni.enchere.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bo.Enchere;

/**
 * Servlet implementation class ServletAfficherDetailEnchereDeconnecte
 */
@WebServlet("/jsp/ServletAfficherDetailEnchereDeconnecte")
public class ServletAfficherDetailEnchereDeconnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/encherir.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		
		int proposition = Integer.parseInt(request.getParameter("proposition"));
		LocalDate dateEnchere = LocalDate.now();
		int prix = (int) session.getAttribute("prix");
		int noArticle = (int) session.getAttribute("noArticle");
		int idUser = (int) session.getAttribute("id");
		int newPrix = proposition + prix;
		session.setAttribute("newPrix", newPrix);
		session.setAttribute("prix", newPrix);
		
		System.out.println(proposition);
		System.out.println(dateEnchere);
		System.out.println(prix);
		System.out.println(noArticle);
		System.out.println(idUser);
		System.out.println(newPrix);
		
		EnchereManager em = new EnchereManager();
		Enchere enchere = em.ajouterEnchere(dateEnchere, proposition, noArticle, idUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/encherir.jsp");
		rd.forward(request, response);
	}

}
