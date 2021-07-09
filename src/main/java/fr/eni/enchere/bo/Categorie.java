package fr.eni.enchere.bo;

import java.io.Serializable;
import java.util.List;

public class Categorie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noCategorie;
	private String libelle;
	private List<ArticleVendu> categorieArticle;
	/**
	 * 
	 */
	public Categorie() {
		super();
	}
	/**
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle,  List<ArticleVendu> categorieArticle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.categorieArticle = categorieArticle;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<ArticleVendu> getCategorieArticle() {
		return categorieArticle;
	}
	public void setCategorieArticle(List<ArticleVendu> categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", categorieArticle=");
		builder.append(categorieArticle);
		builder.append("]");
		return builder.toString();
	}
	
	

}
