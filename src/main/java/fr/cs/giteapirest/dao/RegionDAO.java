package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Region;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class RegionDAO extends DAO <Region, Region>
{
    public RegionDAO(Connection connexion)
    {
        super(connexion);
    }

    @Override
    public Region getByID(int id) {

        return null;
    }

    @Override
    public ArrayList<Region> getAll() {
        ArrayList<Region> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {

            String strCmd = "SELECT R.id_region,nom_region ,code_insee_dept,nom_departement from REGION as R join DEPARTEMENT on R.id_region=DEPARTEMENT.ID_REGION order by nom_region,NOM_DEPARTEMENT";
            ResultSet rs = stmt.executeQuery(strCmd);
            Region regionLu = new Region(0,"");
            while (rs.next()){
                if (regionLu.getId() != rs.getInt(1))
                {
                    regionLu = new Region(rs.getInt(1), rs.getString(2));
                    liste.add(regionLu);
                }
                regionLu.getDepartement().add(new Departement(rs.getString(3),rs.getString(4)));
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public ArrayList<Region> getLike(Region objet) {
        return null;
    }

    @Override
    public boolean insert(Region objet) {
        return false;
    }

    @Override
    public boolean update(Region object) {
        return false;
    }

    @Override
    public boolean delete(Region object) {
        return false;
    }

}
