package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.ConnectionProvider;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	 Connection connection = null; //pas obligatoire
	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values (?,?,?,?,?,?,?,?)";
	//private static final String UPDATE_ARTICLE = "UPDATE ARTICLES set reference=?,marque=?,designation=?,prixUnitaire=?,qteStock=?,grammage=?,couleur=? where idArticle=?";
	//private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES where idArticle=?";
	private static final String SELECT_BY_NO = "SELECT * FROM ARTICLES_VENDUS where no_article=?";
	private static final String SELECT_ALL = "SELECT * FROM ARTICLES";
	

//	public ArticleVendu selectById(int noArticle) throws DALException {
//		ArticleVendu art = null;
//		try (Connection connection = JdbcTools.getConnection();
//				PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_NO)) {
//			pstmt.setInt(1, noArticle);
//			try (ResultSet rs = pstmt.executeQuery()) {
//				if (rs.next()) {
//					art = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"),
//							rs.getString("date_debut_encheres"), rs.getString("date_fin_encheres"), rs.getDouble("prix_initial"), rs.getDouble("prix_vente"),
//							rs.getInt("no_categorie"),rs.getInt("no_categorie");
//					
//				}
//			}
//
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			throw new DALException("une erreur est survenue, veuillez nous excusez. Veuillez réessayer ultérieurement");
//		}
//		return art;
//	}

//	public List<ArticleVendu> selectAll() {
//		List<ArticleVendu> articlesVendus = new ArrayList<ArticleVendu>();
//
//		try (Connection connection = ConnectionProvider.getConnection();
//				Statement pstmt = connection.createStatement();
//				ResultSet rs = pstmt.executeQuery(SELECT_ALL)) {
//			
//			while (rs.next()) {
//				articlesVendus.add(new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"),
//						rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"), rs.getInt("prix_vente"),
//						rs.getInt("no_categorie")));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return articlesVendus;
//	}




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
	public ArticleVendu selectById(Integer idArticle){
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ArticleVendu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(ArticleVendu a){
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(int a){
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public ArticleVendu selectById(Integer idArticle) throws DALException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void update(ArticleVendu a) throws DALException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(int a) throws DALException {
//		// TODO Auto-generated method stub
//		
//	}

//	public void update(Article a) throws DALException {
//		try (Connection connection = JdbcTools.getConnection();
//				PreparedStatement pstmt = connection.prepareStatement(UPDATE_ARTICLE)) {
//			pstmt.setString(1, a.getReference());
//			pstmt.setString(2, a.getMarque());
//			pstmt.setString(3, a.getDesignation());
//			pstmt.setFloat(4, a.getPrixUnitaire());
//			pstmt.setInt(5, a.getQteStock());
//			pstmt.setInt(8, a.getIdArticle());
//			if (a instanceof Ramette) {
//				Ramette r = (Ramette) a;
//				pstmt.setInt(6, r.getGrammage());
//				pstmt.setNull(7, Types.VARCHAR);
//			}
//			if (a instanceof Stylo) {
//				Stylo s = (Stylo) a;
//				pstmt.setNull(6, Types.INTEGER);
//				pstmt.setString(7, s.getCouleur());
//			}
//
//			pstmt.executeUpdate();
//			System.out.println("modification réussi");
//
//		} catch (SQLException e) {
//			throw new DALException("Update article failed - " + a, e);
//		}
	
//
//	public void delete(int a) throws DALException {
//		try (Connection connection = JdbcTools.getConnection();
//				PreparedStatement pstmt = connection.prepareStatement(DELETE_ARTICLE)) {
//			// l'intégrité référentielle s'occupe d'invalider la suppression
//			// si l'article est référencé dans une ligne de commande
//			pstmt.setInt(1, a);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			throw new DALException("Delete article failed - id=" + a, e);
//		}
//	}
//
//	
//	}
}
