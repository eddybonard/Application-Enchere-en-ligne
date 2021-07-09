package fr.eni.enchere.dal;

import fr.eni.enchere.bo.ArticleVendu;



public interface ArticleDAO {
	
	public void update(ArticleVendu articleVendu) ;
	
	public void insert(ArticleVendu articleVendu) ;
	
	public void delete(int noArticle) ;

}
