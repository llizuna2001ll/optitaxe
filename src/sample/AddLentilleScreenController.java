package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddLentilleScreenController implements Initializable {



    private Stage stage;

    private Scene scene;

    private Parent root;


    private double x = 0;
    private double y = 0;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField couleur;

    @FXML
    private Button ajouter;

    @FXML
    private Button retourner;

    @FXML
    private Label addingLabel;

    @FXML
    private ChoiceBox<String> types;
    private String[] type = {"souple","rigide"};

    @FXML
    private TextField prix;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        types.getItems().addAll(type);

    }

    @FXML
    void add(ActionEvent event) {
        String price = prix.getText();
        String color = couleur.getText();
        String typee = types.getValue();



        if (  couleur.getText() !="" || types.getValue() !="" || prix.getText() !="" ) {


            String insertFields = "INSERT INTO lentilles(couleur,type,prix) VALUES('";

            String insertValues = color + "','" + typee + "','"  + price + "')";

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
    void retourner (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("typeScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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


