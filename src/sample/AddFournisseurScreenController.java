package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;


public class AddFournisseurScreenController {

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
    private TextField societe;

    @FXML
    private Button ajouter;

    @FXML
    private Button retourner;

    @FXML
    private Label addingLabel;

    @FXML
   public void add(ActionEvent event) {



        String mrq = societe.getText();
        String name = nom.getText();



        if (nom.getText() == "" || societe.getText() == ""  ) {

            addingLabel.setText("please fulfill all the elements");


        }else {



            String insertFields = "INSERT INTO fournisseur(nom,marque) VALUES('";

            String insertValues = name + "','" + mrq + "')";

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
    public void drag1 (MouseEvent event){
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    public void drag2 (MouseEvent event){
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }



}
