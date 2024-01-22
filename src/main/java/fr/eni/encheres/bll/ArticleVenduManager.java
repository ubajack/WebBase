package fr.eni.encheres.bll;



import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

import java.time.LocalDate;
import java.util.List;

public class ArticleVenduManager {
    private static ArticleVenduDAO articleVenduDAO;


    //Constructeur
    public ArticleVenduManager(){
        articleVenduDAO = DAOFactory.getArticleVenduDAO();
    }

    public List<ArticleVendu> selectAllArticleVendu(){
        List<ArticleVendu> articleVendus = articleVenduDAO.selectAll();
        return articleVendus;
    }

    public void insertArticleVendu(ArticleVendu articleVendu) throws BLLException {
        validerArticleVendu(articleVendu);
        articleVenduDAO.insert(articleVendu);
    }
    public void selectArticleVenduById(ArticleVendu articleVendu) throws BLLException {
        validerArticleVendu(articleVendu);
        articleVenduDAO.selectById(articleVendu.getNoArticle());
    }

    public void updateArticleVendu(ArticleVendu articleVendu) throws BLLException {
        validerArticleVendu(articleVendu);
        articleVenduDAO.update(articleVendu);
    }

    public void deleteArticleVendu(ArticleVendu articleVendu) throws BLLException {
        if( articleVendu == null|| articleVendu.getNoArticle()==null) {
            throw new BLLException("Erreur lors de la suppression, l'articleVendu ou son ID est null.");
        }
        articleVenduDAO.delete(articleVendu.getNoArticle());
    }



    private void validerArticleVendu(ArticleVendu articleVendu) throws BLLException {
        boolean valide = true;
        StringBuffer sb = new StringBuffer();

        if(articleVendu==null){
            throw new BLLException("Retrait null");
        }
        if(articleVendu.getNom()==null || articleVendu.getNom().trim().length()==0|| articleVendu.getNom().length()>30) {
            sb.append("Le nom de l'article est obligatoire et ne pas depasser 30 caractères.\n");
            valide = false;
        }
        if(articleVendu.getDescription()==null || articleVendu.getDescription().trim().length()==0|| articleVendu.getDescription().length()>300) {
            sb.append("La description de l'article est obligatoire et ne pas depasser 300 caractères.\n");
            valide = false;
        }
        if(articleVendu.getDateDebutEncheres()==null || articleVendu.getDateDebutEncheres().equals(LocalDate.now())) {
            sb.append("La date de début des encheres est obligatoire et ne pas être supérieur a la date du jour.\n");
            valide = false;
        }
        if(articleVendu.getDateFinEncheres()==null || articleVendu.getDateFinEncheres().isAfter(articleVendu.getDateDebutEncheres().plusWeeks(2))) {
            sb.append("La date de fin des encheres est obligatoire et ne pas être supérieur a la date de debut des enchères + 2 semaines.\n");
            valide = false;
        }
        if(articleVendu.getMiseAPrix()<=0) {
            sb.append("Le prix initial des encheres ne pas être inférieur ou égale à 0 ).\n");
            valide = false;
        }
        if(articleVendu.getPrixVente()<=articleVendu.getMiseAPrix()){
            sb.append("Le prix de vente des encheres ne pas être inférieur ou égale à 0 ).\n");
            valide = false;
        }

        if(!valide) {
            throw new BLLException(sb.toString());
        }

    }
}
