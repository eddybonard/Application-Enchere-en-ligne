/**
 * 
 */
package fr.eni.enchere.bo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author ebonard2021
 *
 */
public class Retrait implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noArticle;
	private String rue;
	private String code_postal;
	private String ville;
	private ArticleVendu[] article = new ArticleVendu[2];
	/**
	 * 
	 */
	public Retrait() {
		super();
	}
	/**
	 * @param noArticle
	 * @param rue
	 * @param code_postal
	 * @param ville
	 * @param article
	 */
	public Retrait(int noArticle, String rue, String code_postal, String ville, ArticleVendu[] article) {
		super();
		this.noArticle = noArticle;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.article = article;
	}
	/**
	 * @param rue
	 * @param code_postal
	 * @param ville
	 */
	public Retrait(String rue, String code_postal, String ville, ArticleVendu[] article) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.article = article;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public ArticleVendu[] getArticle() {
		return article;
	}
	public void setArticle(ArticleVendu[] article) {
		this.article = article;
	}
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [rue=");
		builder.append(rue);
		builder.append(", code_postal=");
		builder.append(code_postal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", article=");
		builder.append(Arrays.toString(article));
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
