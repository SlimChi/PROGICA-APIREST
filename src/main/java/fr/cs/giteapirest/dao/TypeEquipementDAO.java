package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Departement;
import fr.cs.giteapirest.metier.Equipement;
import fr.cs.giteapirest.metier.Region;
import fr.cs.giteapirest.metier.TypeEquipement;

import java.sql.*;
import java.util.ArrayList;

public class TypeEquipementDAO extends DAO <TypeEquipement,TypeEquipement>{
    protected TypeEquipementDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public TypeEquipement getByID(int id) {
        TypeEquipement typeEquipement = new TypeEquipement();
        ResultSet rs;

        try {

            PreparedStatement pStmt = connexion.prepareStatement("SELECT * FROM TYPE_EQUIPEMENT WHERE ID_TYPE_EQUIPEMENT = ?");
            pStmt.setInt(1,id);
            rs = pStmt.executeQuery();
            while(rs.next()){

                typeEquipement.setId(rs.getInt(1));
                typeEquipement.setLibelle(rs.getString(2));

            }
            rs.close();


        }    catch (SQLException e) {
            e.printStackTrace();

        }

        return typeEquipement;
    }

    @Override
    public ArrayList<TypeEquipement> getAll() {
        ArrayList<TypeEquipement> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {

            // Determine the column set column

            String strCmd = "select * from TYPE_EQUIPEMENT";

            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

               TypeEquipement typeEquipement = new TypeEquipement();
                typeEquipement.setId(rs.getInt(1));
                typeEquipement.setLibelle(rs.getString(2));


                liste.add(typeEquipement);

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
    public ArrayList<TypeEquipement> getLike(TypeEquipement objet) {
        return null;
    }

    @Override
    public boolean insert(TypeEquipement typeEquipement) {

       try
       {
           PreparedStatement pstmt = connexion.prepareStatement("insert into TYPE_EQUIPEMENT (LIBELLE_TYPE_EQUIPEMENT) values (?);");

           pstmt.setString(1,typeEquipement.getLibelle());
           pstmt.executeUpdate();

           return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public boolean update(TypeEquipement typeEquipement) {

        try{
            PreparedStatement pStmt = connexion.prepareStatement("update TYPE_EQUIPEMENT set LIBELLE_TYPE_EQUIPEMENT = ? where ID_TYPE_EQUIPEMENT = ?");

            pStmt.setString(1, typeEquipement.getLibelle());
            pStmt.setInt(2,typeEquipement.getId());

            pStmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(TypeEquipement typeEquipement) {

        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement(" delete from TYPE_EQUIPEMENT where ID_TYPE_EQUIPEMENT = ?");
            // Determine the column set column

            pStmt.setInt(1,typeEquipement.getId());

            //pStmt.executeQuery();
            pStmt.executeUpdate();


            return true;
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }


}
