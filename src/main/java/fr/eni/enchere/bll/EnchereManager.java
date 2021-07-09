package fr.eni.enchere.bll;

import java.time.LocalDate;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereManager {
	
	private EnchereDAO enchereDAO;
	
	
	
	
	
	
	
	/**
	 * @param enchereDAO
	 */
	public EnchereManager()  {
		super();
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}



	


	public Enchere ajouterEnchere( LocalDate dateEnchere, int montant, int noArticle,
			int noUtilisateur)  
	{
		
		
		Enchere enchere = null;
		
		try {
			enchere = new Enchere();
			enchere.setDateEnchere(dateEnchere);;
			enchere.setMontant_enchere(montant);
			enchere.setArticle(noArticle);;
			enchere.setUtilisateur(noUtilisateur);
			
			
			
			
			this.enchereDAO.insert(enchere);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return enchere;
	}

}
