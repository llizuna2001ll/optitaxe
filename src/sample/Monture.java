package sample;

public class Monture {

                        private int id_monture;

                        private String marque;

                        private String couleur;

                        private String forme;

                        private String matiere;

                        private String enfant;

                        private String unisexe;

                        private String solaire;

                        private double prix;



    public Monture(int id_monture, String marque, String couleur, String forme, String matiere, String enfant, String unisexe, String solaire, double prix) {

        this.id_monture = id_monture;
        this.marque = marque;
        this.couleur = couleur;
        this.forme = forme;
        this.matiere = matiere;
        this.enfant = enfant;
        this.unisexe = unisexe;
        this.solaire = solaire;
        this.prix = prix;
}

    public String isSolaire() {
        return solaire;
    }

    public void setSolaire(String solaire) {
        this.solaire = solaire;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setEnfant(String enfant) {
        this.enfant = enfant; }

    public void setUnisexe(String unisexe) {
        this.unisexe = unisexe; }

    public String isUnisexe() {
        return unisexe; }

    public String isEnfant() {
        return enfant; }

    public String getCouleur() {
        return couleur;
    }

    public String getForme() {
        return forme;
    }

    public String getMarque() {
        return marque;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getId_monture() { return id_monture; }

    public void setId_monture(int id_monture) { this.id_monture = id_monture; }

}
