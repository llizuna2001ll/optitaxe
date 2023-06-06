package sample;

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

public class LentilleScreenController implements Initializable {

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
    private TableView<Lentille> lentilles;

    @FXML
    private TableColumn<Lentille, Integer> idCol;

    @FXML
    private TableColumn<Lentille, String> couleurCol;

    @FXML
    private TableColumn<Lentille, String> typeCol;

    @FXML
    private TableColumn<Lentille, Integer> prixCol;

    @FXML
    private Button delete;

    ObservableList<Lentille> lentilleList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        date.setText(java.time.LocalDate.now().toString());

        try {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            ResultSet resultSet = connectDB.createStatement().executeQuery("SELECT * FROM lentilles");


            while (resultSet.next()) {
                lentilleList.add(new Lentille(resultSet.getInt("id"),
                        resultSet.getString("couleur"),
                        resultSet.getString("type"),
                        resultSet.getInt("prix")

                ));
            }



        } catch (SQLException e) {
            Logger.getLogger(LentilleScreenController.class.getName()).log(Level.SEVERE, null, e);

        }

        idCol.setCellValueFactory(new PropertyValueFactory<Lentille, Integer>("id"));
        couleurCol.setCellValueFactory(new PropertyValueFactory<Lentille, String>("couleur"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Lentille, String>("type"));
        prixCol.setCellValueFactory(new PropertyValueFactory<Lentille, Integer>("prix"));

        lentilles.setItems(lentilleList);


    }

    @FXML
    void deleteLentille(ActionEvent event) {
        Lentille lentille = lentilles.getSelectionModel().getSelectedItem();
        lentilles.getItems().removeAll(lentille);
        int id = lentille.getId();

        String delete = "DELETE FROM lentilles WHERE id = "+id+"";

        try {

            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            Statement statement = connectDB.createStatement();
            statement.executeUpdate(delete);


        } catch (SQLException ex) {
            Logger.getLogger(LentilleScreenController.class.getName()).log(Level.SEVERE, null, ex);
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


    @FXML
    public void exit (ActionEvent event){
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void minimize (ActionEvent event){
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        stage.setIconified(true);
    }


    @FXML
    void openAddLentilleScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addLentilleScreen1.fxml"));
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void refreshTable(ActionEvent event) {
        try {
            lentilleList.clear();

            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();
            ResultSet resultSet = connectDB.createStatement().executeQuery("SELECT * FROM lentilles");


            while (resultSet.next()){
                lentilleList.add(new Lentille(resultSet.getInt("id"),
                        resultSet.getString("couleur"),
                        resultSet.getString("type"),
                        resultSet.getInt("prix")

                ));

                lentilles.setItems(lentilleList);

            }


        } catch (SQLException ex) {
            Logger.getLogger(LentilleScreenController.class.getName()).log(Level.SEVERE, null, ex);
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
    void updateLentille(ActionEvent event) throws IOException {

            Lentille lentille = lentilles.getSelectionModel().getSelectedItem();
        int id = lentille.getId();
        String couleur = lentille.getCouleur();
        String type = lentille.getType();
        String prix= String.valueOf(lentille.getPrix());








        FXMLLoader loader = new FXMLLoader(getClass().getResource("updateLentilleScreen.fxml"));
        root = loader.load();

        UpdateLentilleScreen updateLentilleScreen = loader.getController();
        updateLentilleScreen.modifyLentille(couleur,type,prix,id);

        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
