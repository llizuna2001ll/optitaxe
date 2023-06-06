package sample;

public class Fournisseur {
    private int id;
    private String nom;
    private String marque;


    public Fournisseur(int id, String nom, String marque) { // Constructeur de la classe fournisseur pour faire l'instanciation
        this.id = id;
        this.nom = nom;
        this.marque = marque;


    }

    //getters et setters de la class pour avoir acces au attributs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

}
