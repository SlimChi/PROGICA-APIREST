package fr.cs.giteapirest.dao;


import fr.cs.giteapirest.metier.*;
import fr.cs.giteapirest.service.GiteSearch;

import java.sql.*;
import java.util.ArrayList;

public class GiteDAO extends DAO<Gite, GiteSearch> {
    protected GiteDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Gite getByID(int id) {

        Gite gite = new Gite();
        ResultSet rs;

        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT * FROM GITE WHERE ID_GITE = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();

            while (rs.next()) {


                gite.setId(rs.getInt(1));
                gite.setNom(rs.getString(2));
                gite.setNombreChambre(rs.getInt(3));
                gite.setNombreCouchage(rs.getInt(4));
                gite.setSurfaceHabitable(rs.getInt(5));
                gite.setAdresse(rs.getString(6));
                gite.setIdPersonne(rs.getInt(7));
                gite.setIdPersonneGerant(rs.getInt(8));
                gite.setCodeInseeDept(rs.getString(9));
                gite.setCodeInsee(rs.getString(10));


            }
            rs.close();
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return gite;
    }

    @Override
    public ArrayList<Gite> getAll() {
        return null;
    }


    @Override
    public ArrayList<Gite> getLike(GiteSearch giteSearch) {

        ResultSet rs;
        ArrayList<Gite> liste = new ArrayList<>();
        String procedureStockee = "{call SP_GITE_QBE(?,?,?,?,?,?,?)}";

        try (CallableStatement cStmt = this.connexion.prepareCall(procedureStockee)) {


            cStmt.setString(1, giteSearch.getIdEquipements());
            cStmt.setInt(2, giteSearch.getNbEquipements());
            cStmt.setString(3, giteSearch.getIdRegion());
            cStmt.setInt(4,giteSearch.getNbRegion());
            cStmt.setString(5, giteSearch.getIdDepartement());
            cStmt.setInt(6,giteSearch.getNbDepartement());
            cStmt.setString(7,giteSearch.getVille().getCodeInsee());

            cStmt.execute();
            rs = cStmt.getResultSet();

            while (rs.next()) {

                Gite gite = new Gite();

                gite.setId(rs.getInt(1));
                gite.setNom(rs.getString(2));
                gite.setNombreCouchage(rs.getInt(5));

                Ville ville = new Ville();
                ville.setNom(rs.getString(3));

                Departement departement = new Departement();
                departement.setNomDepartement(rs.getString(4));

                ville.setDepartement(departement);
                gite.setVille(ville);

               gite.setPrixToShow(rs.getFloat(6));



                liste.add(gite);


            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public boolean insert(Gite gite) {
        String Statement = "insert into GITE (NOM_GITE,NBR_CHAMBRE,NBR_COUCHAGE,SURFACE_HABITABLE,ADRESSE_GITE,ID_PERSONNE,ID_PERSONNE_GERANT_GITE,CODE_INSEE_DEPT,CODE_INSEE) values (?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {


            System.out.println(gite.getCodeInseeDept());
            System.out.println(gite.getCodeInsee());


            pStmt.setString(1, gite.getNom());
            pStmt.setInt(2, gite.getNombreChambre());
            pStmt.setInt(3, gite.getNombreCouchage());
            pStmt.setInt(4, gite.getSurfaceHabitable());
            pStmt.setString(5, gite.getAdresse());
            pStmt.setInt(6, gite.getIdPersonne());
            pStmt.setInt(7, gite.getIdPersonneGerant());
            pStmt.setString(8, gite.getCodeInseeDept());
            pStmt.setString(9, gite.getCodeInsee());

            pStmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public boolean update(Gite gite) {
        String Statement = "UPDATE GITE SET NOM_GITE =?, NBR_CHAMBRE=?, NBR_COUCHAGE=?,SURFACE_HABITABLE=?,ADRESSE_GITE =?, ID_PERSONNE =?,ID_PERSONNE_GERANT_GITE=?,CODE_INSEE_DEPT=?, CODE_INSEE =? WHERE ID_GITE =?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            pStmt.setString(1, gite.getNom());
            pStmt.setInt(2, gite.getNombreChambre());
            pStmt.setInt(3, gite.getNombreCouchage());
            pStmt.setInt(4, gite.getSurfaceHabitable());
            pStmt.setString(5, gite.getAdresse());
            pStmt.setInt(6, gite.getIdPersonne());
            pStmt.setInt(7, gite.getIdPersonneGerant());
            pStmt.setString(8, gite.getCodeInseeDept());
            pStmt.setString(9, gite.getCodeInsee());
            pStmt.setInt(10, gite.getId());

            pStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public ArrayList getAllEssential() {
        ArrayList<Gite> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {

            // Determine the column set column

            String strCmd = "select G.ID_GITE,G.NOM_GITE,G.NBR_COUCHAGE,V.NOM_VILLE,D.NOM_DEPARTEMENT from GITE as G\n" +
                    "join VILLE as V on V.CODE_INSEE = G.CODE_INSEE and V.CODE_INSEE_DEPT = G.CODE_INSEE_DEPT\n" +
                    "join DEPARTEMENT as D on D.CODE_INSEE_DEPT = V.CODE_INSEE_DEPT";

            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

                Departement departement = new Departement();
                Ville ville = new Ville();
                Gite gite = new Gite();

                departement.setNomDepartement(rs.getString(5));
                ville.setNom(rs.getString(4));
                ville.setDepartement(departement);

                gite.setVille(ville);
                gite.setId(rs.getInt(1));
                gite.setNom(rs.getString(2));
                gite.setNombreCouchage(rs.getInt(3));

                liste.add(gite);

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
    public boolean delete(Gite gite) {
        String Statement = "DELETE FROM GITE WHERE ID_GITE =? ";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            pStmt.setInt(1, gite.getId());
            pStmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

    }


    public boolean deleteGiteTransaction(Gite gite) throws SQLException {
        try {
            connexion.setAutoCommit(false);

            boolean a = DaoFactory.getSaisonGiteDAO().deletebyIdGite(gite.getId());
            boolean b = DaoFactory.getEquipementGiteDAO().deleteByIdGite(gite.getId());
            boolean c = delete(gite);

            if (!a || !b || !c)
                throw new SQLException("LE PLAN A ECHOUER");
            connexion.commit();

        } catch (SQLException e) {

            e.printStackTrace();

            connexion.rollback();
            connexion.setAutoCommit(true);

            return false;
        }

        connexion.setAutoCommit(true);
        return true;
    }

    public boolean forEquipement(Gite gite) {
        for (EquipementGite equipementGite : gite.getEquipementGites()) {

            boolean equipementExist =DaoFactory.getEquipementDAO().getEquipmentById(equipementGite.getEquipement().getId());
           // System.out.println("exist : "+equipementExist);

            if (!equipementExist) {

                DaoFactory.getEquipementDAO().insert(equipementGite.getEquipement());
            }


            boolean test = DaoFactory.getEquipementGiteDAO().insert(equipementGite);
            if (!test) {
                return false;
            }
        }
        return true;

    }

    public boolean ajoutDunEquipement(Equipement equipement){

        return false;
    }




    public boolean insertEquipementGiteTransaction(Gite gite) throws SQLException {

        try {
            connexion.setAutoCommit(false);
            boolean a = DaoFactory.getEquipementGiteDAO().deleteByIdGite(gite.getId());

            if (!a || !forEquipement(gite))
                throw new SQLException("LE PLAN A ECHOUER");
            connexion.commit();


        } catch (SQLException e) {

            e.printStackTrace();

            connexion.rollback();
            connexion.setAutoCommit(true);

            return false;
        }

        connexion.setAutoCommit(true);
        return true;
    }

     /*  System.out.println("ID du gite : "+gite.getId());
       //vrai ou faux = DaoFactory.getEquipementGiteDAO().deleteByIdGite(gite.getId());
        for(EquipementGite equipementGite : gite.getEquipementGites()){
           System.out.println(" LE ID : "+equipementGite.getIdEquipement()+" libelle: "+equipementGite.getEquipement().getLibelle()+" prix: "+
                    equipementGite.getPrix());
           //  vrai ou faux = DaoFactory.getEquipementGiteDAO().insert(equipementGite);

        }*/


    public int getMaxIdGite() {


        try (Statement stmt = connexion.createStatement()) {

            // Determine the column set column

            String strCmd = "select max(id_gite) from gite";

            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {


                System.out.println(rs.getInt(1));
                return rs.getInt(1);


            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }

        return 0;


    }


}