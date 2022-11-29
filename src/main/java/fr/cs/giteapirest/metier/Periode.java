package fr.cs.giteapirest.metier;

import java.util.Date;

public class Periode {

    private int id;

    private Date dateDebut;

    private Date dateFin;

    public Periode(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return
                "du "+
                dateDebut.toString().substring(8)+"/"+dateDebut.toString().substring(5,7)+
                " au "+ dateFin.toString().substring(8)+"/"+dateFin.toString().substring(5,7);
    }
}
