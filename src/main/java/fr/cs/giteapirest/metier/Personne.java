package fr.cs.giteapirest.metier;

public class Personne {

    private int id;

    private String nom;

    private String prenom;

    private String codeAderent;

    private String idMail;

    private Mail mail;


    public Personne() {
        mail = new Mail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCodeAderent() {
        return codeAderent;
    }

    public void setCodeAderent(String codeAderent) {
        this.codeAderent = codeAderent;
    }

    public String getIdMail() {
        return idMail;
    }

    public void setIdMail(String idMail) {
        this.idMail = idMail;
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return nom  + prenom ;
    }

}
