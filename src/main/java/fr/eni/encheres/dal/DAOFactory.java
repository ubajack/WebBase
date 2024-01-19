package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.*;

public class DAOFactory {
	public static CategorieDAO getCategorieDAO() {return new CategorieDAOJdbcImpl();}

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}

	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}
	
}
