package fr.eni.encheres.bo;

public class Enchere {

    private int noEnchere;
    private LocalDate dateEnchere;
    private int montantEnchere;

    // Associations
    private ArticleVendu article;
    private Utilisateur encherisseur;
    private boolean remporte = false;

    // Contructeurs
    public Enchere() {
    }

    public Enchere(LocalDate dateEnchere, int montantEnchere, ArticleVendu article, Utilisateur encherisseur) {
        super();
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.article = article;
        this.encherisseur = encherisseur;
    }

    // Getters & Setters
    public LocalDate getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(LocalDate dateEnchere) {
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

    public int getNoEnchere() {
        return noEnchere;
    }

    public void setNoEnchere(int noEnchere) {
        this.noEnchere = noEnchere;
    }

    @Override
    public String toString() {
        return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
                + ", article=" + article + ", encherisseur=" + encherisseur + ", remporte=" + remporte + "]";
    }


}
