package fr.cs.giteapirest.dao;


import fr.cs.giteapirest.metier.Equipement;
import fr.cs.giteapirest.metier.EquipementGite;
import fr.cs.giteapirest.metier.Gite;
import fr.cs.giteapirest.metier.TypeEquipement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipementGiteDAO extends DAO<EquipementGite,EquipementGite>{
    protected EquipementGiteDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public EquipementGite getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<EquipementGite> getAll() {
        return null;
    }

    @Override
    public ArrayList<EquipementGite> getLike(EquipementGite objet) {
        return null;
    }

    @Override
    public boolean insert(EquipementGite equipementGite) {
        String Statement  = "insert into EQUIPEMENT_GITE ( ID_GITE,ID_EQUIPEMENT,PRIX_EQUIPEMENT) values (?, ?, ?)";
        try(PreparedStatement pStmt = this.connexion.prepareStatement(Statement)){
            pStmt.setInt(1, equipementGite.getIdGite());
            pStmt.setInt(2, equipementGite.getIdEquipement());
            pStmt.setFloat(3, equipementGite.getPrix());
            pStmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean update(EquipementGite object) {
        return false;
    }

    public boolean updatePrix(EquipementGite equipementGite) {
        String Statement = "update EQUIPEMENT_GITE set PRIX_EQUIPEMENT = ? where ID_EQUIPEMENT = ? and ID_GITE = ?";
        try(PreparedStatement pSmt = connexion.prepareStatement(Statement)) {
            pSmt.setFloat(1, equipementGite.getPrix());
            pSmt.setInt(2,equipementGite.getIdEquipement());
            pSmt.setInt(3, equipementGite.getIdGite());

            pSmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
       return true;
    }


    @Override
    public boolean delete(EquipementGite equipementGite) {
        String Statement = "delete from EQUIPEMENT_GITE where ID_GITE = ?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            pStmt.setInt(1, equipementGite.getIdEquipement());
            pStmt.setInt(2, equipementGite.getIdGite());
            pStmt.execute();
            return true;

        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean deleteByIdGite(int idGite) {
        String Statement = "delete from EQUIPEMENT_GITE where ID_GITE = ?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            pStmt.setInt(1, idGite);

            pStmt.execute();
            return true;

        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList getListEquipementGiteByIdGite(int idGite){
        ArrayList<EquipementGite> liste = new ArrayList<>();
        ResultSet rs;
        try  {

            PreparedStatement pStmt = connexion
                    .prepareStatement("select EG.*,E.LIBELLE_EQUIPEMENT,TE.* from EQUIPEMENT_GITE AS EG\n" +
                            "join EQUIPEMENT as E on E.ID_EQUIPEMENT = EG.ID_EQUIPEMENT\n" +
                            "join TYPE_EQUIPEMENT as TE on TE.ID_TYPE_EQUIPEMENT = E.ID_TYPE_EQUIPEMENT\n" +
                            "WHERE ID_GITE = ?");
            // Determine the column set column

            pStmt.setInt(1, idGite);
            rs = pStmt.executeQuery();

            while (rs.next()) {

                EquipementGite eg = new EquipementGite();
                Equipement equipement = new Equipement();
                TypeEquipement typeEquipement = new TypeEquipement();

                typeEquipement.setId(rs.getInt(5));
                typeEquipement.setLibelle(rs.getString(6));

                equipement.setTypeEquipement(typeEquipement);
                equipement.setIdTypeEquipement(rs.getInt(5));
                equipement.setId(rs.getInt(2));
                equipement.setLibelle(rs.getString(4));

                eg.setEquipement(equipement);
                eg.setIdGite(rs.getInt(1));
                eg.setPrix(rs.getFloat(3));
                eg.setIdEquipement(rs.getInt(2));



                liste.add(eg);

            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }


    public ArrayList<EquipementGite> getListEquipementByGite(Gite gite) {
        ArrayList<EquipementGite> liste = new ArrayList<>();
        ResultSet rs;
        try  {

            PreparedStatement pStmt = connexion
                    .prepareStatement("select EG.*,E.LIBELLE_EQUIPEMENT,TE.* from EQUIPEMENT_GITE AS EG\n" +
                            "join EQUIPEMENT as E on E.ID_EQUIPEMENT = EG.ID_EQUIPEMENT\n" +
                            "join TYPE_EQUIPEMENT as TE on TE.ID_TYPE_EQUIPEMENT = E.ID_TYPE_EQUIPEMENT\n" +
                            "WHERE ID_GITE = "+ gite.getId());
            // Determine the column set column

            rs = pStmt.executeQuery();

            while (rs.next()) {

                EquipementGite eg = new EquipementGite();
                Equipement equipement = new Equipement();
                TypeEquipement typeEquipement = new TypeEquipement();

                typeEquipement.setId(rs.getInt(5));
                typeEquipement.setLibelle(rs.getString(6));

                equipement.setTypeEquipement(typeEquipement);
                equipement.setIdTypeEquipement(rs.getInt(5));
                equipement.setId(rs.getInt(2));
                equipement.setLibelle(rs.getString(4));

                eg.setEquipement(equipement);
                eg.setIdGite(rs.getInt(1));
                eg.setPrix(rs.getFloat(3));
                eg.setIdEquipement(rs.getInt(2));



                liste.add(eg);

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