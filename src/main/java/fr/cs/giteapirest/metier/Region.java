package fr.cs.giteapirest.metier;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Region {

    private int id;

    private String nom;

    @JsonIgnore
    private ArrayList<Departement> departement;

    public Region() {

    }

    public Region(int id, String nom) {
        this.id = id;
        this.nom = nom;
        departement = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }

    public ArrayList<Departement> getDepartement() {
        return departement;
    }

    public void setDepartement(ArrayList<Departement> departement) {
        this.departement = departement;
    }
}
