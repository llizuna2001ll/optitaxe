package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class loginScreenController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private double x = 0;
    private double y = 0;


    @FXML
    private AnchorPane anchorpane;

    @FXML
     TextField signInUsername;

    @FXML
     PasswordField signInPassword;

    @FXML
    private Button signIn;

    @FXML
    private Button exit;

    @FXML
    private Button minimize;

    @FXML
    private Button signup;

    @FXML
    private Label warningLabel;



    @FXML

    public void initialize(URL url, ResourceBundle resourceBundle) {


    }



    @FXML
    public void signIn(ActionEvent event) throws IOException {

        if(signInUsername.getText().isBlank() == false && signInPassword.getText().isBlank() == false){

            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();
            String verifyLogin = "SELECT count(1) FROM users_account WHERE username = '" + signInUsername.getText() + "' and password = '" + signInPassword.getText() + "'";


            try {
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);

                while (queryResult.next()) {

                    if (queryResult.getInt(1) == 1)  {


                        FXMLLoader loader = new FXMLLoader(getClass().getResource("menuScreen.fxml"));
                        root = loader.load();


                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();


                    } else {
                        warningLabel.setText("Invalid username or password!");

                    }


                }
            }catch(Exception e){





                e.printStackTrace();
                e.getCause();

            }

        }

        else warningLabel.setText("Please enter username and password");




    }

   public void validateLogin()  {



}


    private void openMenuScreen() throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("menuScreen.fxml"));
            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void openSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("registerScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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


    @FXML
    public void exit(ActionEvent event) {
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void minimize(ActionEvent event) {
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        stage.setIconified(true);
    }

}




























