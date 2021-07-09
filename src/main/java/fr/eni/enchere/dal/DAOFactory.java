package fr.eni.enchere.dal;



public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO()
	{
		return new ArticleDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO()
	{
		return new RetraitDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOJdbcImpl();
	}



}
