package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Localite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocaliteDAO extends  DAO<Localite, Localite>{

    public LocaliteDAO(Connection connexion)
    {
        super(connexion);
    }

    @Override
    public Localite getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Localite> getAll() {
        return null;
    }

    @Override
    public ArrayList<Localite> getLike(Localite objet) {
        return null;
    }

    @Override
    public boolean insert(Localite localite) {
        String Statement = "insert into LOCALITE (LIBELLE_LOCALITE) values (?)";
        try ( PreparedStatement pStmt = connexion.prepareStatement(Statement)) {
            pStmt.setString(1, localite.getLibelle());

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public boolean update(Localite object) {
        return false;
    }

    public boolean updateLibelleLocalite(Localite localite) {
        String Statement = "update LOCALITE set LIBELLE_LOCALITE = ? where ID_LOCALITE = ?";

        try(PreparedStatement pStmt = connexion.prepareStatement(Statement)) {

            pStmt.setString(1, localite.getLibelle());
            pStmt.setInt(2, localite.getId());
            pStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Localite object) {
        return false;
    }


}
