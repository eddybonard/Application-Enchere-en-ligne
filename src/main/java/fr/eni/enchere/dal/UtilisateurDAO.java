package fr.eni.enchere.dal;



import fr.eni.enchere.bo.Utilisateur;



public interface UtilisateurDAO {
	
			public void update(Utilisateur user) ;
			
			public void insert(Utilisateur user) ;
			
			public void delete(int utilisateur) ;
			
			public void selectByPseudoPassword(Utilisateur user);
			
			public Utilisateur selectByPseudo(String  pseudo);

			boolean verifPseudoAndPassword(String pseudo, String passWord);

}
