package fr.eni.encheres.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;
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
		
		ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();
		Categorie categorie = new Categorie();
		Utilisateur utilisateur = new Utilisateur();

//		// Instanciation du jeu d'essai
//		ArticleVendu a1 = new ArticleVendu("Vase", " qsdqsdqsd", LocalDate.of(2024, 01, 17), LocalDate.of(2024, 01, 18), 4, 4);
//
//		System.out.println("Ajout des articles... ");
//		articleVenduDAO.insert(a1);
//		System.out.println("Article ajouté  : " + a1.toString());
//		response.getWriter().append("Served at: ").append("Chouette cool la techno").append(request.getContextPath());
//
//		response.getWriter().append("ouai c'est cool").append(request.getContextPath());



//		//ESSAIE CRUD CATEGORIE
//		CategorieDAO categorie = DAOFactory.getCategorieDAO();
//
//		// Instanciation du jeu d'essai
//		Categorie a2 = new Categorie("test constructeur");
//		Categorie a3 = new Categorie("test qsdqsdj");
//		Categorie a4 = new Categorie("tyredf qsfqsfj");
//
//
//		//Insert
//		System.out.println("Ajout des articles... ");
//		categorie.insert(a2);
//		categorie.insert(a3);
//		categorie.insert(a4);

//		System.out.println("Article ajouté  : " + a2.toString());
//		response.getWriter().append("Served at: ").append("Chouette cool la techno").append(request.getContextPath());
//
//		response.getWriter().append("ouai c'est cool").append(request.getContextPath());

//		//Sélection de tous les articles
//		List<Categorie> categories = new ArrayList<Categorie>();
//		categories = categorie.selectAll();
//		System.out.println("Sélection de tous les articles  : " + categories.toString() );

//		//Sélection de l'article par id
//		Categorie categorie2 = categorie.selectById(11);
//		System.out.println("Sélection de l'article par id  : " + categorie2.toString() );


//		//Modification d'un article
//		System.out.println("Modification d'un article  : " );
//		System.out.println("Article avant modification : "  + categorie2.toString());
//		categorie2.setLibelle("modification de la ligne 11");
//		categorie.update(categorie2);
//		System.out.println("Article après modification  : " + categorie2.toString() );

		//Suppression d'un article
//		System.out.println("Suppression de l'article  : " + categorie2.toString());
//		categorie.delete(categorie2.getNoCategorie());


		//ESSAIE CRUD RETRAIT
		RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();

		// Instanciation du jeu d'essai
		Retrait a2 = new Retrait("rue","68000","lool");
		Retrait a3 = new Retrait("chemin","90000","mdr");
		Retrait a4 = new Retrait("route","70000","tropdrole");



		//Insert
		System.out.println("Ajout des articles... ");
		retraitDAO.insert(a2);
		retraitDAO.insert(a3);
		retraitDAO.insert(a4);

//		System.out.println("Article ajouté  : " + a2.toString());
//		response.getWriter().append("Served at: ").append("Chouette cool la techno").append(request.getContextPath());
//
//		response.getWriter().append("ouai c'est cool").append(request.getContextPath());

//		//Sélection de tous les articles
//		List<Categorie> categories = new ArrayList<Categorie>();
//		categories = categorie.selectAll();
//		System.out.println("Sélection de tous les articles  : " + categories.toString() );

//		//Sélection de l'article par id
//		Categorie categorie2 = categorie.selectById(11);
//		System.out.println("Sélection de l'article par id  : " + categorie2.toString() );


//		//Modification d'un article
//		System.out.println("Modification d'un article  : " );
//		System.out.println("Article avant modification : "  + categorie2.toString());
//		categorie2.setLibelle("modification de la ligne 11");
//		categorie.update(categorie2);
//		System.out.println("Article après modification  : " + categorie2.toString() );

		//Suppression d'un article
//		System.out.println("Suppression de l'article  : " + categorie2.toString());
//		categorie.delete(categorie2.getNoCategorie());

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
