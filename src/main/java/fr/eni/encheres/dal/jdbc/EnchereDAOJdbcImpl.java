package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;
import fr.eni.encheres.dal.UtilisateurDAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private Enchere auction;
	
	private static final String INSERT_ENCHERES = "INSERT INTO ENCHERES(date_enchere, montant_enchere, no_article, no_utilisateur) values(?,?,?,?)";
	private static final String SQL_SELECT_ALL = "SELECT * from ENCHERES";
	private static final String SQL_SELECT_BY_ID = "SELECT * from ENCHERES where no_enchere=?";
	private static final String UPDATE_ENCHERES = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=? where no_enchere=? ";
	private static final String DELETE_ENCHERES = "DELETE from ENCHERES where no_enchere = ?";
	
	private final UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	private final ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
	
    @Override
    public Enchere insert(Enchere auctionInsert) {
    	int auctionKey = -1; //auction pour enchere||initialisation de la Clé
		try (Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_ENCHERES,
						Statement.RETURN_GENERATED_KEYS))

		{	setEncheres(pstmt, auctionInsert); // factorisation de code
			pstmt.setInt(3, auctionInsert.getConcerne().getNoArticle());
			pstmt.setInt(4, auctionInsert.getEncherisseur().getNoUtilisateur());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			//int res = pstmt.executeUpdate();
			System.out.println("Insertion réussie");
				//try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
					auctionKey = rs.getInt(1);
					//auctionInsert.setNoEnchere(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}System.out.println("clé obtenu" + auctionInsert.getNoEnchere());
		return auctionInsert;
	}
   
	
	
	@Override
    public Enchere selectById(Integer noEnchere){
		Enchere enchereByID = null;
		try(
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_BY_ID)
			){
			pstmt.setInt(1, noEnchere);
			ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					enchereByID = getEncheres(rs);					
				}return enchereByID;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return  null;
    }

    @Override
    public List<Enchere> selectAll() {
    	
    	List<Enchere> liste = new ArrayList<Enchere>();
		
    	try(
			Connection connection = ConnectionProvider.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL) 	
			){
    			while(rs.next()) {
    				liste.add(getEncheres(rs));
    			}
    		System.out.println("Ajout d'article");
    		return liste;
    		
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
        
    }

    @Override
    public void update(Enchere auctionModif) {
    	try(
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(UPDATE_ENCHERES);	
			){ 
    		setEncheres(pstmt, auctionModif);
    		pstmt.setInt(3, auctionModif.getNoEnchere());
    			System.out.println("le numéro enchère est : " + auctionModif.getNoEnchere());
    			pstmt.executeUpdate();
    			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void delete(Integer noEnchere) {
    	try(
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(DELETE_ENCHERES);	
			){
				pstmt.setInt(1, noEnchere);
				pstmt.executeUpdate();
    				System.out.println("Article supprimée");
				
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    }
    
    private Enchere getEncheres(ResultSet rs) throws SQLException {
		
    	ArticleVendu articleVendu = articleVenduDAO.selectById(rs.getInt("no_article"));
		Utilisateur utilisateur = utilisateurDAO.selectById(rs.getInt("no_utilisateur"));
    	auction = new Enchere(
    			rs.getInt("no_enchere"), 
    			rs.getTimestamp("date_enchere").toLocalDateTime(), 
    			rs.getInt("montant_enchere"), 
    			articleVendu,
    			utilisateur		
    	);
    		return auction;
    	}
    
    
	private void setEncheres(PreparedStatement pstmt,Enchere auction) throws SQLException {
		//serTimestamp(1,auction.getDateEnchere().toLocalDateTime)
		
		pstmt.setTimestamp(1,Timestamp.valueOf(auction.getDateEnchere()));
		pstmt.setInt(2, auction.getMontantEnchere());		
	}
}