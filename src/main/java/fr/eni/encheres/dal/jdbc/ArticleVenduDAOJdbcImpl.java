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
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.*;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values (?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_ID = "select * from ARTICLES_VENDUS where no_article= ?";
	private static final String SELECT_ALL = "select * from ARTICLES_VENDUS";
	private static final String UPDATE = "update ARTICLES_VENDUS set nom_article = ?, description = ?, date_debut_encheres=?, date_fin_encheres= ?, prix_initial= ?, prix_vente= ?,  no_utilisateur= ?, no_categorie=? where no_article= ? ";

	private static final String DELETE = "DELETE ARTICLES_VENDUS where no_categorie=?";

	private final UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	private final CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();


	@Override
	public ArticleVendu selectById(Integer noArticle) {
		ArticleVendu a = null;
		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Utilisateur utilisateur = utilisateurDAO.selectById(rs.getInt("no_utilisateur"));
				Categorie categorie = categorieDAO.selectById(rs.getInt("no_categorie"));
				a = new ArticleVendu(noArticle, rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), categorie, utilisateur);

			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}

		return a;
	}

	@Override
	public List<ArticleVendu> selectAll() {
		ArticleVendu a = null;
		List<ArticleVendu> result = new ArrayList<>();

		try(Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Utilisateur utilisateur = utilisateurDAO.selectById(rs.getInt("no_utilisateur"));
				Categorie categorie = categorieDAO.selectById(rs.getInt("no_categorie"));
				a = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getInt("prix_vente"), categorie, utilisateur);
				result.add(a);
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		return result;
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
			pstmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(8, articleVendu.getCategorieArticle().getNoCategorie());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				articleVendu.setNoArticle(rs.getInt(1));
			}
			} catch (SQLException e) {
            throw new RuntimeException(e);
        }
		return articleVendu;
	}

	@Override
	public void update(ArticleVendu articleVendu) {
		try (Connection connection = ConnectionProvider.getConnection(); PreparedStatement pstmt = connection.prepareStatement(UPDATE)){

			pstmt.setString(1, articleVendu.getNom());
			pstmt.setString(2, articleVendu.getDescription());
			pstmt.setDate(3, Date.valueOf(articleVendu.getDateDebutEncheres()));
			pstmt.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()));
			pstmt.setInt(5, articleVendu.getMiseAPrix());
			pstmt.setInt(6, articleVendu.getPrixVente());
			pstmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur());
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

}
