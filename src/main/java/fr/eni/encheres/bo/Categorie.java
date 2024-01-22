package fr.eni.encheres.bo;

public class Categorie {
	
	private Integer noCategorie;
	private String libelle;
	
	//Contructeurs
	public Categorie() {}


	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	//Getters & Setters
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer id) {
		this.noCategorie = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + noCategorie + ", libelle=" + libelle + "]";
	}
}
