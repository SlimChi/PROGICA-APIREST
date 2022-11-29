package fr.cs.giteapirest.dao;


import fr.cs.giteapirest.metier.Saison;
import fr.cs.giteapirest.metier.SaisonGite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaisonGiteDAO extends DAO<SaisonGite, SaisonGite> {
    protected SaisonGiteDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public SaisonGite getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<SaisonGite> getAll() {
        return null;
    }

    @Override
    public ArrayList<SaisonGite> getLike(SaisonGite objet) {
        return null;
    }

    @Override
    public boolean insert(SaisonGite saisonGite) {

        String Statement = "insert into SAISON_GITE (ID_GITE,ID_SAISON,PRIX_LOCATION) VALUES (?,?,?)";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {


            pStmt.setInt(1, saisonGite.getIdGite());
            pStmt.setInt(2, saisonGite.getIdSaison());
            pStmt.setFloat(3, saisonGite.getPrix());

            pStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

        return true;
    }

    @Override
    public boolean update(SaisonGite saisonGite) {
        String Statement = "update SAISON_GITE set PRIX_LOCATION = ? where ID_GITE=? and ID_SAISON=?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {

            pStmt.setFloat(1, saisonGite.getPrix());
            pStmt.setInt(2, saisonGite.getIdGite());
            pStmt.setInt(3, saisonGite.getIdSaison());




            pStmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(SaisonGite saisonGite) {

        String Statement = "delete from SAISON_GITE where ID_GITE";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            pStmt.setInt(1, saisonGite.getIdGite());
            pStmt.setInt(2, saisonGite.getIdSaison());
            pStmt.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deletebyIdGite(int idGite) {

        String Statement = "delete from SAISON_GITE where ID_GITE =?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            pStmt.setInt(1, idGite);

            pStmt.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList getSaisonGiteByIdGite(int idGite) {
        ArrayList<SaisonGite> liste = new ArrayList<>();
        ResultSet rs;
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("select SG.*,S.LIBELLE_SAISON from SAISON_GITE AS SG\n" +
                            "join SAISON as S on S.ID_SAISON = SG.ID_SAISON WHERE ID_GITE = ?");
            // Determine the column set column

            pStmt.setInt(1, idGite);
            rs = pStmt.executeQuery();

            while (rs.next()) {

                SaisonGite saisonGite = new SaisonGite();
                Saison saison = new Saison();

                saison.setId(rs.getInt(2));
                saison.setLibelle(rs.getString(4));

                saisonGite.setSaison(saison);
                saisonGite.setIdGite(rs.getInt(1));
                saisonGite.setIdSaison(rs.getInt(rs.getInt(2)));
                saisonGite.setPrix(rs.getFloat(3));


                liste.add(saisonGite);

            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;

    }


}