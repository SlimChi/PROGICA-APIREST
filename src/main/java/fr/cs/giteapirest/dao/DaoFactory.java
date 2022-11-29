package fr.cs.giteapirest.dao;

import java.sql.Connection;

public class DaoFactory {
    private DaoFactory() {

    }

    private static final Connection connexion = GITEConnect.getInstance();

    public static RegionDAO getRegionDAO() { return new RegionDAO(connexion);}

    public static DepartementDAO getDepartementDAO() {
        return new DepartementDAO(connexion);
    }

    public static DisponibiliteDAO getDisponibiliteDAO() {
        return new DisponibiliteDAO(connexion);
    }

    public static EquipementDAO getEquipementDAO() {
        return new EquipementDAO(connexion);
    }

    public static GiteDAO getGiteDAO() {
        return new GiteDAO(connexion);
    }

    public static LocaliteDAO getLocaliteDAO() { return new LocaliteDAO(connexion);
    }
    public static MailDAO getMailDAO() { return new MailDAO(connexion);}

    public static PeriodeDAO getPeriodeDAO() { return new PeriodeDAO(connexion);}
    public static PersonneDAO getPersonneDAO() { return new PersonneDAO(connexion);}

    public static SaisonDAO getSaisonDAO() { return new SaisonDAO(connexion);}
    public static TelephoneDAO getTelephoneDAO() { return new TelephoneDAO(connexion);}
    public static TypeEquipementDAO getTypeEquipementDAO() { return new TypeEquipementDAO(connexion);}

    public static TypeTelephoneDAO getTypeTelephoneDAO() { return new TypeTelephoneDAO(connexion);}
    public static VilleDAO getVilleDAO() { return new VilleDAO(connexion);}

    public static EquipementGiteDAO getEquipementGiteDAO(){
        return new EquipementGiteDAO(connexion);
    }



    public static LocaliteVilleDAO getLocaliteVilleDAO(){return new LocaliteVilleDAO(connexion);}

    public static SaisonGiteDAO getSaisonGiteDAO(){return new SaisonGiteDAO(connexion);}

    public static LocaliteSaisonPeriodeDAO getLocaliteSaisonPeriodeDAO(){return new LocaliteSaisonPeriodeDAO(connexion);}
 
}



