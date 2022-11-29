package fr.cs.giteapirest.metier;

public class Mail {

    private String id;


    public Mail() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }



}
