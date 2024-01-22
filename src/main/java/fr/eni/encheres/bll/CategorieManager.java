package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

import java.util.List;

public class CategorieManager {

    private static CategorieDAO categorieDAO;


    //Constructeur
    public CategorieManager(){
        categorieDAO = DAOFactory.getCategorieDAO();
    }

    public List<Categorie> selectAllCategorie(){
        List<Categorie> categories = categorieDAO.selectAll();
        return categories;
    }

    public void insertCategorie(Categorie categorie){
        validerCategorie(categorie);
        categorieDAO.insert(categorie);
    }
    public void selectCategorieById(Categorie categorie){
        validerCategorie(categorie);
        categorieDAO.selectById(categorie.getNoCategorie());
    }

    public void updateCategorie(Categorie categorie){
        validerCategorie(categorie);
        categorieDAO.update(categorie);
    }

    public void deleteCategorie(Categorie categorie){
        validerCategorie(categorie);
        categorieDAO.delete(categorie.getNoCategorie());
    }






    private void validerCategorie(Categorie categorie) {
    }

}
