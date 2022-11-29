package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Disponibilite;
import fr.cs.giteapirest.metier.Mail;
import fr.cs.giteapirest.metier.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisponibiliteDAO extends DAO<Disponibilite,Disponibilite>{
    protected DisponibiliteDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Disponibilite getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Disponibilite> getAll() {
        return null;
    }

    @Override
    public ArrayList<Disponibilite> getLike(Disponibilite objet) {
        return null;
    }


    @Override
    public boolean insert(Disponibilite disponibilite) {
        String Statement = "insert into DISPONIBILITE (JOUR, HEURE_DEBUT, HEURE_FIN, ID_PERSONNE) values (?, ?, ?, ? )";
        try(PreparedStatement pStmt = this.connexion.prepareStatement(Statement)) {
            if (disponibilite != null){
                pStmt.setInt(1, disponibilite.getJour());
                pStmt.setString(2, disponibilite.getHeureDebut());
                pStmt.setString(3, disponibilite.getHeureFin());
                pStmt.setInt(4,disponibilite.getPersonne().getId());

            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public boolean update(Disponibilite disponibilite) {
        String Statement = "update DISPONIBILITE set jour = ? , HEURE_DEBUT = ?, HEURE_FIN = ? where ID_DISPONIBILITE = ?";

        try (PreparedStatement pSmt = connexion.prepareStatement(Statement)) {

            pSmt.setInt(1, disponibilite.getJour());
            pSmt.setString(2, disponibilite.getHeureDebut());
            pSmt.setString(3, disponibilite.getHeureFin());
            pSmt.setInt(4,disponibilite.getId());
            pSmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Disponibilite disponibilite) {
        String Statement = "delete from DISPONIBILITE where ID_DISPONIBILITE = ?";
        try(PreparedStatement pStmt = this.connexion.prepareStatement(Statement)){
            pStmt.setInt(1, disponibilite.getId());
            pStmt.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList getDisponibiliteByIdGerant(int idGerant){
        ArrayList <Disponibilite> liste = new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement pStmt = connexion.prepareStatement("select d.*, p.NOM_PERSONNE, p.PRENOM_PERSONNE,m.ID_MAIL\n" +
                    "from DISPONIBILITE as d join PERSONNE as p \n" +
                    "on p.ID_PERSONNE=d.ID_PERSONNE\n" +
                    "join MAIL as m \n" +
                    "on m.ID_MAIL=p.ID_MAIL\n" +
                    "where d.ID_PERSONNE = ? order by JOUR");
            pStmt.setInt(1, idGerant);
            rs = pStmt.executeQuery();

            while (rs.next()) {
                Disponibilite disponibilite = new Disponibilite();

                disponibilite.setId(rs.getInt(1));
                disponibilite.setJour(rs.getInt(2));
                disponibilite.setHeureDebut(rs.getString(3));
                disponibilite.setHeureFin(rs.getString(4));

                Personne personne = new Personne();

                personne.setId(rs.getInt(5));
                personne.setNom(rs.getString(6));
                personne.setPrenom(rs.getString(7));

                Mail mail = new Mail();
                mail.setId(rs.getString(8));

                personne.setMail(mail);
                disponibilite.setPersonne(personne);


                liste.add(disponibilite);

            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

}
