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
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuScreenController implements Initializable {

    private Stage stage;

    private Scene scene;

    private Parent root;

    private double x = 0;
    private double y = 0;


    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button exit;

    @FXML
    private Button minimize;

    @FXML
    private MenuButton stock;

    @FXML
    private MenuItem montures;

    @FXML
    private MenuItem lentille;

    @FXML
    private MenuItem produits;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label roleLabel;

    @FXML
    private Label date;



    String username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

                    date.setText(java.time.LocalDate.now().toString());




    }

    @FXML
    void ajouterClient(ActionEvent event) throws IOException {
    openAddCustmerScreen();
    }

    @FXML
    void nClient(MouseEvent event) throws IOException {
     openAddCustmerScreen();
    }




    @FXML
    void ajouterMonture(ActionEvent event) throws IOException {

        openAddMontureScreen();

    }

    @FXML
    void nProduit(MouseEvent event) throws IOException {

        openAddMontureScreen();
    }

    @FXML
    void ajouterFounisseur(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addFournisseurScreen.fxml"));
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void nFournisseur(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addFournisseurScreen.fxml"));
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


  public void  openFournisseurScreen() throws IOException {

      root = FXMLLoader.load(getClass().getResource("FournisseurScreen.fxml"));
      stage = (Stage)  stock.getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();


  }




    @FXML
    void openLentillesScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.<Parent>load(getClass().getResource("lentilleScreen.fxml"));
        stage = (Stage)  stock.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void openMonturesScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("montureScreen.fxml"));
        stage = (Stage)  stock.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }







    @FXML
    void openClientScreen(ActionEvent event) throws IOException{

        root = FXMLLoader.load(getClass().getResource("customerScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}

    @FXML
    void seDeconnecter(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openAddCustmerScreen() throws IOException{
        root = FXMLLoader.load(getClass().getResource("addCustomerScreen.fxml"));
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void openAddMontureScreen() throws IOException{
        root = FXMLLoader.load(getClass().getResource("typeScreen.fxml"));
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
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
