package sample;

import com.mysql.cj.protocol.FullReadInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FournisseurScreenController implements Initializable {

    private Stage stage;

    private Scene scene;

    private Parent root;

    private double x = 0;
    private double y = 0;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label date;

    @FXML
    private Button exit;

    @FXML
    private Button minimize;

    @FXML
    private TableView<Fournisseur> fournisseurs;

    @FXML
    private TableColumn<Fournisseur, Integer> idCol;
    @FXML
    private TableColumn<Fournisseur, String> marqueCol;
    @FXML
    private TableColumn<Fournisseur, String> nomCol;



    @FXML
    private Button delete;

    ObservableList<Fournisseur> fournisseurList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        date.setText(java.time.LocalDate.now().toString());

        try {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            ResultSet resultSet = connectDB.createStatement().executeQuery("SELECT * FROM fournisseur");





            while (resultSet.next()) {

                fournisseurList.add(new Fournisseur(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("marque")
                ));
            }

            // try{ }catch(){} est utiliser pour exceptionner les erreurs de type SQL
        } catch (SQLException e) {
            Logger.getLogger(FournisseurScreenController.class.getName()).log(Level.SEVERE, null, e);

        }


        idCol.setCellValueFactory(new PropertyValueFactory<Fournisseur, Integer>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<Fournisseur, String>("nom"));
        marqueCol.setCellValueFactory(new PropertyValueFactory<Fournisseur, String>("marque"));
        // creation d'une nouvelle colonne qui stock une chaine de caractere de l'attribut "marque" dans un tableau de type d'objet "Fournisseur"


        fournisseurs.setItems(fournisseurList); // ajouter les objets dans "clientList" dans le tableau "clients"


    }

    @FXML
    void deleteFournisseur(ActionEvent event) {
        Fournisseur fournisseur = fournisseurs.getSelectionModel().getSelectedItem();

        fournisseurs.getItems().removeAll(fournisseur);


        int id = fournisseur.getId();

        String delete = "DELETE FROM fournisseur WHERE id = "+id+"";

        try {

            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            Statement statement = connectDB.createStatement();
            statement.executeUpdate(delete);


        } catch (SQLException ex) {
            Logger.getLogger(FournisseurScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }




    @FXML
    //Cette methode pour ouvrir la scene d'ajout de fournisseur
    void openAddFournisseurScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addFournisseurScreen.fxml"));
        stage = new Stage(); //pour ouvrir la scene dans une nouvelle stage
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void refreshTable(ActionEvent event) {


        try {
            fournisseurList.clear();

            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();


            ResultSet resultSet = connectDB.createStatement().executeQuery("SELECT * FROM fournisseur");





            while (resultSet.next()) {

                fournisseurList.add(new Fournisseur(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("marque")

                ));
            }

            // try{ }catch(){}: est utiliser pour exceptionner les erreurs de type SQL
        } catch (SQLException e) {
            Logger.getLogger(FournisseurScreenController.class.getName()).log(Level.SEVERE, null, e);

        }







    }

    @FXML

    void retourner(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menuScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void updateFournisseur(ActionEvent event) throws IOException {
        Fournisseur fournisseur = fournisseurs.getSelectionModel().getSelectedItem();

        int id = fournisseur.getId();
        String name = fournisseur.getNom();
        String mrq = fournisseur.getMarque();









        FXMLLoader loader = new FXMLLoader(getClass().getResource("updateFournisseurScreen.fxml"));
        root = loader.load();

        UpdateFournisseurScreenController updateFournisseurScreenController = loader.getController();
        updateFournisseurScreenController.modifyFournisseur(name,mrq,id);

        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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


    @FXML
    public void exit (ActionEvent event){
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void minimize(ActionEvent event) {
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        stage.setIconified(true);
    }





}
