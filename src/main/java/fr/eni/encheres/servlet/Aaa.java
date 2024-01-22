package fr.eni.encheres.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;
import fr.eni.encheres.dal.UtilisateurDAO;
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

		CategorieDAO categorie = DAOFactory.getCategorieDAO();
		UtilisateurDAO user = DAOFactory.getUtilisateurDAO();
		
			// Attention si on utilise un contructeur qui ne prend pas tous les champs
			// et donc ne peut pas restituer un champs qui n'exciste pas. EX user1
		
		//Utilisateur user1 = new Utilisateur("CdopL", "hay", "moi", "monem", "0707505000","lafolle", "49496", "paselle", "ouest");
		//Utilisateur user2 = new Utilisateur("loped", "ayh", "moi", "monem", "0707505000","lafolle", "49496", "paselle", "ouest");
		Utilisateur user3 = new Utilisateur(48,"ouatsipoul", "yah", "moi", "monem", "0707505000","lafolle", "49496", "paselle", "ouest",true);
		Utilisateur user6 = new Utilisateur(47,"alersecoucher", "yah", "moi", "monem", "0707505000","lafolle", "49496", "paselle", "ouest",false);
		Utilisateur user7 = new Utilisateur(1, "cestPresquelHeure", "yah", "moi", "monem", "0707505000","lafolle", "49496", "paselle", "ouest",50,true);
		//Utilisateur user4 = new Utilisateur("ckcnjkcqjkcbnvdkj", "b", "c", "d", "e", "f", "g", "h", "i");
		//Utilisateur user5 = new Utilisateur("irlandoule", "hay", "axel", "email", "07960432", "ruel", "49494", "brol", "mpis");
		//Utilisateur leme = new Utilisateur(0, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD, 0, false)
		
		//INSERTION UTILISATEUR
//		int numerUser =user.insert(user6);		
//		int numberUse = user.insert(user3); 		
//		user.insert(user4);
//		System.out.println(user4.getNoUtilisateur());	//méthode différentes selon l'insert
//		
//		int numeroUtilisateur = user.insert(user5);		//A prioriser car plus performant 
//		System.out.println(numeroUtilisateur);			
//		
//		numeroUtilisateur = user.insert(user3);
//		System.out.println(numeroUtilisateur);
		
		//SELCT BY UTITLISATEUR
//		List<Utilisateur>utilisateurs = user.selectAll(); 
//		System.out.println("Les utilisateurs " + utilisateurs.toString());
//				
		Utilisateur useID = user.selectById(48);
		System.out.println("l'utilisateur choisi est :" + useID.toString());
		
		//user.delete(40);
		//UPDATE 
//		System.out.println("avant modif" + user6.toString());
//		user6.setPseudo("jeTEmerde");
//		user.update(user6);
//		System.out.println("apres modif" + user6.toString());
		
		Categorie a2 = new Categorie("dsfsdf");
		Categorie a3 = new Categorie("dsrtgdgfdf");
		
		
//		categorie.insert(a2);
//		categorie.insert(a3);
		//int numeroUtilisateur = user.insert(user5);
		//user.insert(user5);
//		System.out.println(a2.getNoCategorie());
		

		
		
		

		// Instanciation du jeu d'essai
//		Categorie a2 = new Categorie(1,"dsfsdf");
//		Categorie a3 = new Categorie(2,"dsrtgdgfdf");
//		
//
//		System.out.println("Ajout des articles... ");
//		categorie.insert(a2);
//		categorie.insert(a3);
//		
//		categorie.delete();
//
//		System.out.println("Article ajouté  : " + a2.toString());
		


	//Sélection de tous les articles
		
//		List<Categorie> categories = categorie.selectAll();
//		System.out.println("Sélection de tous les articles  : " + categories.toString() );
	
	//Séléction par ID
//		Categorie cat = categorie.selectById(1);
//		System.out.println("l'article selectionner est : " + cat.toString());
//			//System.out.println("avant modification" + categorie.selectById(1).toString());
//		cat.setLibelle("console");
//		System.out.println(cat.toString());
		
		//categorie.update(cat);
			//System.out.println("après modif" + cat.toString());
		
		//response.getWriter().append(categorie.update(cat).toString());// pour afficher sur le navigateur !!!!! pas de méthode void
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
