package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Categorie;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String INSERT_CATEGORIE="INSERT INTO CATEGORIES(libelle) values(?)";
	private static final String DELETE_ARTICLE = "delete from CATEGORIES where nom_article=?";
	private static final String UPDATE_ARTICLE = "update CATEGORIES set nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, rue=?, prix_vente=?, ville=?, mot_de_passe=?, credit=?, administrateur=? where pseudo=?";
	@Override
	public void update(Categorie articleVendu) {
		
	}
	@Override
	public void insert(Categorie categorie) {
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1,(categorie.getLibelle()));
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					categorie.setNoCategorie(rs.getInt(1));
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
	public void delete(String nomArticle) {
		
	}

}
