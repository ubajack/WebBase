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

    public void insertCategorie(Categorie categorie) throws BLLException {
        validerCategorie(categorie);
        categorieDAO.insert(categorie);
    }
    public void selectCategorieById(Categorie categorie) throws BLLException {
        categorieDAO.selectById(categorie.getNoCategorie());
    }

    public Categorie updateCategorie(Categorie categorie) throws BLLException {
        validerCategorie(categorie);
        categorieDAO.update(categorie);
        return categorie;
    }

    public Categorie deleteCategorie(Categorie categorie) throws BLLException {
        if( categorie == null|| categorie.getNoCategorie()==null) {
            throw new BLLException("Erreur lors de la suppression, la categorie ou son ID est null.");
        }
        categorieDAO.delete(categorie.getNoCategorie());
        return categorie;
    }



    private void validerCategorie(Categorie categorie) throws BLLException {
        boolean valide = true;
        StringBuffer sb = new StringBuffer();

        if(categorie==null){
            throw new BLLException("Categorie null");
        }
        if(categorie.getLibelle()==null || categorie.getLibelle().trim().length()==0|| categorie.getLibelle().length()>30) {
            sb.append("Le libelle de la categorie est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }

        if(!valide) {
            throw new BLLException(sb.toString());
        }

    }

}
