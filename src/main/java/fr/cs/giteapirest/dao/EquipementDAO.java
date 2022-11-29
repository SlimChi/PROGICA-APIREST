package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Equipement;
import fr.cs.giteapirest.metier.TypeEquipement;

import java.sql.*;
import java.util.ArrayList;

public class EquipementDAO extends DAO<Equipement,Equipement>{
    protected EquipementDAO(Connection connexion) {
        super(connexion);
    }


    @Override
    public Equipement getByID(int id) {
        System.out.println("getById");
        ResultSet rs;

        String Statement = "SELECT * FROM EQUIPEMENT WHERE ID_EQUIPEMENT = 30";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {


                //pStmt.setInt(1, id);
                rs = pStmt.executeQuery();

                System.out.println(rs);

                while(rs.next()){

                    System.out.println(rs.getInt(1));
                }



        }    catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    @Override
    public ArrayList<Equipement> getAll() {
        ArrayList<Equipement> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {

            // Determine the column set column

            String strCmd = "select * from equipement as e\n" +
                    "join TYPE_EQUIPEMENT as TE on TE.ID_TYPE_EQUIPEMENT = e.ID_TYPE_EQUIPEMENT";

            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

                TypeEquipement typeEquipement = new TypeEquipement();
                typeEquipement.setId(rs.getInt(3));
                typeEquipement.setLibelle(rs.getString(5));
                Equipement equipement = new Equipement(rs.getInt(1),rs.getString(2),rs.getInt(3));
                equipement.setTypeEquipement(typeEquipement);

                liste.add(equipement);

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
    public ArrayList<Equipement> getLike(Equipement objet) {
        return null;
    }

    @Override
    public boolean insert(Equipement equipement) {
        String Statement = "insert into EQUIPEMENT ( LIBELLE_EQUIPEMENT, ID_TYPE_EQUIPEMENT) values ( ?, ?)";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            if (equipement != null){
                pStmt.setString(1, equipement.getLibelle());
                pStmt.setInt(2, equipement.getTypeEquipement().getId());
                pStmt.execute();
            }
            return true;

        }    catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(Equipement object) {
        return false;
    }



    public boolean updateLibelleEquipment(Equipement nomActuelEquipement, Equipement nouveauNomEquipement) {

        String Statement = "update EQUIPEMENT set LIBELLE_EQUIPEMENT = ? where LIBELLE_EQUIPEMENT = ?";

        try(PreparedStatement pSmt = connexion.prepareStatement(Statement)) {

            pSmt.setString(1, nouveauNomEquipement.getLibelle());
            pSmt.setString(2, nomActuelEquipement.getLibelle());
            pSmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Equipement object) {
        return false;
    }


    public boolean getEquipmentById(int idEquipement){

        ResultSet rs;

        String Statement = "SELECT * FROM EQUIPEMENT WHERE ID_EQUIPEMENT = ?";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {


            pStmt.setInt(1, idEquipement);
            rs = pStmt.executeQuery();

            while(rs.next()){


                return true;
            }



        }    catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    public int getMaxIdEquipement(){

        try (Statement stmt = connexion.createStatement()) {

            // Determine the column set column

            String strCmd = "select max(id_equipement) from equipement";

            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

                //System.out.println(rs.getInt(1));
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
