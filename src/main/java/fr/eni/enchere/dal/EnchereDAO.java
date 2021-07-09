package fr.eni.enchere.dal;


import fr.eni.enchere.bo.Enchere;

public interface EnchereDAO {
	
	public void update(Enchere enchere) ;
	
	public void insert(Enchere enchere) ;
	
	public void delete(String enchere) ;

}
