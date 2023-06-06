package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterScreenController implements Initializable {
    private Stage stage;

    private Scene scene;

    private Parent root;

    private double x = 0;
    private double y = 0;





    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button signup;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private TextField signUpUsername;

    @FXML
    private PasswordField signUpPassword;


    @FXML
    private Button exit;
    @FXML
    private Label registrationLabel;

    @FXML
    private ChoiceBox<String> sexe;

    private final String[] gender = {"Propriétaire", "Personnel"};

    @FXML
    private Button minimize;

@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sexe.getItems().addAll(gender);

    }

    public void openSignIn(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void signUP(ActionEvent event) {

        String firstName = nom.getText();
        String lastName = prenom.getText();
        String username = signUpUsername.getText();
        String password = signUpPassword.getText();
        String gender = sexe.getValue();

        if (nom.getText() != "" || prenom.getText() !="" || signUpUsername.getText()!= "" || signUpPassword.getText().isBlank() == false || sexe.getValue() != null) {

            String insertFields = "INSERT INTO users_account(nom,prenom,username,password,role) VALUES('";
            String insertValues = firstName + "','" + lastName + "','" + username + "','" + password + "','" + gender + "')";
            String insertToRegister = insertFields + insertValues;

            try {
                DataBaseConnection connectNow = new DataBaseConnection();
                Connection connectDB = connectNow.getConnection();

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);
                registrationLabel.setText("successfully registered");

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
                registrationLabel.setText("merci de choisir un autre nom d'utilisateur");

            }

        }
        else registrationLabel.setText("Please fulfill all the elements!");
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