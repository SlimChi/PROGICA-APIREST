package fr.cs.giteapirest.dao;



import fr.cs.giteapirest.metier.Personne;

import java.sql.*;
import java.util.ArrayList;

public class PersonneDAO extends DAO<Personne, Personne> {
    public PersonneDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Personne getByID(int id) {
        Personne personne = new Personne();
        ResultSet rs;
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement(" select * from PERSONNE where ID_PERSONNE = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();

            while (rs.next()) {

                personne.setId(rs.getInt(1));
                personne.setNom(rs.getString(2));
                personne.setPrenom(rs.getString(3));
                personne.setCodeAderent(rs.getString(4));
                personne.setIdMail(rs.getString(5));


            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return personne;
    }

    @Override
    public ArrayList<Personne> getAll() {
        return null;
    }

    @Override
    public ArrayList<Personne> getLike(Personne objet) {
        return null;
    }

    @Override
    public boolean insert(Personne personne) {
        String Statement = "insert into PERSONNE (NOM_PERSONNE, PRENOM_PERSONNE, CODE_ADERENT,ID_MAIL) values ( ?, ?,?,? )";
        try (PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            if (personne != null) {

                pStmt.setString(1, personne.getNom());
                pStmt.setString(2, personne.getPrenom());
                pStmt.setString(3, personne.getCodeAderent());
                pStmt.setString(4, personne.getIdMail());

                pStmt.execute();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Personne object) {
        return false;
    }

    @Override
    public boolean delete(Personne personne) {
        String Statement = "delete from PERSONNE where ID_PERSONNE = ?";
        try (PreparedStatement pSmt = connexion.prepareStatement(Statement)) {
            pSmt.setInt(1, personne.getId());

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public int getIdPersonneByCodeAderent(String codeAderent) {


        int idPersonne = 0;
        ResultSet rs;
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement(" select * from PERSONNE where CODE_ADERENT = ?");
            // Determine the column set column

            pStmt.setString(1, codeAderent);
            rs = pStmt.executeQuery();

            while (rs.next()) {

                idPersonne = rs.getInt(1);


            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }


        return idPersonne;
    }


    public int getIdPersonneByMail(String mail) {
        int idPersonne = 0;
        ResultSet rs;
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement(" select * from PERSONNE where ID_MAIL = ?");
            // Determine the column set column

            pStmt.setString(1, mail);
            rs = pStmt.executeQuery();

            while (rs.next()) {

                idPersonne = rs.getInt(1);


            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }


        return idPersonne;
    }


    public int getMaxIdPersonne(){


        try (Statement stmt = connexion.createStatement()) {

            // Determine the column set column

            String strCmd = "select max(id_personne) from personne";

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