package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Saison;

import java.sql.Connection;
import java.util.ArrayList;

public class SaisonDAO extends DAO<Saison, Saison > {
    public SaisonDAO(Connection connexion)
    {
        super(connexion);
    }

    @Override
    public Saison getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Saison> getAll() {
        return null;
    }

    @Override
    public ArrayList<Saison> getLike(Saison objet) {
        return null;
    }

    @Override
    public boolean insert(Saison objet) {
        return false;
    }

    @Override
    public boolean update(Saison object) {
        return false;
    }

    @Override
    public boolean delete(Saison object) {
        return false;
    }

}
