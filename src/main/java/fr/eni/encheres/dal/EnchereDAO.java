package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Enchere;

import java.util.List;

public interface EnchereDAO {

    public Enchere selectById(Integer noEnchere);

    public List<Enchere> selectAll();

    public Enchere insert(Enchere auctionInsert);

    public void update(Enchere auctionModif);

    public void delete(Integer noEnchere);
}
