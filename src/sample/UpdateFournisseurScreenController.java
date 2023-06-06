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
import java.sql.PreparedStatement;

public class UpdateFournisseurScreenController  {


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

    private int id;

    public void modifyFournisseur(String name, String mrq, int idd) {
        nom.setText(name);
        societe.setText(mrq);

        id = idd;
    }

    @FXML
    void update(ActionEvent event) {
        String name = nom.getText();
        String mrq = societe.getText();


        if (nom.getText() == "" || societe.getText() == "") {

        }else {


            String insertFields = "UPDATE  fournisseur SET nom = '" + name +

                    "',marque = '" + mrq + "' WHERE id='" + id + "'";


            String insertToRegister = insertFields;

            try {
                DataBaseConnection connectNow = new DataBaseConnection();
                Connection connectDB = connectNow.getConnection();

                PreparedStatement statement = connectDB.prepareStatement(insertToRegister);
                statement.execute(insertToRegister);


                addingLabel.setText("Successfully updated");


            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
                addingLabel.setText("please fulfill all the elements");

            }
        }
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

    public void retourner(ActionEvent event) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }
}

