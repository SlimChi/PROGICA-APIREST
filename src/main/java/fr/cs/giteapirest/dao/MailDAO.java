package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Mail;
import fr.cs.giteapirest.metier.Region;
import fr.cs.giteapirest.metier.TypeEquipement;

import java.sql.*;
import java.util.ArrayList;

public class MailDAO extends DAO<Mail,Mail>{
    protected MailDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Mail getByID(int id) {
        return null;
    }

    public Mail getbyMail (String id) {
       Mail mail = new Mail();
        ResultSet rs;

        try {

            PreparedStatement pStmt = connexion.prepareStatement("select * from MAIL where ID_MAIL = ?");
            pStmt.setString(1,id);
            rs = pStmt.executeQuery();
            while(rs.next()){

               mail.setId(rs.getString(1));

            }
            rs.close();


        }    catch (SQLException e) {
            e.printStackTrace();

        }

        return mail;
    }

    @Override
    public ArrayList<Mail> getAll() {
        ArrayList<Mail> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {

            // Determine the column set column

            String strCmd = "select * from MAIL";

            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

                Mail mail = new Mail();
                mail.setId(rs.getString(1));

                liste.add(mail);

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
