package fr.eni.encheres.bo;


import java.time.LocalDateTime;

public class Enchere {

    private Integer noEnchere;
    private LocalDateTime dateEnchere;
    private int montantEnchere;

    // Associations
    private ArticleVendu article;
    private Utilisateur encherisseur;
    private boolean remporte = false;


    

	public Enchere(Integer noEnchere, int montantEnchere) {
		super();
		this.noEnchere = noEnchere;
		this.montantEnchere = montantEnchere;
	}


	public Enchere(Integer noEnchere, LocalDateTime dateEnchere, int montantEnchere) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}


	public Enchere(Integer noEnchere, LocalDateTime dateEnchere , int montantEnchere, ArticleVendu article,
			Utilisateur encherisseur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.article = article;
		this.encherisseur = encherisseur;
	}
   

	// Getters & Setters
    public LocalDateTime getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(LocalDateTime dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public int getMontantEnchere() {
        return montantEnchere;
    }

    public void setMontantEnchere(int montantEnchere) {
        this.montantEnchere = montantEnchere;
    }

    public ArticleVendu getConcerne() {
        return article;
    }

    public void setConcerne(ArticleVendu article) {
        this.article = article;
    }

    public Utilisateur getEncherisseur() {
        return encherisseur;
    }

    public void setEncherisseur(Utilisateur encherisseur) {
        this.encherisseur = encherisseur;
    }

    public boolean isRemporte() {
        return remporte;
    }

    public void setRemporte(boolean remporte) {
        this.remporte = remporte;
    }

    public Integer getNoEnchere() {
        return noEnchere;
    }

    public void setNoEnchere(Integer noEnchere) {
        this.noEnchere = noEnchere;
    }

    @Override
    public String toString() {
        return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
                + ", article=" + article + ", encherisseur=" + encherisseur + ", remporte=" + remporte + "]";
    }


}
