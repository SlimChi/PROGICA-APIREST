package fr.cs.giteapirest.service;


import fr.cs.giteapirest.metier.*;

public class GiteSearch {

    private int id;
    private String nomDuGite;

    private Equipement equipement;

    private TypeEquipement typeEquipement;

    private Ville ville;

    private Departement departement;

    private String idDepartement;

    private int nbDepartement;

    private Region region;

    private String idRegion;

    private int nbRegion;

    private String idEquipements;

    private int nbEquipements;

    public GiteSearch(){
        equipement = new Equipement();
        typeEquipement = new TypeEquipement();
        ville = new Ville();
        departement = new Departement();
        region = new Region();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDuGite() {
        return nomDuGite;
    }

    public void setNomDuGite(String nomDuGite) {
        this.nomDuGite = nomDuGite;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public TypeEquipement getTypeEquipement() {
        return typeEquipement;
    }

    public void setTypeEquipement(TypeEquipement typeEquipement) {
        this.typeEquipement = typeEquipement;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {

        this.ville = ville;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getIdEquipements() {
        return idEquipements;
    }

    public void setIdEquipements(String idEquipements) {
        this.idEquipements = idEquipements;
    }

    public int getNbEquipements() {
        return nbEquipements;
    }

    public void setNbEquipements(int nbEquipements) {
        this.nbEquipements = nbEquipements;
    }

    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    public int getNbRegion() {
        return nbRegion;
    }

    public void setNbRegion(int nbRegion) {
        this.nbRegion = nbRegion;
    }

    public String getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(String idDepartement) {
        this.idDepartement = idDepartement;
    }

    public int getNbDepartement() {
        return nbDepartement;
    }

    public void setNbDepartement(int nbDepartement) {
        this.nbDepartement = nbDepartement;
    }
}