package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TypeScreenController implements Initializable {


    private Stage stage;

    private Scene scene;

    private Parent root;

    private double x = 0;
    private double y = 0;


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label warningLabel;

    @FXML
    private Button continuer;

    @FXML
    private Button annuler;

    @FXML
    private ChoiceBox<String> type;
    String[] types = {"Montures","Lentilles"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        type.setValue("Séléctionner le type du produit");
        type.getItems().addAll(types);


    }




    @FXML
    void continuer(ActionEvent event) throws IOException {

        if(type.getValue()=="Montures"){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("addMontureScreen.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        else if(type.getValue()=="Lentilles"){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addLentilleScreen.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        else if(type.getValue() == "Séléctionner le type du produit") warningLabel.setText("Selectionner un type!");

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
