package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.TypeEquipement;

import java.sql.Connection;
import java.util.ArrayList;

public class TypeEquipementDAO extends DAO <TypeEquipement,TypeEquipement>{
    protected TypeEquipementDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public TypeEquipement getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<TypeEquipement> getAll() {
        return null;
    }

    @Override
    public ArrayList<TypeEquipement> getLike(TypeEquipement objet) {
        return null;
    }

    @Override
    public boolean insert(TypeEquipement objet) {
        return false;
    }

    @Override
    public boolean update(TypeEquipement object) {
        return false;
    }

    @Override
    public boolean delete(TypeEquipement object) {
        return false;
    }


}
