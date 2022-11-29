package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.TypeTelephone;

import java.sql.Connection;
import java.util.ArrayList;

public class TypeTelephoneDAO extends DAO<TypeTelephone, TypeTelephone> {
    public TypeTelephoneDAO(Connection connexion)
    {
        super(connexion);
    }

    @Override
    public TypeTelephone getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<TypeTelephone> getAll() {
        return null;
    }

    @Override
    public ArrayList<TypeTelephone> getLike(TypeTelephone objet) {
        return null;
    }

    @Override
    public boolean insert(TypeTelephone objet) {
        return false;
    }

    @Override
    public boolean update(TypeTelephone object) {
        return false;
    }

    @Override
    public boolean delete(TypeTelephone object) {
        return false;
    }




}
