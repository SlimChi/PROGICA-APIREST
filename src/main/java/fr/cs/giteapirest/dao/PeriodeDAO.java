package fr.cs.giteapirest.dao;



import fr.cs.giteapirest.metier.Periode;

import java.sql.Connection;
import java.util.ArrayList;

public class PeriodeDAO extends DAO<Periode, Periode>{

    public PeriodeDAO(Connection connexion)
    {
        super(connexion);
    }

    @Override
    public Periode getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Periode> getAll() {
        return null;
    }

    @Override
    public ArrayList<Periode> getLike(Periode objet) {
        return null;
    }

    @Override
    public boolean insert(Periode objet) {
        return false;
    }

    @Override
    public boolean update(Periode object) {
        return false;
    }

    @Override
    public boolean delete(Periode object) {
        return false;
    }


}
