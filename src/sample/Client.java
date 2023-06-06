package sample;

public class Client {

    //INFOS CLIENT :
    private int id;
    private String nom;

    private String prenom;

    private String email;

    private String address;

    private long telephone;

    private String medcin;

    private String mutuelle;

    // CORRECTION :


    private double add;

    private double sphereDroit;

    private double sphereGauche;

    private double cylindreDroit;

    private double cylindreGauche;

    private double axeDroit;

    private double axeGauche;

    private String typeDeVerre;



    public Client(int id, String nom, String prenom, String email, String address, long telephone, String medcin,  double add,
                  double sphereDroit, double sphereGauche, double cylindreDroit, double cylindreGauche, double axeGauche, double axeDroit, String typeDeVerre, String mutuelle) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.medcin = medcin;
        this.add = add;
        this.sphereDroit = sphereDroit;
        this.sphereGauche = sphereGauche;
        this.cylindreDroit = cylindreDroit;
        this.cylindreGauche = cylindreGauche;
        this.axeDroit = axeDroit;
        this.axeGauche = axeGauche;
        this.typeDeVerre = typeDeVerre;
        this.mutuelle = mutuelle;
    }

    public Client() {
    }

    public String getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(String mutuelle) {
        this.mutuelle = mutuelle;
    }

    public void setAdd(double add) {
        this.add = add;
    }

    public void setAdd(int add) {
        this.add = add;
    }

    public double getAdd() {
        return add;
    }

    public void setTelephone(long telephone) { this.telephone = telephone; }

    public long getTelephone() { return telephone; }

    public void setAxeDroit(double axeDroit) {
        this.axeDroit = axeDroit;
    }

    public void setAxeGauche(double axeGauche) {
        this.axeGauche = axeGauche;
    }

    public double getAxeDroit() {
        return axeDroit;
    }

    public double getAxeGauche() {
        return axeGauche;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMedcin(String medcin) {
        this.medcin = medcin;
    }



    public void setSphereDroit(double sphereDroit) {
        this.sphereDroit = sphereDroit;
    }

    public void setSphereGauche(double sphereGauche) {
        this.sphereGauche = sphereGauche;
    }

    public void setCylindreDroit(double cylindreDroit) {
        this.cylindreDroit = cylindreDroit;
    }

    public void setCylindreGauche(double cylindreGauche) {
        this.cylindreGauche = cylindreGauche;
    }

    public void setTypeDeVerre(String typeDeVerre) {
        this.typeDeVerre = typeDeVerre;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getMedcin() {
        return medcin;
    }

    public double getSphereDroit() {
        return sphereDroit;
    }

    public double getSphereGauche() {
        return sphereGauche;
    }

    public double getCylindreDroit() {
        return cylindreDroit;
    }

    public double getCylindreGauche() {
        return cylindreGauche;
    }

    public String getTypeDeVerre() {
        return typeDeVerre;
    }

}