package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Localite;
import fr.cs.giteapirest.metier.LocaliteVille;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LocaliteVilleDAO extends DAO<LocaliteVille,LocaliteVille>{
    protected LocaliteVilleDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public LocaliteVille getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<LocaliteVille> getAll() {
        return null;
    }

    @Override
    public ArrayList<LocaliteVille> getLike(LocaliteVille objet) {
        return null;
    }

    @Override
    public boolean insert(LocaliteVille objet) {
        return false;
    }

    @Override
    public boolean update(LocaliteVille object) {
        return false;
    }

    @Override
    public boolean delete(LocaliteVille object) {
        return false;
    }


    public ArrayList getLocaliteVilleByCodeInsee(String codeInseeDept,String codeInsee){

        ArrayList<LocaliteVille> liste = new ArrayList<>();
        ResultSet rs;
        try  {

            PreparedStatement pStmt = connexion
                    .prepareStatement("select LV.*,L.LIBELLE_LOCALITE from LOCALITE_VILLE as LV\n" +
                            "join LOCALITE AS L on L.ID_LOCALITE = LV.ID_LOCALITE\n" +
                            "WHERE LV.CODE_INSEE_DEPT = ? and LV.CODE_INSEE = ?");
            // Determine the column set column

            pStmt.setString(1, codeInseeDept);
            pStmt.setString(2, codeInsee);
            rs = pStmt.executeQuery();

            while (rs.next()) {

                LocaliteVille localiteVille = new LocaliteVille();

                Localite localite = new Localite();
                localite.setId(rs.getInt(3));
                localite.setLibelle(rs.getString(4));

                localiteVille.setIdLocalite(rs.getInt(3));
                localiteVille.setIdCodeInseeDept(rs.getString(1));
                localiteVille.setIdCodeInsee(rs.getString(2));
                localiteVille.setLocalite(localite);



                liste.add(localiteVille);

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
