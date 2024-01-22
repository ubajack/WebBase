package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.RetraitDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetraitDAOJdbcImpl implements RetraitDAO {

    private static final String INSERT = "INSERT INTO RETRAITS (no_article,rue,code_postal,ville) values (?,?,?,?)";
    private static final String GET_BY_ID = "SELECT * from RETRAITS where no_article=?";
    private static final String SELECT_ALL = "SELECT * RETRAITS";
    private static final String UPDATE = "UPDATE CATEGORIES set rue=?, code_postal=?, ville=? where no_article=?";
    private static final String DELETE = "DELETE CATEGORIES where no_article=?";

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
            retrait = new Retrait();
            retrait.setRue(rs.getString("rue"));
            retrait.setCodePostal(rs.getString("code_postal"));
            retrait.setVille(rs.getString("ville"));
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
        List<Retrait> retrait = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection();
             Statement pstmt = connection.createStatement()) {

            ResultSet rs = pstmt.executeQuery(SELECT_ALL);

            while(rs.next()) {
                retrait.add(getRetraitFromRs(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retrait;
    }

    private Retrait getRetraitFromRs(ResultSet rs) throws SQLException {

        Retrait retrait = null;
        retrait = new Retrait(rs.getInt("no_article"),rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville") );
        return retrait;
    }

    @Override
    public Retrait insert(Retrait retrait) {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(INSERT)) {

            pstmt.setInt(1, retrait.getNoRetrait());
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
    public Retrait update(Retrait retrait) {
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(UPDATE)) {

            pstmt.setInt(4, retrait.getNoRetrait());
            pstmt.setString(1, retrait.getRue());
            pstmt.setString(2, retrait.getCodePostal());
            pstmt.setString(3, retrait.getVille());

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return retrait;
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
