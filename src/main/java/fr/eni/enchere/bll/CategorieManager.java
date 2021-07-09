package fr.eni.enchere.bll;

import java.util.Date;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DAOFactory;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;

	/**
	 * 
	 */
	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	public Categorie ajouterCategorie( String libelle)  
	{
		
		
		Categorie categorie = null;
		
		try {
			categorie = new Categorie();
			categorie.setLibelle(libelle);
			
			
			
			this.categorieDAO.insert(categorie);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return categorie;
	}
	
	
	

}
