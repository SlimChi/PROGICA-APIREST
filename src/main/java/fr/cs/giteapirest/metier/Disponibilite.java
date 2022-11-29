package fr.cs.giteapirest.metier;

public class Disponibilite {

    private int id;

    private Integer jour;

    private String heureDebut;

    private String heureFin;

    private int idPersonne;

    private Personne personne;

    public Disponibilite (){

        personne = new Personne();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getJour() {
        return jour;
    }

    public void setJour(Integer jour) {
        this.jour = jour;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        String jourLettre = jour.toString();
        if (jourLettre.equals("1"))
            jourLettre = "Lundi";
        if (jourLettre.equals("2"))
            jourLettre = "Mardi";
        if (jourLettre.equals("3"))
            jourLettre = "Mercredi";
        if (jourLettre.equals("4"))
            jourLettre = "Jeudi";
        if (jourLettre.equals("5"))
            jourLettre = "Vendredi";
        if (jourLettre.equals("6"))
            jourLettre = "Samedi";
        if (jourLettre.equals("7"))
            jourLettre = "Dimanche";

        return jourLettre + " de " + heureDebut.substring(11 ,16) + " à " + heureFin.substring(11,16);
    }
}
