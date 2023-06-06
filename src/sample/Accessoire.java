package sample;

public class Accessoire {
                    private int id;
                    private String nom;
                    private int prix;
                    private String couleur;

    public Accessoire(int id, String nom, int prix, String couleur) {
        this.nom = nom;
        this.prix = prix;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
