package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MailDAO extends DAO<Mail,Mail>{
    protected MailDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Mail getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Mail> getAll() {
        return null;
    }

    @Override
    public ArrayList<Mail> getLike(Mail objet) {
        return null;
    }

    @Override
    public boolean insert(Mail mail){

        String Statement = "insert into MAIL (ID_MAIL) values (?)";
        try(PreparedStatement pStmt = this.connexion.prepareStatement(Statement)){
            if (mail != null){
                pStmt.setString(1, mail.getId());
                pStmt.execute();

            }
            return  true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(Mail object) {
        return false;
    }

    public boolean updateMail(Mail mailActuel, Mail nouveauMail ) {
        String Statement = " update MAIL set ID_MAIL = ? where ID_MAIL = ?";
        try(PreparedStatement pSmt = this.connexion.prepareStatement(Statement)){
            pSmt.setString(1, nouveauMail.getId());
            pSmt.setString(2, mailActuel.getId());
            pSmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Mail mail) {

        String Statetement = "delete from MAIL where ID_MAIL = ?";
        try(PreparedStatement pSmt = connexion.prepareStatement(Statetement)){
            pSmt.setString(1, mail.getId());
            pSmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }

        return true;
    }


}
