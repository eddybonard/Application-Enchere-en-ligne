package fr.eni.enchere.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class ArticleVendu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  int noArticle;
	private String  nomArticle;
	private String description; 
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int  prixVente;
	private String etatVente;
	private int  noUtilisateur;
	private int  noCategorie;
	private Utilisateur utilisateurVendeur;
	private Utilisateur utilisateurAcheteur;
	private Retrait lieuRetrait;
	private Categorie categorie;
	private List<Enchere> encheres;
	
	/**
	 * 
	 */
	public ArticleVendu() {
		super();
	}
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 * @param noUtilisateur
	 * @param noCategorie
	 * @param utilisateurVendeur
	 * @param utilisateurAcheteur
	 * @param lieuRetrait
	 * @param categorie
	 * @param encheres
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente, int noUtilisateur,
			int noCategorie, Utilisateur utilisateurVendeur, Utilisateur utilisateurAcheteur, Retrait lieuRetrait,
			Categorie categorie, List<Enchere> encheres) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.utilisateurVendeur = utilisateurVendeur;
		this.utilisateurAcheteur = utilisateurAcheteur;
		this.lieuRetrait = lieuRetrait;
		this.categorie = categorie;
		this.encheres = encheres;
	}
	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param miseAPrix
	 * @param prixVente
	 * @param etatVente
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente, Utilisateur utilisateurVendeur,Utilisateur utilisateurAcheteur,Retrait lieuRetrait, Categorie categorie, List<Enchere> encheres ) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.utilisateurVendeur = utilisateurVendeur;
		this.utilisateurAcheteur = utilisateurAcheteur;
		this.lieuRetrait = lieuRetrait;
		this.categorie = categorie;
		this.encheres = encheres;
	}
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	
	public Utilisateur getUtilisateurVendeur() {
		return utilisateurVendeur;
	}
	public void setUtilisateurVendeur(Utilisateur utilisateurVendeur) {
		this.utilisateurVendeur = utilisateurVendeur;
	}
	public Utilisateur getUtilisateurAcheteur() {
		return utilisateurAcheteur;
	}
	public void setUtilisateurAcheteur(Utilisateur utilisateurAcheteur) {
		this.utilisateurAcheteur = utilisateurAcheteur;
	}
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Enchere> getEncheres() {
		return encheres;
	}
	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [noArticle=");
		builder.append(noArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEncheres=");
		builder.append(dateDebutEncheres);
		builder.append(", dateFinEncheres=");
		builder.append(dateFinEncheres);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append(", utilisateurVendeur=");
		builder.append(utilisateurVendeur);
		builder.append(", utilisateurAcheteur=");
		builder.append(utilisateurAcheteur);
		builder.append(", lieuRetrait=");
		builder.append(lieuRetrait);
		builder.append(", categorie=");
		builder.append(categorie);
		builder.append(", encheres=");
		builder.append(encheres);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
