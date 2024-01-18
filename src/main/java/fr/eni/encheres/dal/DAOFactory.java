package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleVenduDAOJdbcImpl;

public class DAOFactory {
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOJdbcImpl();
	}
	
}
