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

public  class MontureScreenController implements Initializable {




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
    private TableView<Monture> montures;

    @FXML
    private TableColumn<Monture, Integer> idCol;

    @FXML
    private TableColumn<Monture, String> marqueCol;

    @FXML
    private TableColumn<Monture, String> couleurCol;

    @FXML
    private TableColumn<Monture, String> formeCol;

    @FXML
    private TableColumn<Monture, String> matiereCol;

    @FXML
    private TableColumn<Monture, String> enfantCol;

    @FXML
    private TableColumn<Monture, String> unisexeCol;

    @FXML
    private TableColumn<Monture, String> solaireCol;

    @FXML
    private TableColumn<Monture, Double> prixCol;

    @FXML
    private Button delete;



    ObservableList<Monture> montureList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        date.setText(java.time.LocalDate.now().toString());

        try {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            ResultSet resultSet = connectDB.createStatement().executeQuery("SELECT * FROM montures");


            while (resultSet.next()) {
                montureList.add(new Monture(resultSet.getInt("id"),
                        resultSet.getString("marque"),
                        resultSet.getString("couleur"),
                        resultSet.getString("forme"),
                        resultSet.getString("matiere"),
                        resultSet.getString("enfant"),
                        resultSet.getString("unisexe"),
                        resultSet.getString("solaire"),
                        resultSet.getDouble("prix")
                ));
            }



        } catch (SQLException e) {
            Logger.getLogger(MontureScreenController.class.getName()).log(Level.SEVERE, null, e);

        }

        idCol.setCellValueFactory(new PropertyValueFactory<Monture, Integer>("id_monture"));
        marqueCol.setCellValueFactory(new PropertyValueFactory<Monture, String>("marque"));
        couleurCol.setCellValueFactory(new PropertyValueFactory<Monture, String>("couleur"));
        formeCol.setCellValueFactory(new PropertyValueFactory<Monture, String>("forme"));
        matiereCol.setCellValueFactory(new PropertyValueFactory<Monture, String>("matiere"));
        enfantCol.setCellValueFactory(new PropertyValueFactory<Monture, String>("enfant"));
        unisexeCol.setCellValueFactory(new PropertyValueFactory<Monture, String>("unisexe"));
        solaireCol.setCellValueFactory(new PropertyValueFactory<Monture, String>("solaire"));
        prixCol.setCellValueFactory(new PropertyValueFactory<Monture, Double>("prix"));
        montures.setItems(montureList);

    }

    @FXML
    private void deleteMonture() {

        Monture monture = montures.getSelectionModel().getSelectedItem();
        montures.getItems().removeAll(monture);
        int id = monture.getId_monture();

        String delete = "DELETE FROM montures WHERE id = "+id+"";

        try {

            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            Statement statement = connectDB.createStatement();
            statement.executeUpdate(delete);


        } catch (SQLException ex) {
            Logger.getLogger(CustomerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @FXML
    void openAddMontureScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addMontureScreen2.fxml"));
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void refreshTable(ActionEvent event) {
        try {
            montureList.clear();
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            ResultSet resultSet = connectDB.createStatement().executeQuery("SELECT * FROM montures");


            while (resultSet.next()) {
                montureList.add(new Monture(resultSet.getInt("id"),
                        resultSet.getString("marque"),
                        resultSet.getString("couleur"),
                        resultSet.getString("forme"),
                        resultSet.getString("matiere"),
                        resultSet.getString("enfant"),
                        resultSet.getString("unisexe"),
                        resultSet.getString("solaire"),
                        resultSet.getDouble("prix")
                ));
            }



        } catch (SQLException e) {
            Logger.getLogger(MontureScreenController.class.getName()).log(Level.SEVERE, null, e);

        }


        montures.setItems(montureList);

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
    void updateMonture(javafx.event.ActionEvent event) throws IOException {


        Monture monture = montures.getSelectionModel().getSelectedItem();
        int id = monture.getId_monture();
        String mrq = monture.getMarque();
        String material = monture.getMatiere();
        String price = String.valueOf(monture.getPrix());
        String color = monture.getCouleur();
        String  form = monture.getForme();
        String kids = monture.isEnfant();
        String solair = monture.isSolaire();
        String ux = monture.isUnisexe();









        FXMLLoader loader = new FXMLLoader(getClass().getResource("updateMontureScreen.fxml"));
        root = loader.load();

         UpdateMontureScreenController updateMontureScreenController = loader.getController();
        updateMontureScreenController.modifyMonture(mrq,price,material,color,form,kids,solair,ux,id);

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
    public void minimize (ActionEvent event){
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        stage.setIconified(true);
    }





}


