package fr.eni.encheres.bll;


import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

import java.time.LocalDate;
import java.util.List;

public class EnchereManager {
    private static EnchereDAO enchereDAO;


    //Constructeur
    public EnchereManager(){
        enchereDAO = DAOFactory.getEnchereDAO();
    }

    public List<Enchere> selectAllEnchere(){
        List<Enchere> categories = enchereDAO.selectAll();
        return categories;
    }

    public void insertEnchere(Enchere enchere) throws BLLException {
        validerEnchere(enchere);
        enchereDAO.insert(enchere);
    }
    public void selectEnchereById(Enchere enchere) throws BLLException {
        validerEnchere(enchere);
        enchereDAO.selectById(enchere.getNoEnchere());
    }

    public void updateEnchere(Enchere enchere) throws BLLException {
        validerEnchere(enchere);
        enchereDAO.update(enchere);
    }

    public void deleteEnchere(Enchere enchere) throws BLLException {
        if( enchere == null|| enchere.getNoEnchere()==null) {
            throw new BLLException("Erreur lors de la suppression, l'enchere ou son ID est null.");
        }
        enchereDAO.delete(enchere.getNoEnchere());
    }



    private void validerEnchere(Enchere enchere) throws BLLException {
        boolean valide = true;
        StringBuffer sb = new StringBuffer();

        if(enchere==null){
            throw new BLLException("Categorie null");
        }
        if(enchere.getDateEnchere()==null || enchere.getDateEnchere().equals(LocalDate.now())) {
            sb.append("La date de l'encheres est obligatoire et ne pas être supérieur a la date du jour.\n");
            valide = false;
        }

        if(enchere.getMontantEnchere()==0) {
            sb.append("Le montant de l'enchere est obligatoire.\n");
            valide = false;
        }

        if(!valide) {
            throw new BLLException(sb.toString());
        }

    }
}
