/**
 * 
 */
package fr.eni.enchere.bll;



import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;


/**
 * @author ebonard2021
 *
 */
public class UtilisateurManager {
private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, Byte administrateur)  
	{
		
		
		Utilisateur utilisateur = null;
		
		try {
			utilisateur = new Utilisateur();
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(motDePasse);
			utilisateur.setCredit(credit);
			utilisateur.setAdministrateur(administrateur);
			
			this.utilisateurDAO.insert(utilisateur);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return utilisateur;
	}
	
	/*
	private void validerDateHeure(LocalDate date, LocalTime heure, BusinessException businessException) {
		if(date==null || 
			date.isAfter(LocalDate.now()) ||
			(date.isEqual(LocalDate.now()) && heure.isAfter(LocalTime.now())))
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_DATE_ERREUR);
		}
		
	}
*/
	public Utilisateur modifierUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, Byte administrateur,int id  ) {
			Utilisateur utilisateur = new Utilisateur();
		
			try {
				
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setEmail(email);
				utilisateur.setTelephone(telephone);
				utilisateur.setRue(rue);
				utilisateur.setCodePostal(codePostal);
				utilisateur.setVille(ville);
				utilisateur.setMotDePasse(motDePasse);
				utilisateur.setCredit(credit);
				utilisateur.setAdministrateur(administrateur);
				utilisateur.setNoUtilisateur(id);
				
				this.utilisateurDAO.update(utilisateur);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return utilisateur;
			
		
			
		}
	
	public void supprimerUtilisateur(int noUtilisateur) {
		
			System.out.println("manager");
			this.utilisateurDAO.delete(noUtilisateur);
			
		
	}
	
	public Utilisateur afficherUtilisateur(String pseudo) {
		return this.utilisateurDAO.selectByPseudo(pseudo)   ;
		
	}
	
	public Utilisateur identifierUtilisateur(String pseudo, String passWord) {
        
        Utilisateur user = new Utilisateur();
        user.setPseudo(pseudo);
        user.setMotDePasse(passWord);
                    
        if (this.utilisateurDAO.verifPseudoAndPassword(pseudo, passWord)){
            user = this.utilisateurDAO.selectByPseudo(pseudo);
        }else {
            user = null;
    }
        System.out.println("identification user : " + user);
        return user;
    }
}
