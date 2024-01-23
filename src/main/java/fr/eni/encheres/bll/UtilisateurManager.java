package fr.eni.encheres.bll;


import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

import java.util.List;


public class UtilisateurManager {


    private static UtilisateurDAO utilisateurDAO;


    //Constructeur
    public UtilisateurManager(){
        utilisateurDAO = DAOFactory.getUtilisateurDAO();
    }

    public List<Utilisateur> selectAllUtilisateur(){
        List<Utilisateur> utilisateurs = utilisateurDAO.selectAll();
        return utilisateurs;
    }

    public void insertUtilisateur(Utilisateur utilisateur) throws BLLException {
        validerUtilisateur(utilisateur);
        utilisateurDAO.insert(utilisateur);
    }
    public void selectUtilisateurById(Utilisateur utilisateur) throws BLLException {
        utilisateurDAO.selectById(utilisateur.getNoUtilisateur());
    }

    public void updateUtilisateur(Utilisateur utilisateur) throws BLLException {
        validerUtilisateur(utilisateur);
        utilisateurDAO.update(utilisateur);
    }

    public void deleteUtilisateur(Utilisateur utilisateur) throws BLLException {
        if( utilisateur == null|| utilisateur.getNoUtilisateur()==null) {
            throw new BLLException("Erreur lors de la suppression, l'utilisateur ou son ID est null.");
        }
        utilisateurDAO.delete(utilisateur.getNoUtilisateur());
    }



    private void validerUtilisateur(Utilisateur utilisateur) throws BLLException {
        boolean valide = true;
        StringBuffer sb = new StringBuffer();


        if(utilisateur==null){
            throw new BLLException("Retrait null");
        }
        if(utilisateur.getPseudo()==null || utilisateur.getPseudo().trim().length()==0|| utilisateur.getPseudo().length()>30) {
            sb.append("Le pseudo de l'utilisateur est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }
        if(utilisateur.getNom()==null || utilisateur.getNom().trim().length()==0|| utilisateur.getNom().length()>30) {
            sb.append("Le nom de l'utilisateur est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }
        if(utilisateur.getPrenom()==null || utilisateur.getPrenom().trim().length()==0|| utilisateur.getPrenom().length()>30) {
            sb.append("Le prenom de l'utilisateur est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }

        if(utilisateur.getEmail() == null || utilisateur.getEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
            sb.append("L'email de l'utilisateur est obligatoire, et doit être valide.\n");
            valide = false;
        }

        if (!utilisateur.getTelephone().matches("(0|\\+33|0033)[1-9][0-9]{8}")) {
            sb.append("Le téléphone doit correspondre au format français.\n");
            valide = false;
        }

        if(utilisateur.getRue()==null || utilisateur.getRue().trim().length()==0|| utilisateur.getRue().length()>30) {
            sb.append("La rue de l'utilisateur est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }

        if(utilisateur.getCodePostale()==null || utilisateur.getCodePostale().trim().length()==0|| utilisateur.getCodePostale().length()>10) {
            sb.append("Le code postal de l'utilisateur est obligatoire et ne pas depasser 10 caractères.\n");
            valide = false;
        }

        if(utilisateur.getVille()==null || utilisateur.getVille().trim().length()==0|| utilisateur.getVille().length()>30) {
            sb.append("La ville de l'utilisateur est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }

        if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().trim().length() == 0 || utilisateur.getMotDePasse().length() > 30) {
            sb.append("Le mot de passe de l'utilisateur est obligatoire et ne doit pas dépasser 30 caractères.\n");
            valide = false;
        }

        if (utilisateur.getCredit() < 0) {
            sb.append("Le crédit de l'utilisateur ne peut pas être négatif.\n");
            valide = false;
        }


        if(!valide) {
            throw new BLLException(sb.toString());
        }

    }

}
