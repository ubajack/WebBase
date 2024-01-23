package fr.eni.encheres.servlet;

import java.io.IOException;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testU")
public class ServletTestUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletTestUtilisateur() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Initialisation UTILISATEUR
		Utilisateur utilisateur = new Utilisateur(6,"Abaru","Fortmann","Chloé","f.fortmannchloe@gmail.com","0600000000","eni","ecole","informatique","motDePasse",false);
//		Utilisateur noutilisateur = new Utilisateur(6);

		UtilisateurManager utilisateurManager = new UtilisateurManager();
//
//		//INSERT
//        try {
//            utilisateurManager.insertUtilisateur(utilisateur);
//        } catch (BLLException e) {
//            throw new RuntimeException(e);
//        }


//		//SELECT BY ID
//        try {
//			Utilisateur essai = utilisateurManager.selectUtilisateurById(?);
//			System.out.println(essai);
//        } catch (BLLException e) {
//            throw new RuntimeException(e);
//        }


//		//SELECT ALL
//        List<Utilisateur> essai = utilisateurManager.selectAllUtilisateur();
//		System.out.println(essai);


//		//UPDATE
//        try {
//			Utilisateur essai = utilisateurManager.updateUtilisateur(utilisateur);
//			System.out.println(essai);
//        } catch (BLLException e) {
//            throw new RuntimeException(e);
//        }


//		//DELETE
//        try {
//			Utilisateur essai = utilisateurManager.deleteUtilisateur(noutilisateur);
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
