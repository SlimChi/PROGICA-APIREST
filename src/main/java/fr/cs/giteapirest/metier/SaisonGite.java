package fr.cs.giteapirest.metier;

public class SaisonGite {

    private int idGite;

    private int idSaison;

    private Float prix;

    private Saison saison;

    public SaisonGite(){

        saison = new Saison();
    }

    public int getIdGite() {
        return idGite;
    }

    public void setIdGite(int idGite) {
        this.idGite = idGite;
    }

    public int getIdSaison() {
        return idSaison;
    }

    public void setIdSaison(int idSaison) {
        this.idSaison = idSaison;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }




    @Override
    public String toString() {
        return           saison.toString()   + " - "  +   " Prix : " + prix + " € "            ;
    }
}
