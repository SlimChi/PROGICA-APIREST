package fr.cs.giteapirest.metier;



import java.util.Objects;

public class Equipement {

    private int id;

    private String libelle;

    private int idTypeEquipement;

    private TypeEquipement typeEquipement;

    public Equipement(){


    }
    public Equipement(int id,String libelle,TypeEquipement typeEquipement){

        this.id = id;
        this.libelle = libelle;
        this.typeEquipement = typeEquipement;

    }

    public Equipement(int id,String libelle,int idTypeEquipement){
        this.id=id;
        this.libelle=libelle;
        this.idTypeEquipement=idTypeEquipement;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getIdTypeEquipement() {
        return idTypeEquipement;
    }

    public void setIdTypeEquipement(int idTypeEquipement) {
        this.idTypeEquipement = idTypeEquipement;
    }

    public TypeEquipement getTypeEquipement() {
        return typeEquipement;
    }

    public void setTypeEquipement(TypeEquipement typeEquipement) {
        this.typeEquipement = typeEquipement;
    }

    @Override
    public String toString() {
        return  libelle ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipement that = (Equipement) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle, id, idTypeEquipement);
    }
}
