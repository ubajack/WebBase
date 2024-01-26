package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAOJdbcImpl implements CategorieDAO {

    private static final String INSERT = "INSERT INTO CATEGORIES (libelle) values (?)";
    private static final String GET_BY_ID = "SELECT * from CATEGORIES where no_categorie=?";
    private static final String SELECT_ALL = "SELECT * from CATEGORIES";
    private static final String UPDATE = "UPDATE CATEGORIES set libelle=? where no_categorie=?";
    private static final String DELETE = "DELETE CATEGORIES where no_categorie=?";

    private static final String DELETE_ALL = "DELETE * from CATEGORIES";





    @Override
    public Categorie selectById(Integer noCategorie){
        Categorie cat = null;
        try (Connection connection = ConnectionProvider.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(GET_BY_ID)){
            pstmt.setInt(1,noCategorie);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                cat= new Categorie();
                cat.setNoCategorie(rs.getInt("no_categorie"));
                cat.setLibelle(rs.getString("libelle"));
            }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return cat;
            
    }
    @Override
    public List<Categorie> selectAll() {
        List<Categorie> categories = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection();
             Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(SELECT_ALL);

            while(rs.next()) {
                categories.add(getCategorieFromRs(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categories;
    }

    private Categorie getCategorieFromRs(ResultSet rs) throws SQLException {
        Categorie cat = null;
        cat = new Categorie(rs.getInt("no_categorie"),rs.getString("libelle") );
        return cat;
    }

    @Override
    public Categorie insert(Categorie categorie) {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(INSERT,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, categorie.getLibelle() );


            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                categorie.setNoCategorie(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorie;
    }

    @Override
    public void update(Categorie categorie) {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {

            pstmt.setInt(2, categorie.getNoCategorie());
            pstmt.setString(1, categorie.getLibelle());
            
            pstmt.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int noCategorie) {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(DELETE)) {

            pstmt.setInt(1,noCategorie);

            pstmt.executeUpdate();


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
