package fr.eni.encheres.servlet.TESTcrud;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/testA")
public class ServletTestArticleVendu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ServletTestArticleVendu() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
        CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();


        //Initialisation CATEGORIE
        Categorie categorie = new Categorie(1039);
        Utilisateur utilisateur = new Utilisateur(6);

        ArticleVendu articleVendu = new ArticleVendu(1018,"Lot de pantalons","taille 42", LocalDate.now(),LocalDate.now().plusWeeks(2),50,50,categorie,utilisateur);
//        ArticleVendu noarticleVendu = new ArticleVendu(1008);

        ArticleVenduManager articleVenduManager = new ArticleVenduManager();
        ArticleVenduDAO articledao = DAOFactory.getArticleVenduDAO();

//		//INSERT
//        articledao.insert(articleVendu);


//		//SELECT BY ID
//        try {
//			ArticleVendu essai = articleVenduManager.selectArticleVenduById(?);
//			System.out.println(essai);
//        } catch (BLLException e) {
//            throw new RuntimeException(e);
//        }


//		//SELECT ALL
//        List<ArticleVendu> essai = articleVenduManager.selectAllArticleVendu();
//		System.out.println(essai);


		//UPDATE
        try {
            ArticleVendu essai = articleVenduManager.updateArticleVendu(articleVendu);
			System.out.println(essai);
        } catch (BLLException e) {
            throw new RuntimeException(e);
        }


//		//DELETE
//        try {
//            ArticleVendu essai = articleVenduManager.deleteArticleVendu(noarticleVendu);
//			System.out.println(essai);
//        } catch (BLLException e) {
//            throw new RuntimeException(e);
//        }

        response.getWriter().append("Served at: ").append(request.getContextPath());

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}