package fr.eni.encheres.servlet.TESTcrud;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.Categorie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/testC")
public class ServletTestCategorie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ServletTestCategorie() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Initialisation CATEGORIE
		Categorie categorie = new Categorie(1040,"qsdqsd");
        Categorie nocategorie = new Categorie(1040);

        CategorieManager categorieManager = new CategorieManager();

//		//INSERT
//        try {
//            categorieManager.insertCategorie(categorie);
//        } catch (BLLException e) {
//            throw new RuntimeException(e);
//        }


//		//SELECT BY ID
//        try {
//			Categorie essai = categorieManager.selectCategorieById(?);
//			System.out.println(essai);
//        } catch (BLLException e) {
//            throw new RuntimeException(e);
//        }


//		//SELECT ALL
//        List<Categorie> essai = categorieManager.selectAllCategorie();
//		System.out.println(essai);


//		//UPDATE
//        try {
//            Categorie essai = categorieManager.updateCategorie(categorie);
//			System.out.println(essai);
//        } catch (BLLException e) {
//            throw new RuntimeException(e);
//        }


//		//DELETE
//        try {
//            Categorie essai = categorieManager.deleteCategorie(nocategorie);
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
