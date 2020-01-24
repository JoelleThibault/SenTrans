package sn.sentrans.entities;

public class TypeLocalite {
    private int idT;
    private String nom;

    public TypeLocalite() {
    }

    public TypeLocalite(int idT, String nom) {
        this.idT = idT;
        this.nom = nom;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
