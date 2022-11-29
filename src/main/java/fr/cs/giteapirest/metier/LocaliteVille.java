package fr.cs.giteapirest.metier;

import java.util.ArrayList;

public class LocaliteVille {

    private String idCodeInseeDept;

    private String idCodeInsee;

    private int idLocalite;

    private Localite localite;

    ArrayList<LocaliteSaisonPeriode> localiteSaisonPeriodes;

    public LocaliteVille(){}

    public String getIdCodeInseeDept() {
        return idCodeInseeDept;
    }

    public void setIdCodeInseeDept(String idCodeInseeDept) {
        this.idCodeInseeDept = idCodeInseeDept;
    }

    public String getIdCodeInsee() {
        return idCodeInsee;
    }

    public void setIdCodeInsee(String idCodeInsee) {
        this.idCodeInsee = idCodeInsee;
    }

    public int getIdLocalite() {
        return idLocalite;
    }

    public void setIdLocalite(int idLocalite) {
        this.idLocalite = idLocalite;
    }

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }


    public ArrayList<LocaliteSaisonPeriode> getLocaliteSaisonPeriodes() {
        return localiteSaisonPeriodes;
    }

    public void setLocaliteSaisonPeriodes(ArrayList<LocaliteSaisonPeriode> localiteSaisonPeriodes) {
        this.localiteSaisonPeriodes = localiteSaisonPeriodes;
    }

    @Override
    public String toString() {
        return localite.toString();

    }
}
