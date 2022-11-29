package fr.cs.giteapirest.metier;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ville {

    private String nom;

    private Float latitude;

    private Float longitude;

    private String codeInseeDept;

    private String codeInsee;

    @JsonIgnore
    private Departement departement;


    public Ville(){

    }

    public Ville(String codeInsee,String nom,Float latitude, Float longitude, String codeInseeDept) {

        this.codeInsee = codeInsee;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.codeInseeDept = codeInseeDept;
    }

    public Ville(String codeInsee,String nom,Float latitude, Float longitude, Departement departement) {

        this.codeInsee = codeInsee;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.departement = departement;
    }



    public String getNom() {
        return nom;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getCodeInseeDept() {
        return codeInseeDept;
    }

    public void setCodeInseeDept(String codeInseeDept) {
        this.codeInseeDept = codeInseeDept;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return nom;
    }
}
