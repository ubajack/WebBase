package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	public int insert(Utilisateur use);
	
	public Utilisateur selectById(Integer noUtilisateur);
	
	public List<Utilisateur> selectAll();
	
	//public void update(Integer noUtilisateur, Utilisateur use);
	public void update(Utilisateur use);
	
	public void delete (Integer noUtilisateur) ;

	//void update(Integer noUtilisateur);
}
