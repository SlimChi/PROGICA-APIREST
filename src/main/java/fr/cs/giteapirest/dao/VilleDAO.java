package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Region;
import fr.cs.giteapirest.metier.Ville;
import fr.cs.giteapirest.service.VilleSearch;

import java.sql.*;
import java.util.ArrayList;

public class VilleDAO extends DAO<Ville, VilleSearch> {
    public VilleDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Ville getByID(int id) {
        return null;


    }

    @Override
    public ArrayList<Ville> getAll() {
       ArrayList<Ville> liste =new ArrayList<>();
       try (Statement stmt = connexion.createStatement()){

           String strCmd = "select * from ville as v join DEPARTEMENT as d on d.CODE_INSEE_DEPT = v.CODE_INSEE_DEPT ";
           ResultSet rs = stmt.executeQuery(strCmd);

           while (rs.next()){
             Departement departement =new Departement();
             departement.setCodeInseeDept(rs.getString(1));
             Ville ville = new Ville(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5),rs.getString(7));
             ville.setDepartement(departement);

             liste.add(ville);

           }rs.close();

       } catch (Exception e) {
           e.printStackTrace();
       }
       return liste;
    }

    @Override
    public ArrayList<Ville> getLike(VilleSearch objet) {

        ResultSet rs;
        ArrayList<Ville> liste = new ArrayList<>();
        String procedureStockee = "{call SP_VILLE_QBE(?,?)}";

        try (CallableStatement cStmt = this.connexion.prepareCall(procedureStockee)) {

            cStmt.setString(1,objet.getNom());
            cStmt.setString(2,objet.getIdDepartement());


            cStmt.execute();
            rs = cStmt.getResultSet();

            while (rs.next()) {

                Ville ville = new Ville();
                ville.setCodeInseeDept(rs.getString(1));
                ville.setCodeInsee(rs.getString(2));
                ville.setNom(rs.getString(3));
                ville.setLatitude(rs.getFloat(4));
                ville.setLongitude(rs.getFloat(5));

                liste.add(ville);

            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }



    @Override
    public boolean insert(Ville objet) {
        return false;
    }

    @Override
    public boolean update(Ville object) {
        return false;
    }

    @Override
    public boolean delete(Ville object) {
        return false;
    }

    public Ville getVilleByCodeInsee(String codeInseeDept, String codeInsee) {
        Ville ville = new Ville();
        ResultSet rs;

        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement(" SELECT NOM_VILLE, LATITUDE, LONGITUDE, D.CODE_INSEE_DEPT, CODE_INSEE,D.NOM_DEPARTEMENT,R.ID_REGION,R.NOM_REGION FROM VILLE as V \n" +
                            "                    join DEPARTEMENT as D on D.CODE_INSEE_DEPT = V.CODE_INSEE_DEPT\n" +
                            "                    join REGION as R on R.ID_REGION = D.ID_REGION\n" +
                            "\t\t\t\t\tWHERE V.CODE_INSEE_DEPT = ? and V.CODE_INSEE=?\n" +
                            "                    order by NOM_VILLE;");
            // Determine the column set column

            pStmt.setString(1, codeInseeDept);
            pStmt.setString(2, codeInsee);


            rs = pStmt.executeQuery();

            while (rs.next()) {


                Region region = new Region();
                region.setId(rs.getInt(7));
                region.setNom(rs.getString(8));

                Departement departement = new Departement();
                departement.setCodeInseeDept(rs.getString(4));
                departement.setNomDepartement(rs.getString(6));
                departement.setRegion(region);


                ville.setNom(rs.getString(1));
                ville.setLatitude(rs.getFloat(2));
                ville.setLongitude(rs.getFloat(3));
                ville.setCodeInseeDept(rs.getString(4));
                ville.setCodeInsee(rs.getString(5));
                ville.setDepartement(departement);



            }
            rs.close();
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return ville;
    }


}
