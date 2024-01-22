package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Enchere;

import java.util.List;

public interface EnchereDAO {

    public Enchere selectById(Integer noEnchere);

    public List<Enchere> selectAll();

    public void insert(Enchere a1);

    public void update(Enchere a);

    public void delete(int a);
}
