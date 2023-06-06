package sample;

public class Lentille {
                        private int id;
                        private String couleur;
                        private String type;
                        private int prix;

    public Lentille(int id, String couleur, String type, int prix) {
        this.id = id;
        this.couleur = couleur;
        this.type = type;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
