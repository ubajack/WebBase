package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetraitDAOJdbcImpl implements RetraitDAO {

    private static final String INSERT = "INSERT INTO RETRAITS (no_article,rue,code_postal,ville) values (?,?,?,?)";
    private static final String GET_BY_ID = "SELECT * from RETRAITS where no_retrait=?";
    private static final String SELECT_ALL = "SELECT * RETRAITS";
    private static final String UPDATE = "UPDATE RETRAITS  set no_article =?, set rue=?, code_postal=?, ville=? where no_retrait=?";
    private static final String DELETE = "DELETE RETRAITS where no_retrait=?";
    private final ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();

    @Override
    public Retrait selectById(Integer noRetrait) {


    Retrait retrait = null;
        try(
    Connection connection = ConnectionProvider.getConnection();
    PreparedStatement pstmt = connection.prepareStatement(GET_BY_ID))

    {
        pstmt.setInt(1, noRetrait);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            ArticleVendu articleVendu = articleVenduDAO.selectById(rs.getInt("no_article"));
            retrait = new Retrait();
            retrait.setRue(rs.getString("rue"));
            retrait.setCodePostal(rs.getString("code_postal"));
            retrait.setVille(rs.getString("ville"));
            retrait.setArticle(articleVendu);
        }

    } catch(
    SQLException e)

    {
        throw new RuntimeException(e);
    }
        return retrait;
}

    @Override
    public List<Retrait> selectAll() {
        Retrait a = null;
        List<Retrait> retrait = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection();
             Statement pstmt = connection.createStatement()) {

            ResultSet rs = pstmt.executeQuery(SELECT_ALL);

            while(rs.next()) {
                ArticleVendu articleVendu = articleVenduDAO.selectById(rs.getInt("no_article"));
                a = new Retrait(rs.getInt("no_retrait"),rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"),articleVendu);

                retrait.add(a);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retrait;
    }


    @Override
    public Retrait insert(Retrait retrait) {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, retrait.getArticle().getNoArticle());
            pstmt.setString(2, retrait.getRue());
            pstmt.setString(3, retrait.getCodePostal());
            pstmt.setString(4, retrait.getVille());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                retrait.setNoRetrait(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return retrait;

    }

    @Override
    public void update(Retrait retrait) {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {
            pstmt.setInt(1, retrait.getArticle().getNoArticle());
            pstmt.setString(2, retrait.getRue());
            pstmt.setString(3, retrait.getCodePostal());
            pstmt.setString(4, retrait.getVille());
            pstmt.setInt(5, retrait.getNoRetrait());

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int noRetrait) {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(DELETE)) {

            pstmt.setInt(1,noRetrait);

            pstmt.executeUpdate();


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
