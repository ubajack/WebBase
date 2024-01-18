
package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private Utilisateur use;
	
	private static final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postale, ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_ALL = "SELECT * from UTILISATEURS";
	private static final String SQL_SELECT_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postale, ville, mot_de_passe, credit, administrateur from UTILISATEURS where no_utilisateur = ?";
	private static final String UPDATE_UILISATEUR = "UPDATE UTILISATEUR SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postale=?, ville=?, mot_de_passe=?, administrateur=? where no_utilisateur= ?";
	private static final String DELETE_UTILISATEUR = "DELETE from where no_utilisateur = ?";

	@Override
	public void insert(Utilisateur use) {

		try (Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_UTILISATEUR,
						Statement.RETURN_GENERATED_KEYS))

		{
			pstmt.setString(1, use.getPseudo());
			pstmt.setString(2, use.getNom());
			pstmt.setString(3, use.getPrenom());
			pstmt.setString(4, use.getEmail());
			pstmt.setString(5, use.getTelephone());
			pstmt.setString(6, use.getRue());
			pstmt.setString(7, use.getCodePostale());
			pstmt.setString(8, use.getVille());
			pstmt.setString(9, use.getMotDePasse());
			pstmt.setBoolean(11, use.isAdministrateur());
				if(use.isAdministrateur() != true) {
					pstmt.setInt(10, 100);
				}else {
					pstmt.setInt(10, 0);
				}
			
			int res = pstmt.executeUpdate();
			if (res == 1) {
				System.out.println("Insertion réussie");
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next())
						;
					use.setNoUtilisateur(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur selectById(Integer noUtilisateur) {
		Utilisateur userSelectID = null;
		
		try(
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SQL_SELECT_BY_ID)
			){
			pstmt.setInt(1, noUtilisateur);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					userSelectID = getUtilisateurFromRs(rs);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userSelectID;
	}

	@Override
	public List<Utilisateur> selectAll() {
		
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		
		try(
			Connection connection = ConnectionProvider.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL) 	
			){
				while(rs.next()) {
					liste.add(getUtilisateurFromRs(rs));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return liste;
	}

	@Override
	public void update(Utilisateur use) {
		try(
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(UPDATE_UILISATEUR);	
			){
				pstmt.setString(1, use.getPseudo());
				pstmt.setString(2, use.getNom());
				pstmt.setString(3, use.getPrenom());
				pstmt.setString(4, use.getEmail());
				pstmt.setString(5, use.getTelephone());
				pstmt.setString(6, use.getRue());
				pstmt.setString(7, use.getCodePostale());
				pstmt.setString(8, use.getVille());
				pstmt.setString(9, use.getMotDePasse());
				pstmt.setInt(11, use.getNoUtilisateur());	
			
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer noUtilisateur) {
		try(
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(DELETE_UTILISATEUR);	
			){
				pstmt.setInt(1, noUtilisateur);
				pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Utilisateur getUtilisateurFromRs(ResultSet rs) throws SQLException {
		
	use = new Utilisateur(
			rs.getInt("no_utilisateur"), 
			rs.getString("pseudo"), 
			rs.getString("nom"), 
			rs.getString("prenom"), 
			rs.getString("telephone"), 
			rs.getString("rue"),
			rs.getString("code_postal"),
			rs.getString("ville"),
			rs.getString("mot_de_passe"),
			rs.getString("credit"),
			rs.getInt("credit"),
			rs.getBoolean("administrateur")
			);			
		return use;
	}
}
