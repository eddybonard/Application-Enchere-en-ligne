package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fr.eni.enchere.bo.Utilisateur;




public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String INSERT_UTILISATEUR="INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur  ) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_UTILISATEUR = "delete from UTILISATEURS where no_utilisateur=?";
	private static final String UPDATE_UTILISATEUR = "update UTILISATEURS set pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? where no_utilisateur=?";
	private static final String SELECT_BYPSEUDO = "SELECT * FROM Utilisateurs WHERE pseudo=?";
	 private static final String CHECK_PSEUDO_AND_PWD = "select * from UTILISATEURS  where pseudo=? and mot_de_passe=?";
	
	@Override
	public void update(Utilisateur user) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
				pstmt.setString(1,(user.getPseudo()));
				pstmt.setString(2,(user.getNom()));
				pstmt.setString(3,(user.getPrenom()));
				pstmt.setString(4,(user.getEmail()));
				pstmt.setString(5,(user.getTelephone()));
				pstmt.setString(6,(user.getRue()));
				pstmt.setString(7,(user.getCodePostal()));
				pstmt.setString(8,(user.getVille()));
				pstmt.setString(9,(user.getMotDePasse()));
				pstmt.setInt(10,(user.getCredit()));
				pstmt.setByte(11,(user.isAdministrateur()));
				pstmt.setInt(12,(user.getNoUtilisateur()));
				
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
	
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void insert(Utilisateur user) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1,(user.getPseudo()));
				pstmt.setString(2,(user.getNom()));
				pstmt.setString(3,(user.getPrenom()));
				pstmt.setString(4,(user.getEmail()));
				pstmt.setString(5,(user.getTelephone()));
				pstmt.setString(6,(user.getRue()));
				pstmt.setString(7,(user.getCodePostal()));
				pstmt.setString(8,(user.getVille()));
				pstmt.setString(9,(user.getMotDePasse()));
				pstmt.setInt(10,(user.getCredit()));
				pstmt.setByte(11,(user.isAdministrateur()));
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next())
				{
					user.setNoUtilisateur(rs.getInt(1));
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
	public void delete(int  noUtilisateur) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(DELETE_UTILISATEUR);
				pstmt.setInt(1, noUtilisateur);
				pstmt.executeUpdate();
				System.out.println("Jdbc l'utilisateur suprrimé est "+noUtilisateur);
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

	@Override
	public void selectByPseudoPassword(Utilisateur user) {
		
		
	}

	 @Override
	    public Utilisateur selectByPseudo(String pseudo) {
	        
	        Utilisateur sessionUser = null;
	        
	        try (Connection cnx = ConnectionProvider.getConnection()) {
	            try {
	                cnx.setAutoCommit(false);
	                PreparedStatement pstmt = cnx.prepareStatement(SELECT_BYPSEUDO);
	                pstmt.setString(1, pseudo);
	                ResultSet rs = pstmt.executeQuery();
	                // pstmt.execute();
	                // ResultSet rs = pstmt.getResultSet();
	                
	                if (rs.next()) {
	                    sessionUser  = new Utilisateur(rs.getInt("no_utilisateur"),
	                            rs.getString("pseudo"),
	                            rs.getString("nom"),
	                            rs.getString("prenom"),
	                            rs.getString("email"),
	                            rs.getString("telephone"),
	                            rs.getString("rue"),
	                            rs.getString("code_postal"),
	                            rs.getString("ville"),
	                            rs.getString("mot_de_passe"),
	                            rs.getInt("credit"),
	                            rs.getByte("administrateur"));
	                }
	                pstmt.close();
	                cnx.commit();
	            } catch (Exception e) {
	                e.printStackTrace();    // exception à redéfinir ???
	            }
	            cnx.close();
	        } catch (Exception e) {
	            e.printStackTrace(); ;      // exception à redéfinir ???
	        }
	        return sessionUser;
	    }
	 
	 
	@Override
	    public boolean verifPseudoAndPassword(String pseudo, String passWord){
	        
	        boolean isPseudoAndMail = false;
	        
	        try (Connection cnx = ConnectionProvider.getConnection()) {
	            try {
	                cnx.setAutoCommit(false);
	                PreparedStatement pstmt = cnx.prepareStatement(CHECK_PSEUDO_AND_PWD);
	                pstmt.setString(1, pseudo);
	                pstmt.setString(2, passWord);
	                ResultSet rs = pstmt.executeQuery();
	                
	                if (rs.next()) {
	                    isPseudoAndMail = true;
	                }
	                pstmt.close();
	                rs.close();
	                cnx.commit();
	            } catch (Exception e) {
	                e.printStackTrace();    // exception à redéfinir ???
	            }
	            cnx.close();
	        } catch (Exception e) {
	            e.printStackTrace(); ;      // exception à redéfinir ???
	        }
	        System.out.println("isPseudoandMail ? : " + isPseudoAndMail);
	        return isPseudoAndMail;
	    }

}
