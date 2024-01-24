package fr.eni.encheres.servlet;

import java.io.IOException;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurManager manager = new UtilisateurManager();
	//private Utilisateur utilsateur;	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u = (Utilisateur) request.getSession().getAttribute("utilisateur");
		
		if(u == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath() + "/connexion");
		}

		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			System.out.println("le post est fonctionnelle au début");
			
		String pseudo = request.getParameter("pseudo");
		String lastName = request.getParameter("name");
		String name = request.getParameter("firstName");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String street = request.getParameter("rue");
		String postalCode = request.getParameter("codePostal");
		String city = request.getParameter("ville");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("confirmPassword");
		
		try {
			
//			System.out.println("j'ai pus essayer mais après faut voir");
//			System.out.println(request.getParameter("firstName"));
			Utilisateur user = manager.insertUtilisateur(pseudo, lastName, name, email, telephone, street, postalCode, city, password, passwordCheck);
		
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", user);
			session.setMaxInactiveInterval(300);
			
			response.sendRedirect(request.getContextPath()+"/"); //cette ligne est ce que elle st obligatoire
			
		} catch (BLLException e) {
			e.printStackTrace();
			request.setAttribute("erreur", e.getMessage());
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
			//rd.forward(request, response);
			doGet(request, response);
		}
	}

}
