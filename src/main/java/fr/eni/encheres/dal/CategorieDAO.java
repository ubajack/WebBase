package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Categorie;

import java.util.List;

public interface CategorieDAO {
    public Categorie selectById(Integer noCategorie);

    public  List<Categorie> selectAll();

    public Categorie insert(Categorie a1);

    public void update(Categorie a);

    public void delete(int a);

}
