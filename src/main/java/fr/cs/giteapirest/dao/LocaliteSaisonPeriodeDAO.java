package fr.cs.giteapirest.dao;

import fr.cs.giteapirest.metier.Localite;
import fr.cs.giteapirest.metier.LocaliteSaisonPeriode;
import fr.cs.giteapirest.metier.Periode;
import fr.cs.giteapirest.metier.Saison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LocaliteSaisonPeriodeDAO extends DAO<LocaliteSaisonPeriode,LocaliteSaisonPeriode> {
    protected LocaliteSaisonPeriodeDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public LocaliteSaisonPeriode getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<LocaliteSaisonPeriode> getAll() {
        return null;
    }

    @Override
    public ArrayList<LocaliteSaisonPeriode> getLike(LocaliteSaisonPeriode objet) {
        return null;
    }

    @Override
    public boolean insert(LocaliteSaisonPeriode objet) {
        return false;
    }

    @Override
    public boolean update(LocaliteSaisonPeriode object) {
        return false;
    }

    @Override
    public boolean delete(LocaliteSaisonPeriode object) {
        return false;
    }


    public ArrayList getLocaliteSaisonPeriodeByIdLocalite(int idLocalite){

        ArrayList<LocaliteSaisonPeriode> liste = new ArrayList<>();
        ResultSet rs;
        try  {

            PreparedStatement pStmt = connexion
                    .prepareStatement("select LSP.*,L.LIBELLE_LOCALITE,S.LIBELLE_SAISON,P.DATE_DEBUT,P.DATE_FIN from LOCALITE_SAISON_PERIODE as LSP\n" +
                            "join LOCALITE as L on L.ID_LOCALITE = LSP.ID_LOCALITE\n" +
                            "join SAISON as S on S.ID_SAISON = LSP.ID_SAISON\n" +
                            "join PERIODE as P on P.ID_PERIODE = LSP.ID_PERIODE WHERE LSP.ID_LOCALITE = ? ORDER BY ID_PERIODE");
            // Determine the column set column

            pStmt.setInt(1, idLocalite);

            rs = pStmt.executeQuery();

            while (rs.next()) {
                LocaliteSaisonPeriode lsp = new LocaliteSaisonPeriode();

                lsp.setIdLocalite(rs.getInt(1));
                lsp.setIdSaison(rs.getInt(2));
                lsp.setIdPeriode(rs.getInt(3));

                Localite localite = new Localite();
                localite.setId(rs.getInt(1));
                localite.setLibelle(rs.getString(4));

                Saison saison = new Saison();
                saison.setId(rs.getInt(2));
                saison.setLibelle(rs.getString(5));

                Periode periode = new Periode();
                periode.setId(rs.getInt(3));
                periode.setDateDebut(rs.getDate(6));
                periode.setDateFin(rs.getDate(7));


                lsp.setLocalite(localite);
                lsp.setSaison(saison);
                lsp.setPeriode(periode);
                liste.add(lsp);

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
