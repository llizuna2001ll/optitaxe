package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

import java.sql.*;
import java.util.ResourceBundle;


public class AddMontureScreenController1 implements Initializable {




    private Stage stage;

    private Scene scene;

    private Parent root;


    private double x = 0;
    private double y = 0;




    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField marque;

    @FXML
    private TextField couleur;


    @FXML
    private Button ajouter;

    @FXML
    private Button photoButton;

    @FXML
    private Button Cancel;

    @FXML
    private Label addingLabel;

    @FXML
    private RadioButton enfant;

    @FXML
    private RadioButton unisexe;

    @FXML
    private RadioButton solaire;

    @FXML
    private TextField prix;

    @FXML
    private ChoiceBox<String> forme;
    private final String[] forme_types = {"Ronde","Rectangulaire","ClubMaster","Papillon","Pantos"};

    @FXML
    private ChoiceBox<String> matiere;
    private final String[] material = {"organique","metal","naturel"};

    @FXML

    public void initialize(URL url, ResourceBundle resourceBundle) {

        forme.setValue("Selectionner");
        forme.getItems().addAll(forme_types);
        matiere.getItems().addAll(material);

    }

    @FXML
    void add(ActionEvent event) {



        String mrq = marque.getText();
        String color = couleur.getText();
        String material = matiere.getValue();
        String form = forme.getValue();
        boolean kids = enfant.isSelected();
        String kids1 = kids ? "OUI" : "NON";
        boolean unisexee = unisexe.isSelected();
        String unisexee1 = unisexee ? "OUI" : "NON";
        boolean solairee = solaire.isSelected();
        String solairee1 = solairee ? "OUI" : "NON";
        String price = prix.getText();


        if (marque.getText().isBlank() == false || couleur.getText().isBlank() == false || matiere.getValue() != null || forme.getValue() != null ||

                prix.getText().isBlank() == false || ( enfant.isSelected()== false && solaire.isSelected()== false && unisexe.isSelected()== false) ) {


            String insertFields = "INSERT INTO montures(marque,couleur,forme,matiere,enfant,unisexe,solaire,prix) VALUES('";

            String insertValues = mrq + "','" + color + "','" + form + "','" + material + "','" + kids1 + "','" + unisexee1 + "','"

                    + solairee1 + "','" + price + "')";

            String insertToRegister = insertFields + insertValues;

            try {
                DataBaseConnection connectNow = new DataBaseConnection();
                Connection connectDB = connectNow.getConnection();

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);


                addingLabel.setText("Successfully added");



            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
                addingLabel.setText("please fulfill all the elements");

            }








        }
    }






























    @FXML
    void retourner(ActionEvent event) throws IOException {
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
