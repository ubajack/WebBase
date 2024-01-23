package fr.eni.encheres.bo;

public class Categorie {
	
	private Integer noCategorie;
	private String libelle;
	
	//Contructeurs
	public Categorie() {}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Categorie(Integer noCategorie) {
		super();
		this.noCategorie = noCategorie;
	}


	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	//Getters & Setters
	public Integer getNoCategorie() {
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
