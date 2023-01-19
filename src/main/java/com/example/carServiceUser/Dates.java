package com.example.carServiceUser;

public class Dates {

    private String debut;
    private String fin;
    private int id;

    public Dates(String debut, String fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public Dates() {
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
