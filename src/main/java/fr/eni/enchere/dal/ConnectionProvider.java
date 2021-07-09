/*
 * 
 */
package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author ebonard2021
 *
 */
public abstract class ConnectionProvider {
	
	private static DataSource data;
	
	static {
		try {
			Context context = new InitialContext();
			ConnectionProvider.data = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible de ce connecter à la base de donnée");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.data.getConnection();
		
	}

}
