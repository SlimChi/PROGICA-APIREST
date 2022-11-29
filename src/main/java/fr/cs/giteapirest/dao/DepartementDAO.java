package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartementDAO extends DAO<Departement,Departement> {

    protected DepartementDAO(Connection connexion) {
        super(connexion);
    }
    private ResultSet rs;
    @Override
    public Departement getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Departement> getAll() {

        ArrayList<Departement> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()){

            String strCmd ="SELECT CODE_INSEE_DEPT,NOM_DEPARTEMENT,D.ID_REGION, (select R.NOM_REGION from REGION as R where R.ID_REGION = D.ID_REGION) from DEPARTEMENT as D order by NOM_DEPARTEMENT";
            rs = stmt.executeQuery(strCmd);
            while (rs.next()){
            liste.add(new Departement(rs.getString(1), rs.getString(2), new Region(rs.getInt(3),rs.getString(4))));

            }rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Departement> getByRegion(int region) {
        ArrayList<Departement> liste = new ArrayList<>();
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT code_insee_dept,nom_departement from DEPARTEMENT where ID_REGION =  ?  order by NOM_DEPARTEMENT");
            // Determine the column set column

            pStmt.setInt(1, region);
            rs = pStmt.executeQuery();

            while (rs.next()) {
                liste.add(new Departement(rs.getString(1), rs.getString(2)));
            }
            rs.close();
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public ArrayList<Departement> getLike(Departement objet) {
        return null;
    }

    @Override
    public boolean insert(Departement objet) {
        return false;
    }

    @Override
    public boolean update(Departement object) {
        return false;
    }

    @Override
    public boolean delete(Departement object) {
        return false;
    }


}
