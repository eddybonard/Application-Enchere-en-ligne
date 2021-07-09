package fr.eni.enchere.bll;

import java.util.Date;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.RetraitDAO;

public class RetraitManager {
	
	private RetraitDAO retraitDAO;

	/**
	 * @param retraitDAO
	 */
	public RetraitManager() {
		super();
		this.retraitDAO = DAOFactory.getRetraitDAO();
	}
	
	public Retrait ajouterRetrait(int noCategorie, String rue, String code_postal, String ville)  
	{
		
		
		Retrait retrait = null;
		
		try {
			retrait = new Retrait();
			retrait.setNoArticle(noCategorie);
			retrait.setRue(rue);
			retrait.setCode_postal(code_postal);
			retrait.setVille(ville);
			
			
			
			this.retraitDAO.insert(retrait);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retrait;
	}
	
	public Retrait modifierRetrait(int noArticle, String rue, String code_postal, String ville)  
	{
		
		
		Retrait retrait = null;
		
		try {
			retrait = new Retrait();
			retrait.setNoArticle(noArticle);
			retrait.setRue(rue);
			retrait.setCode_postal(code_postal);
			retrait.setVille(ville);
			
			
			
			this.retraitDAO.update(retrait);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retrait;
	}
	
	

}
