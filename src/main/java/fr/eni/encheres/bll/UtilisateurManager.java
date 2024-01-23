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

    public Utilisateur updateUtilisateur(Utilisateur utilisateur) throws BLLException {
        validerUtilisateur(utilisateur);
        utilisateurDAO.update(utilisateur);
        return utilisateur;
    }

    public Utilisateur deleteUtilisateur(Utilisateur utilisateur) throws BLLException {
        if( utilisateur == null|| utilisateur.getNoUtilisateur()==null) {
            throw new BLLException("Erreur lors de la suppression, l'utilisateur ou son ID est null.");
        }
        utilisateurDAO.delete(utilisateur.getNoUtilisateur());
        return utilisateur;
    }



    private void validerUtilisateur(Utilisateur utilisateur) throws BLLException {
        boolean valide = true;
        StringBuffer sb = new StringBuffer();


        if(utilisateur==null){
            throw new BLLException("Retrait null");
        }

        //Utilisation d'un regex pour vérifier si le pseudo contient que des caractères alphanumériques.
        if (utilisateur.getPseudo() == null || utilisateur.getPseudo().trim().length() == 0 || utilisateur.getPseudo().length() > 30 || !utilisateur.getPseudo().matches("^[a-zA-Z0-9]+$")) {
            sb.append("Le pseudo de l'utilisateur est obligatoire, ne doit pas dépasser 30 caractères, et ne doit contenir que des caractères alphanumériques.\n");
            valide = false;
        }

        if (isPseudoAlreadyTaken(utilisateur.getPseudo())) {
            sb.append("Le pseudo est déjà utilisé. Veuillez choisir un autre pseudo.\n");
            valide = false;
        }

        System.out.println(utilisateur.getPseudo());

        if(utilisateur.getNom()==null || utilisateur.getNom().trim().length()==0|| utilisateur.getNom().length()>30) {
            sb.append("Le nom de l'utilisateur est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }

        if(utilisateur.getPrenom()==null || utilisateur.getPrenom().trim().length()==0|| utilisateur.getPrenom().length()>30) {
            sb.append("Le prenom de l'utilisateur est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
            System.out.println("prenom"+valide);

        }
        System.out.println(utilisateur.getPrenom());

        //Utilisation d'un regex pour vérifier si l'email correspond au format.
        if(utilisateur.getEmail() == null || !utilisateur.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            sb.append("L'email de l'utilisateur est obligatoire, et doit être valide.\n");
            valide = false;
            System.out.println("email"+valide);
        }
        System.out.println(utilisateur.getEmail());


        if (isEmailAlreadyTaken(utilisateur.getEmail())) {
            sb.append("L'email est déjà utilisé. Veuillez choisir une autre adresse email.\n");
            valide = false;
        }

        //Utilisation d'un regex pour vérifier si le téléphone correspondre au format téléphone français.
        if (!utilisateur.getTelephone().matches("(0|\\+33|0033)[1-9][0-9]{8}")) {
            sb.append("Le téléphone doit correspondre au format français.\n");
            valide = false;
            System.out.println("telephone"+valide);

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

    //La méthode utilisateurs.stream() transforme la liste utilisateurs en un flux (stream) d'objets
    private boolean isEmailAlreadyTaken(String email) {
        List<Utilisateur> utilisateurs = utilisateurDAO.selectAll();

        // Vérifiez si l'email est déjà pris par un autre utilisateur
        return utilisateurs.stream().anyMatch(utilisateur -> utilisateur.getEmail() != null && utilisateur.getEmail().equals(email));
    }


    public boolean isPseudoAlreadyTaken(String pseudo) {
        // Récupère la liste de tous les utilisateurs depuis la base de données
        List<Utilisateur> utilisateurs = utilisateurDAO.selectAll();

        // Crée un flux (stream) à partir de la liste d'utilisateurs
        // Un stream est une séquence d'éléments sur laquelle vous pouvez effectuer différentes opérations
        return utilisateurs.stream()

                // Vérifie si au moins un utilisateur dans le flux (stream) correspond à la condition donnée
                .anyMatch(utilisateur ->
                        // Vérifie si le pseudo de l'utilisateur actuel n'est pas nul
                        utilisateur.getPseudo() != null &&

                                // Vérifie si le pseudo de l'utilisateur actuel est égal au pseudo fourni en argument
                                utilisateur.getPseudo().equals(pseudo)
                );
    }


        //DEUXIEME méthode pour véririfier qu'un éléments n'existe pas déjà =

//    private boolean isEmailAlreadyTaken(String email) {
//        List<Utilisateur> utilisateurs = utilisateurDAO.selectAll();
//
//        // Vérifiez si l'email est déjà pris par un autre utilisateur
//        for (Utilisateur utilisateur : utilisateurs) {
//            if (utilisateur.getEmail() != null && utilisateur.getEmail().equals(email)) {
//                return true; // L'email est déjà pris
//            }
//        }
//        return false; // L'email n'est pas pris
//    }
}
