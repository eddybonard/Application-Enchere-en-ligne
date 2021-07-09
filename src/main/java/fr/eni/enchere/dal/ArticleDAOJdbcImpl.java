package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Retrait;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private static final String INSERT_ARTICLE="INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente,no_utilisateur,no_categorie ) values(?,?,?,?,?,?,?,?)";
	private static final String DELETE_ARTICLE = "delete from ARTICLES_VENDUS where no_article=?";
	private static final String UPDATE_ARTICLE = "update ARTICLES_VENDUS set nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=? where no_article=? ";

	
	@Override
	public void update(ArticleVendu articleVendu) {
		
	
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ARTICLE);
				pstmt.setString(1,(articleVendu.getNomArticle()));
				pstmt.setString(2,(articleVendu.getDescription()));
				pstmt.setDate(3,Date.valueOf(articleVendu.getDateDebutEncheres()));
				pstmt.setDate(4,Date.valueOf(articleVendu.getDateFinEncheres()));
				pstmt.setInt(5,articleVendu.getMiseAPrix());
				pstmt.setInt(6,articleVendu.getNoArticle());
				
			
				
	
				
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void insert(ArticleVendu articleVendu) {
		
		Categorie categorie = new Categorie();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1,(articleVendu.getNomArticle()));
				pstmt.setString(2,(articleVendu.getDescription()));
				pstmt.setDate(3,Date.valueOf(articleVendu.getDateDebutEncheres()));
				pstmt.setDate(4,Date.valueOf(articleVendu.getDateFinEncheres()));
				pstmt.setInt(5,articleVendu.getMiseAPrix());
				pstmt.setInt(6,articleVendu.getPrixVente());
				pstmt.setInt(7,articleVendu.getNoUtilisateur());
				pstmt.setInt(8,articleVendu.getNoCategorie());
				
	
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					articleVendu.setNoArticle(rs.getInt(1));
					
				}
				rs.close();
				pstmt.close();
				cnx.commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}

	@Override
	public void delete(int noArticle) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(DELETE_ARTICLE);
				pstmt.setInt(1, noArticle);
				pstmt.executeUpdate();
				System.out.println("Jdbc l'utilisateur suprrimé est "+noArticle);
				pstmt.close();
				cnx.commit();
				cnx.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
