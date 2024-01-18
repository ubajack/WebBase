package fr.eni.encheres.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Aaa")
public class Aaa extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Aaa() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
//		Categorie categorie = new Categorie(2, "vaaaaasee");
//		Utilisateur utilisateur = new Utilisateur();
//
//		// Instanciation du jeu d'essai
//		ArticleVendu a1 = new ArticleVendu("Vase", " qsdqsdqsd", LocalDate.of(2024, 01, 17), LocalDate.of(2024, 01, 18), 4, 4, categorie, utilisateur);
//
//		System.out.println("Ajout des articles... ");
//		articleVenduDAO.insert(a1);
//		System.out.println("Article ajouté  : " + a1.toString());
//		response.getWriter().append("Served at: ").append("Chouette cool la techno").append(request.getContextPath());
//
//		response.getWriter().append("ouai c'est cool").append(request.getContextPath());

		CategorieDAO categorie = DAOFactory.getCategorieDAO();

		// Instanciation du jeu d'essai
		Categorie a2 = new Categorie(1,"dsfsdf");
		Categorie a3 = new Categorie(2,"dsrtgdgfdf");
		Categorie a4 = new Categorie(3,"fdgsfgsgdfgdfgdg");

		System.out.println("Ajout des articles... ");
		categorie.insert(a2);
		categorie.insert(a3);
		categorie.insert(a4);

		System.out.println("Article ajouté  : " + a2.toString());
		response.getWriter().append("Served at: ").append("Chouette cool la techno").append(request.getContextPath());

		response.getWriter().append("ouai c'est cool").append(request.getContextPath());

		//Sélection de tous les articles
		List<Categorie> categories = categorie.selectAll();
		System.out.println("Sélection de tous les articles  : " + categories.toString() );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
