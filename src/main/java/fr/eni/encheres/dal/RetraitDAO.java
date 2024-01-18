package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;

import java.util.List;

public interface RetraitDAO {
    public Retrait selectById(Integer noRetrait);

    public List<Retrait> selectAll();

    public void insert(Retrait a1);

    public void update(Retrait a);

    public void delete(int a);

}
