package fr.eni.encheres.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;
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
		UtilisateurDAO user = DAOFactory.getUtilisateurDAO();
		EnchereDAO enchere = DAOFactory.getEnchereDAO();
		ArticleVenduDAO articleVendu = DAOFactory.getArticleVenduDAO();
		
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
		
		
		
		//enchere.insert(enchere1);
		
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
//		Utilisateur useID = user.selectById(48);
//		System.out.println("l'utilisateur choisi est :" + useID.toString());
		
		//user.delete(40);
		//UPDATE 
//		System.out.println("avant modif" + user6.toString());
//		user6.setPseudo("jeTEmerde");
//		user.update(user6);
//		System.out.println("apres modif" + user6.toString());
		
//		Categorie cat1 = new Categorie(1, "dsfsdf");
//		Categorie a3 = new Categorie(null, "dsrtgdgfdf");
		
		
//		categorie.insert(a2);
//		categorie.insert(a3);
		//int numeroUtilisateur = user.insert(user5);
		//user.insert(user5);
//		System.out.println(a2.getNoCategorie());
		

	
		
		

		// Instanciation du jeu d'essai
		Categorie cat1 = new Categorie(1,"dsfsdf");
//		categorie.insert(cat1);
//		Categorie a3 = new Categorie(2,"dsrtgdgfdf");
//		
//
//		System.out.println("Ajout des articles... ");
//		categorie.insert(cat1);
		
		ArticleVendu Art1 = new ArticleVendu(5, "brosse", "nettoyageCul", LocalDate.now(), LocalDate.now().plusWeeks(2), 3, 3, cat1, user6);
//		articleVendu.insert(Art1);
		
		Enchere enchere1 = new Enchere(9, LocalDateTime.now(), 50, Art1, user3);
//		enchere.insert(enchere1);
		
		enchere.delete(9);
//		System.out.println("avant modif" + enchere1.toString());
//		enchere1.setMontantEnchere(200);
//		enchere.update(enchere1);
//		System.out.println("apres modif" + enchere1.toString());
		
//		List<Enchere>utilisateurs = enchere.selectAll(); 
//		System.out.println("Les utilisateurs " + utilisateurs.toString());
//		Enchere auctionID = enchere.selectById(4);
//		System.out.println("l'utilisateur choisi est :" + auctionID.toString());
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
