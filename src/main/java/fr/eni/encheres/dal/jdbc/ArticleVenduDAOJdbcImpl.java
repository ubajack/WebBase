package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.*;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values (?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_ID = "select * from ARTICLES_VENDUS where no_article= ?";
	private static final String SELECT_ALL = "select * from ARTICLES_VENDUS";
	private static final String UPDATE = "update ARTICLES_VENDUS set nom_article = ?, description = ?, date_debut_encheres=?, date_fin_encheres= ?, prix_initial= ?, prix_vente= ?,  no_utilisateur= ?, no_categorie=? where no_article= ? ";

	private static final String DELETE = "DELETE ARTICLES_VENDUS where no_categorie=?";


	@Override
	public ArticleVendu selectById(Integer noArticle) {
		ArticleVendu articleVendu = null;
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID))

		{
			pstmt.setInt(1, noArticle);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				articleVendu = articleBuilder(rs);

			}

		} catch(
				SQLException e)

		{
			throw new RuntimeException(e);
		}
		return articleVendu;
	}

	@Override
	public List<ArticleVendu> selectAll() {

		return null;
	}

	@Override
	public ArticleVendu insert(ArticleVendu articleVendu) {
		try (Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_ARTICLE,
						Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, articleVendu.getNom());
			pstmt.setString(2, articleVendu.getDescription());
			pstmt.setDate(3, Date.valueOf(articleVendu.getDateDebutEncheres()));
 			pstmt.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()));
			pstmt.setInt(5, articleVendu.getMiseAPrix());
			pstmt.setInt(6, articleVendu.getPrixVente());
			pstmt.setInt(7, articleVendu.getVente().getNoUtilisateur());
			pstmt.setInt(8, articleVendu.getCategorieArticle().getNoCategorie());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				articleVendu.setnoArticle(rs.getInt(1));
			}
			} catch (SQLException e) {
            throw new RuntimeException(e);
        }
		return articleVendu;
	}

	@Override
	public void update(ArticleVendu articleVendu) {
		try (Connection cnx = ConnectionProvider.getConnection(); PreparedStatement pstmt = cnx.prepareStatement(UPDATE)){

			pstmt.setString(1, articleVendu.getNom());
			pstmt.setString(2, articleVendu.getDescription());
			pstmt.setDate(3, Date.valueOf(articleVendu.getDateDebutEncheres()));
			pstmt.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()));
			pstmt.setInt(5, articleVendu.getMiseAPrix());
			pstmt.setInt(6, articleVendu.getPrixVente());
			pstmt.setInt(7, articleVendu.getVente().getNoUtilisateur());
			pstmt.setInt(8, articleVendu.getCategorieArticle().getNoCategorie());
			pstmt.setInt(9, articleVendu.getNoArticle());

			pstmt.executeUpdate();


		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int noArticleVendu) {
		try (Connection connection = ConnectionProvider.getConnection();
			 PreparedStatement pstmt = connection.prepareStatement(DELETE)){

			pstmt.setInt(1, noArticleVendu);
			
			pstmt.executeUpdate();


		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArticleVendu articleBuilder(ResultSet rs) throws SQLException {

		Utilisateur vendeur = this.getVendeurArticle(rs.getInt("no_utilisateur"));
		Categorie categorie = this.getCategorieArticle(rs.getInt("no_categorie"));
		

		ArticleVendu articleVendu = new ArticleVendu();

		articleVendu.setnoArticle(rs.getInt("no_article"));
		articleVendu.setNom(rs.getString("nom_article"));
		articleVendu.setDescription(rs.getString("description"));
		articleVendu.setDateDebutEncheres((rs.getDate("date_debut_encheres").toLocalDate()));
		articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
		articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
		articleVendu.setPrixVente(rs.getInt("prix_vente"));
		articleVendu.setVente(vendeur);
		articleVendu.setCategorieArticle(categorie);
		

		return articleVendu;

	}


	private Categorie getCategorieArticle(int noCategorie) {
		CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();
		Categorie categorieArticle = null;
		try {
			categorieArticle = categorieDAO.selectById(noCategorie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorieArticle;
		
	}

	private Utilisateur getVendeurArticle(int noUtilisateur) {
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		Utilisateur vendeurArticle = null;
		try {
			vendeurArticle = utilisateurDAO.selectById(noUtilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendeurArticle;
	}

}
