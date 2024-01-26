package fr.eni.encheres.servlet;

import fr.eni.encheres.bll.ArticleVenduManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("")
public class ServletIndex extends HttpServlet {
    private CategorieManager categorieManager = new CategorieManager();
    private ArticleVenduManager articleVenduManager = new ArticleVenduManager();
    private List<ArticleVendu> listeArticles = new ArrayList<>();
    List<Categorie> listeCategories = new ArrayList<>();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("debut servlet");

        if (request.getParameterMap().isEmpty()) {

            try {
                listeCategories = categorieManager.selectAllCategorie();
            } catch (Exception e) {
            }
            request.setAttribute("listeCategories", listeCategories);


//        System.out.println("milieu servlet"+listeCategories);
//        System.out.println("fin servlet"+listeCategories);


            try {
                listeArticles = articleVenduManager.selectAllArticleVendu();
            } catch (Exception e) {

            }
            request.setAttribute("listeArticles", listeArticles);
            System.out.println(listeArticles);


            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

        String search = request.getParameter("search-input");
        int noCategorie = Integer.parseInt(request.getParameter("listeCategories"));
        System.out.println(search+noCategorie);

        List<ArticleVendu> listeArticlesFiltrer = noCategorie == -1 ?
                listeArticles.stream()
                        .filter(articleVendu -> articleVendu.getNom().toLowerCase().contains(search))
                        .collect(Collectors.toList()) :
                listeArticles.stream()
                        .filter(articleVendu -> articleVendu.getNom().toLowerCase().contains(search))
                        .filter(articleVendu -> articleVendu.getCategorieArticle().getNoCategorie() == noCategorie)
                        .collect(Collectors.toList());

        System.out.println(listeArticlesFiltrer);

        request.setAttribute("listeArticles",listeArticlesFiltrer);
        request.setAttribute("categorie",noCategorie);
        request.setAttribute("listeCategories", listeCategories);


        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);


    }

}

