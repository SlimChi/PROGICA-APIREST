package fr.cs.giteapirest.service;

import fr.cs.giteapirest.dao.DaoFactory;
import fr.cs.giteapirest.metier.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceGite {


    private ArrayList<Gite> giteFiltre;

    private Gite giteDetail;
    private Gite giteDelete;

    private ArrayList<Ville> villeFiltre;
    private ArrayList<Localite> localiteFiltre;


    public ServiceGite() {

        giteDetail = new Gite();
        giteFiltre = chagerListeGite();
        giteDelete = new Gite();
        villeFiltre = DaoFactory.getVilleDAO().getAll();
        localiteFiltre = DaoFactory.getLocaliteDAO().getAll();
    }


    public ArrayList<Gite> getGiteFiltre(GiteSearch giteSearch) {
        return DaoFactory.getGiteDAO().getLike(giteSearch);
    }

    public ArrayList<Localite> getLocaliteFiltre() {
        return localiteFiltre;
    }

    public void setGiteFiltre(ArrayList<Gite> giteFiltre) {
        this.giteFiltre = giteFiltre;
    }

    public ArrayList<Ville> getVilleFiltre() { return villeFiltre;}

    public boolean updateGite(Gite gite) {
        return DaoFactory.getGiteDAO().update(gite);
    }

    public boolean insertGite(Gite gite) {
        return DaoFactory.getGiteDAO().insert(gite);
    }


    public Gite chercherDetailGite(int idGite) {

        giteDetail = DaoFactory.getGiteDAO().getByID(idGite);
        giteDetail.setPersonneGerant(DaoFactory.getPersonneDAO().getByID(giteDetail.getIdPersonneGerant()));
        giteDetail.setPersonne(DaoFactory.getPersonneDAO().getByID(giteDetail.getIdPersonne()));
        giteDetail.setEquipementGites(DaoFactory.getEquipementGiteDAO().getListEquipementGiteByIdGite(idGite));
        giteDetail.setSaisonGites(DaoFactory.getSaisonGiteDAO().getSaisonGiteByIdGite(idGite));
        giteDetail.setVille(DaoFactory.getVilleDAO().getVilleByCodeInsee(giteDetail.getCodeInseeDept(), giteDetail.getCodeInsee()));
        giteDetail.setDisponibilites(DaoFactory.getDisponibiliteDAO().getDisponibiliteByIdGerant(giteDetail.getIdPersonneGerant()));
        giteDetail.setLocaliteVilles(DaoFactory.getLocaliteVilleDAO().getLocaliteVilleByCodeInsee(giteDetail.getCodeInseeDept(), giteDetail.getCodeInsee()));

        //Pour chaque Localite affecte les Saisons ainsi que les Periodes ( ex : HAUTE du 01/01 au 30/04)
        for (int i = 0; i < giteDetail.getLocaliteVilles().size(); i++) {
            giteDetail.getLocaliteVilles().get(i).setLocaliteSaisonPeriodes(
                    DaoFactory.getLocaliteSaisonPeriodeDAO().getLocaliteSaisonPeriodeByIdLocalite(giteDetail.getLocaliteVilles().get(i).getIdLocalite())
            );

        }

        giteDetail.setTelephones(DaoFactory.getTelephoneDAO().getTelephonesByIdPersonne(giteDetail.getIdPersonneGerant()));


        return giteDetail;

    }

    //TRANSACTION POUR SUPPRIMER UN GITE
    public boolean deleteGite(Gite gite) {

       /* DaoFactory.getSaisonGiteDAO().deletebyIdGite(gite.getId());
        DaoFactory.getEquipementGiteDAO().deleteByIdGite(gite.getId());
        DaoFactory.getGiteDAO().delete(gite);*/

        try {
            return DaoFactory.getGiteDAO().deleteGiteTransaction(gite);
        } catch (SQLException e) {
            return false;
        }

    }


    public ArrayList chagerListeGite() {

        return DaoFactory.getGiteDAO().getAllEssential();
    }

    public int getIdPersonneByCodeAderent(String codeAderent) {

        return DaoFactory.getPersonneDAO().getIdPersonneByCodeAderent(codeAderent);

    }

    public int getIdPersonneByMail(String mail) {

        return DaoFactory.getPersonneDAO().getIdPersonneByMail(mail);
    }

    public boolean insertSaisonGite(SaisonGite saisonGite) {

        return DaoFactory.getSaisonGiteDAO().insert(saisonGite);


    }

    public int getMaxIdGite() {
        return DaoFactory.getGiteDAO().getMaxIdGite();
    }

    public boolean insertMail(Mail mail) {
        return DaoFactory.getMailDAO().insert(mail);
    }

    public boolean inserTelephone(Telephone telephone) {
        return DaoFactory.getTelephoneDAO().insert(telephone);
    }

    public boolean insertPersonne(Personne personne) {
        return DaoFactory.getPersonneDAO().insert(personne);
    }

    public int getMaxIdPersonne() {
        return DaoFactory.getPersonneDAO().getMaxIdPersonne();
    }

    public boolean updateSaisonGite(SaisonGite sg) {


        return DaoFactory.getSaisonGiteDAO().update(sg);
    }

    public ArrayList<Equipement> getAllEquipements() {

        return DaoFactory.getEquipementDAO().getAll();
    }

    public boolean getEquipementById(int id) {

        return DaoFactory.getEquipementDAO().getEquipmentById((id));

    }


    public void insertEquipementGite(EquipementGite equipementGite) {

        DaoFactory.getEquipementGiteDAO().insert(equipementGite);
    }

    public void deleteEquipementGiteByIdGite(int idGite) {
        DaoFactory.getEquipementGiteDAO().deleteByIdGite(idGite);
    }


    public boolean insererLesEquipements(Gite gite) {

        try {
            return DaoFactory.getGiteDAO().insertEquipementGiteTransaction(gite);
        } catch (SQLException e) {
            return false;
        }



    }


    public boolean getEquipementById(Equipement equipement){

        return DaoFactory.getEquipementDAO().getEquipmentById(equipement.getId());
    }


    public int getMaxIdEquipement(){
        return  DaoFactory.getEquipementDAO().getMaxIdEquipement();
    }


}