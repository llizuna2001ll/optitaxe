package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class AddCustomerScreenController implements Initializable {

    private Stage stage;

    private Scene scene;

    private Parent root;

    private double x = 0;
    private double y = 0;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField telephone;


    @FXML
    private TextField add;

    @FXML
    private TextField sphDroit;

    @FXML
    private TextField sphGauche;

    @FXML
    private TextField cylDroit;

    @FXML
    private TextField cylGauche;

    @FXML
    private TextField axeDroit;

    @FXML
    private TextField axeGauche;



    @FXML
     private TextField medcin;

    @FXML
    private TextField verre;

    @FXML
    private Label addingLabel;


    @FXML
    private ChoiceBox<String> mutuelle;
    private final String[] typeMutuelle = {"Aucune","Atlanta", "AXA","CNOPS","MFAR","RMA","SAHAM","Wafa Assurance","Zurich"};



    @FXML
    private Button ajouter;

    @FXML
    private Button Cancel;

    @FXML
    private Button clear;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                    mutuelle.setValue("Selectioner");
                    mutuelle.getItems().addAll(typeMutuelle);
                    telephone.setText("212");



    }

    @FXML
    void add(ActionEvent event) {

        String lname = nom.getText(); // stocker ce qu'on a ecrit dans la textfield nom dans la chaine "lname"
        String fname = prenom.getText();
        String e_mail = email.getText();
        String add_ress = address.getText();
        String tel = telephone.getText();
        String doctor = medcin.getText();

        String addition = add.getText();
        String sphd = sphDroit.getText();
        String sphg = sphGauche.getText();
        String cyld = cylDroit.getText();
        String cylg = cylGauche.getText();
        String axed = axeDroit.getText();
        String axeg = axeGauche.getText();
        String verre_type = verre.getText();

        String assurance = mutuelle.getValue();

        if (nom.getText().isBlank() == false || prenom.getText().isBlank() == false || telephone.getText().isBlank() == false || medcin.getText().isBlank() == false ||

                  sphGauche.getText().isBlank() == false || sphDroit.getText().isBlank() == false ||

                cylDroit.getText().isBlank() == false || cylGauche.getText().isBlank() == false || axeDroit.getText().isBlank() == false || axeGauche.getText().isBlank() == false ||

                verre.getText().isBlank() == false ||  mutuelle.getValue() != null) { // ne pas entrer si une textfield est vide

            String insertFields = "INSERT INTO clients(nom,prenom,address,telephone,email,medcin,addd,sphere_droit,sphere_gauche" +

                    ",cylindre_droit,cylindre_gauche,axe_droit,axe_gauche,verre,mutuelle) VALUES('"; // stocker la phrase verte dans
                                                                                                     // insertFields

            String insertValues = lname + "','" + fname + "','" + add_ress + "','" + tel + "','" + e_mail + "','" + doctor

                    +  "','" + addition + "','" + sphd + "','" + sphg + "','" + cyld + "','" + cylg + "','" + axed + "','" + axeg + "','" + verre_type + "','" + assurance + "')";
                    // stocker la phrase blanche dans insertValues


            String insertToRegister = insertFields + insertValues; // phras verte + phrase blanche

            try {
                DataBaseConnection connectNow = new DataBaseConnection();
                Connection connectDB = connectNow.getConnection(); // connecter la methode avec la base de données

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister); // executer la phrase verte + la phrase blanche dans la base de données


                    addingLabel.setText("Successfully added");



            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
                addingLabel.setText("please fulfill all the elements");

            }


 }


    }


 @FXML
    void clear(ActionEvent event) {
         nom.clear();
         prenom.clear();
         email.clear();
         address.clear();
         telephone.clear();
         medcin.clear();

         add.clear();
         sphDroit.clear();
         sphGauche.clear();
         cylDroit.clear();
         cylGauche.clear();
         axeDroit.clear();
         axeGauche.clear();
         verre.clear();
         mutuelle.setValue("Selectionner");
         telephone.setText("212");


    }





    @FXML
    void Cancel(ActionEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
}


















    @FXML
    public void drag1(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    public void drag2(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

}
