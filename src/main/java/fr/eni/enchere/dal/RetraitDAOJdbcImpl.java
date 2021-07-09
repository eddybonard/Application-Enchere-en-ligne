package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Retrait;

public class RetraitDAOJdbcImpl implements RetraitDAO {
	
	private static final String INSERT_RETRAIT="INSERT INTO RETRAITS ( no_article, rue,code_postal,ville ) values(?,?,?,?)";
	private static final String UPDATE_ENCHERE = "update RETRAITS set rue=?, code_postal=?, ville=?   where no_article=?";
	
	
	@Override
	public void update(Retrait retrait) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ENCHERE);
				pstmt.setString(1, retrait.getRue());
				pstmt.setString(2, retrait.getCode_postal());
				pstmt.setString(3, retrait.getVille());
				pstmt.setInt(4, retrait.getNoArticle());
				
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
	public void insert(Retrait retrait) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, retrait.getNoArticle());
				pstmt.setString(2, retrait.getRue());
				pstmt.setString(3, retrait.getCode_postal());
				pstmt.setString(4, retrait.getVille());
				
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
	

	
	
}
