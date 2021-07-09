package fr.eni.enchere.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class Enchere implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noEnchere;
	private LocalDate dateEnchere;
	private int montant_enchere;
	private int noArticle;
	private int noUtilisateur;
	/**
	 * 
	 */
	public Enchere() {
		super();
	}
	/**
	 * @param noEnchere
	 * @param dateEnchere
	 * @param montant_enchere
	 * @param article
	 * @param utilisateur
	 */
	public Enchere(int noEnchere, LocalDate dateEnchere, int montant_enchere, int article,
			int utilisateur) {
		super();
		this.setNoEnchere(noEnchere);
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.noArticle = article;
		this.noUtilisateur = utilisateur;
	}
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 */
	public Enchere(LocalDate dateEnchere, int montant_enchere, int article, int utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.noArticle = article;
		this.noUtilisateur = utilisateur;
	}
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	public int getArticle() {
		return noArticle;
	}
	public void setArticle(int article) {
		this.noArticle = article;
	}
	public int getUtilisateur() {
		return noUtilisateur;
	}
	public void setUtilisateur(int utilisateur) {
		this.noUtilisateur = utilisateur;
	}
	public int getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montant_enchere=");
		builder.append(montant_enchere);
		builder.append(", article=");
		builder.append(noArticle);
		builder.append(", utilisateur=");
		builder.append(noUtilisateur);
		builder.append("]");
		return builder.toString();
	}
	

	
}
