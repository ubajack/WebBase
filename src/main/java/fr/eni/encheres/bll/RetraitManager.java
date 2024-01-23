package fr.eni.encheres.bll;


import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;

import java.util.List;

public class RetraitManager {

    private static RetraitDAO retraitDAO;


    //Constructeur
    public RetraitManager(){
        retraitDAO = DAOFactory.getRetraitDAO();
    }

    public List<Retrait> selectAllRetrait(){
        List<Retrait> retraits = retraitDAO.selectAll();
        return retraits;
    }

    public void insertRetrait(Retrait retrait) throws BLLException {
        validerRetrait(retrait);
        retraitDAO.insert(retrait);
    }
    public void selectRetraitById(Retrait retrait) throws BLLException {
        retraitDAO.selectById(retrait.getNoRetrait());
    }

    public void updateRetrait(Retrait retrait) throws BLLException {
        validerRetrait(retrait);
        retraitDAO.update(retrait);
    }

    public void deleteRetrait(Retrait retrait) throws BLLException {
        if( retrait == null|| retrait.getNoRetrait()==null) {
            throw new BLLException("Erreur lors de la suppression, le retrait ou son ID est null.");
        }
        retraitDAO.delete(retrait.getNoRetrait());
    }



    private void validerRetrait(Retrait retrait) throws BLLException {
        boolean valide = true;
        StringBuffer sb = new StringBuffer();

        if(retrait==null){
            throw new BLLException("Retrait null");
        }
        if(retrait.getRue()==null || retrait.getRue().trim().length()==0|| retrait.getRue().length()>30) {
            sb.append("La rue du lieu de retrait est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }
        if(retrait.getCodePostal()==null || retrait.getCodePostal().trim().length()==0|| retrait.getCodePostal().length()>15) {
            sb.append("Le code postal du lieu de retrait est obligatoire et ne pas depasser 15 caractères.\n");
            valide = false;
        }
        if(retrait.getVille()==null || retrait.getVille().trim().length()==0|| retrait.getVille().length()>30) {
            sb.append("La ville du lieu de retrait est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }

        if(!valide) {
            throw new BLLException(sb.toString());
        }

    }
}
