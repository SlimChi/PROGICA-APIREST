package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Region;
import fr.cs.giteapirest.metier.TypeEquipement;

import java.sql.*;
import java.util.ArrayList;



public class RegionDAO extends DAO <Region, Region>
{
    public RegionDAO(Connection connexion)
    {
        super(connexion);
    }

    @Override
    public Region getByID(int id) {

        Region region = new Region();
        ResultSet rs;

        try {

            PreparedStatement pStmt = connexion.prepareStatement("select * from REGION where ID_REGION = ?");
            pStmt.setInt(1,id);
            rs = pStmt.executeQuery();
            while(rs.next()){

                region.setId(rs.getInt(1));
                region.setNom(rs.getString(2));

            }
            rs.close();


        }    catch (SQLException e) {
            e.printStackTrace();

        }

        return region;
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
//        String Statement = "insert into EQUIPEMENT ( LIBELLE_EQUIPEMENT, ID_TYPE_EQUIPEMENT) values ( ?, ?)";
//        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
//            if (equipement != null){
//                pStmt.setString(1, equipement.getLibelle());
//                pStmt.setInt(2, equipement.getTypeEquipement().getId());
//                pStmt.execute();
//            }
//            return true;
//
//        }    catch (SQLException e) {
//            e.printStackTrace();
            return false;
//        }
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
