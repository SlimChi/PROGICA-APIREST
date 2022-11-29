package fr.cs.giteapirest.metier;

public class Telephone {

    private String id;

    private int idPersonne;

    private int idTypeTelephone;

    private Personne personne;

    private TypeTelephone typeTelephone;



    public Telephone() {
        personne = new Personne();
        typeTelephone = new TypeTelephone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdTypeTelephone() {
        return idTypeTelephone;
    }

    public void setIdTypeTelephone(int idTypeTelephone) {
        this.idTypeTelephone = idTypeTelephone;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public TypeTelephone getTypeTelephone() {
        return typeTelephone;
    }

    public void setTypeTelephone(TypeTelephone typeTelephone) {
        this.typeTelephone = typeTelephone;
    }

    @Override
    public String toString() {
        return typeTelephone+" : "+id;
    }
}
