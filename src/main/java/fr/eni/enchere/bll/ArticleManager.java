package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.Date;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {
	
	private ArticleDAO articleDAO;

	/**
	 * 
	 */
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	
	public ArticleVendu ajouterArticle( String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, int noUtilisateur, int noCategorie)  
	{
		
		
		ArticleVendu article = null;
		
		try {
			article = new ArticleVendu();
			article.setNomArticle(nomArticle);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebutEncheres);
			article.setDateFinEncheres(dateFinEncheres);
			article.setMiseAPrix(miseAPrix);
			article.setPrixVente(prixVente);
			article.setNoUtilisateur(noUtilisateur);
			article.setNoCategorie(noCategorie);
			
			
			
			this.articleDAO.insert(article);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return article;
	}
	
	public void supprimerArticle(int noArticle) {
		
		System.out.println("manager");
		this.articleDAO.delete(noArticle);
		
	
	}
	public ArticleVendu modifierArticle( String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix,int noArticle )  
	{
		
		
		ArticleVendu article = null;

		
		
		try {
			article = new ArticleVendu();
			article.setNomArticle(nomArticle);
			article.setDescription(description);
			article.setDateDebutEncheres(dateDebutEncheres);
			article.setDateFinEncheres(dateFinEncheres);
			article.setMiseAPrix(miseAPrix);
			article.setNoArticle(noArticle);
			
		
			
			
			
			this.articleDAO.update(article );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return article;
	}
	
	

}
