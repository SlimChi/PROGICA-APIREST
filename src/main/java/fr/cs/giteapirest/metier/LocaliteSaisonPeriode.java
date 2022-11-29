package fr.cs.giteapirest.metier;

public class LocaliteSaisonPeriode {

    private int idLocalite;

    private Localite localite;

    private int idSaison;

    private Saison saison;

    private int idPeriode;

    private Periode periode;


    public LocaliteSaisonPeriode(){}

    public int getIdLocalite() {
        return idLocalite;
    }

    public void setIdLocalite(int idLocalite) {
        this.idLocalite = idLocalite;
    }

    public int getIdSaison() {
        return idSaison;
    }

    public void setIdSaison(int idSaison) {
        this.idSaison = idSaison;
    }

    public int getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(int idPeriode) {
        this.idPeriode = idPeriode;
    }

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    @Override
    public String toString() {
        return "LocaliteSaisonPeriode{" +
                "localite=" + localite +
                ", saison=" + saison +
                ", periode=" + periode +
                '}';
    }
}
