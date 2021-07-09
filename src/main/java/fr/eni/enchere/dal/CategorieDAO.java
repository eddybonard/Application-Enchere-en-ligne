package fr.eni.enchere.dal;


import fr.eni.enchere.bo.Categorie;

public interface  CategorieDAO {
	
	public void update(Categorie articleVendu) ;
	
	public void insert(Categorie articleVendu) ;
	
	public void delete(String nomArticle) ;

}
