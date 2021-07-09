package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Enchere;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String INSERT_ENCHERE="INSERT INTO ENCHERES ( date_enchere, montant_enchere,no_article,no_utilisateur ) values(?,?,?,?)";
	private static final String DELETE_ENCHERE = "delete from ARTICLES_VENDU where nom_article=?";
	private static final String UPDATE_ENCHERE = "update ARTICLES_VENDU set nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, rue=?, prix_vente=?, ville=?, mot_de_passe=?, credit=?, administrateur=? where pseudo=?";

	@Override
	public void update(Enchere enchere) {
		
	}

	@Override
	public void insert(Enchere enchere) {
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setDate(1,Date.valueOf(enchere.getDateEnchere()));
				pstmt.setInt(2, enchere.getMontant_enchere());
				pstmt.setInt(3, enchere.getArticle());
				pstmt.setInt(4, enchere.getUtilisateur());
				
				
				
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					enchere.setNoEnchere(rs.getInt(1));
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
	public void delete(String enchere) {
		
	}

}
