package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	public ArticleVendu selectById(Integer idArticle);

	public List<ArticleVendu> selectAll();

	public ArticleVendu insert(ArticleVendu a1);

	public void update(ArticleVendu a);

	public void delete(int a);
}
