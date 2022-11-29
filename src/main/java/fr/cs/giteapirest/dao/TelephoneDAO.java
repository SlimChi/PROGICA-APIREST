package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Telephone;
import fr.cs.giteapirest.metier.TypeTelephone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelephoneDAO extends DAO<Telephone, Telephone> {
    protected TelephoneDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Telephone getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Telephone> getAll() {
        return null;
    }

    @Override
    public ArrayList<Telephone> getLike(Telephone objet) {
        return null;
    }

    @Override
    public boolean insert(Telephone telephone) {
        String Statement = "insert into TELEPHONE (NUM_TEL, ID_PERSONNE, ID_TYPE_TELEPHONE) values (?, ?, ? )";
        try(PreparedStatement pStmt = this.connexion.prepareStatement(Statement)){

                pStmt.setString(1, telephone.getId());
                pStmt.setInt(2, telephone.getIdPersonne());
                pStmt.setInt(3,telephone.getIdTypeTelephone());

              pStmt.execute();




        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


        return  true;
    }

    @Override
    public boolean update(Telephone object) {
        return false;
    }

    public boolean updateNumTel(Telephone numActuel, Telephone nouveauNum) {
        String Statement = " update TELEPHONE set NUM_TEL = ? where NUM_TEL = ?";
        try (PreparedStatement pSmt = connexion.prepareStatement(Statement)) {
            pSmt.setString(1, nouveauNum.getId());
            pSmt.setString(2,numActuel.getId());
            pSmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Telephone telephone) {
        String Statement = "DELETE FROM TELEPHONE WHERE NUM_TEL = ?";
        try(PreparedStatement pStmt = this.connexion.prepareStatement(Statement)){
            pStmt.setString(1, telephone.getId());
            pStmt.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }



    }

    public ArrayList getTelephonesByIdPersonne(int id){

        ArrayList<Telephone> liste = new ArrayList<>();
        ResultSet rs;
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("select T.*,TE.LIBELLE_TYPE_TELEPHONE from TELEPHONE  as T\n" +
                            "join TYPE_TELEPHONE as TE on TE.ID_TYPE_TELEPHONE = T.ID_TYPE_TELEPHONE\n" +
                            "where ID_PERSONNE = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();

            while (rs.next()) {

                Telephone telephone = new Telephone();
                TypeTelephone typeTelephone = new TypeTelephone();
                typeTelephone.setId(rs.getInt(3));
                typeTelephone.setLibelle(rs.getString(4));

                telephone.setId(rs.getString(1));
                telephone.setTypeTelephone(typeTelephone);

                liste.add(telephone);
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
