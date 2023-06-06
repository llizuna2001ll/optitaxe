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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerScreenController implements Initializable {




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
    private TableView<Client> clients;

    @FXML
    private TableColumn<Client, Integer> idCol;

    @FXML
    private TableColumn<Client, String> nomCol;

    @FXML
    private TableColumn<Client, String> prenomcol;

    @FXML
    private TableColumn<Client, String> addressCol;

    @FXML
    private TableColumn<Client, Long> telephoneCol;

    @FXML
    private TableColumn<Client, String> emailCol;

    @FXML
    private TableColumn<Client, String> medcinCol;

    @FXML
    private TableColumn<Client, String> verreCol;

    @FXML
    private TableColumn<Client, String> mutuelleCol;

    @FXML
    private TableColumn<Client, Double> odCol;

    @FXML
    private TableColumn<Client, Double> ogCol;

    @FXML
    private TableColumn<Client, Double> addCol;

    @FXML
    private TableColumn<Client, Double> odSpherCol;

    @FXML
    private TableColumn<Client, Double> ogSpherCol;

    @FXML
    private TableColumn<Client, Double> odCylCol;

    @FXML
    private TableColumn<Client, Double> ogCylCol;

    @FXML
    private TableColumn<Client, Double> odAxeCol;

    @FXML
    private TableColumn<Client, Double> ogAxeCol;




    ObservableList<Client> clientList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        date.setText(java.time.LocalDate.now().toString());

        try {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            ResultSet resultSet = connectDB.createStatement().executeQuery("SELECT * FROM clients");





                while (resultSet.next()) {

                    clientList.add(new Client(resultSet.getInt("id_client"),

                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("Email"),
                        resultSet.getString("address"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("medcin"),
                        resultSet.getDouble("addd"),
                        resultSet.getDouble("sphere_droit"),
                        resultSet.getDouble("sphere_gauche"),
                        resultSet.getDouble("cylindre_droit"),
                        resultSet.getDouble("cylindre_gauche"),
                        resultSet.getDouble("axe_gauche"),
                        resultSet.getDouble("axe_droit"),
                        resultSet.getString("verre"),
                        resultSet.getString("mutuelle")
                        ));
}











        } catch (SQLException e) {
            Logger.getLogger(CustomerScreenController.class.getName()).log(Level.SEVERE, null, e);

        }
        idCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));

        nomCol.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
        prenomcol.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Client, String>("address"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
        telephoneCol.setCellValueFactory(new PropertyValueFactory<Client, Long>("telephone"));
        medcinCol.setCellValueFactory(new PropertyValueFactory<Client, String>("medcin"));

        addCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("add"));
        odSpherCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("sphereDroit"));
        ogCylCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("cylindreGauche"));
        odCylCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("cylindreDroit"));
        odAxeCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("axeDroit"));
        ogSpherCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("sphereGauche"));
        ogAxeCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("axeGauche"));
        verreCol.setCellValueFactory(new PropertyValueFactory<Client, String>("typeDeVerre"));
        mutuelleCol.setCellValueFactory(new PropertyValueFactory<Client, String>("mutuelle"));

        clients.setItems(clientList);

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
    private void refreshTable(ActionEvent event) {
        try {
            clientList.clear();

            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            ResultSet resultSet = connectDB.createStatement().executeQuery("SELECT * FROM clients");


            while (resultSet.next()){
                clientList.add(new Client(resultSet.getInt("id_client"),
                        resultSet.getString("nom"),
                        resultSet.getString("Prenom"),
                        resultSet.getString("Email"),
                        resultSet.getString("Address"),
                        resultSet.getLong("Telephone"),
                        resultSet.getString("Medcin"),

                        resultSet.getDouble("addd"),
                        resultSet.getDouble("sphere_droit"),
                        resultSet.getDouble("sphere_gauche"),
                        resultSet.getDouble("cylindre_droit"),
                        resultSet.getDouble("cylindre_gauche"),
                        resultSet.getDouble("axe_gauche"),
                        resultSet.getDouble("axe_droit"),
                        resultSet.getString("verre"),
                        resultSet.getString("mutuelle")
                ));

                clients.setItems(clientList);

            }


        } catch (SQLException ex) {
            Logger.getLogger(CustomerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }



    }





    @FXML
    public void openAddCustmerScreen() throws IOException{
        root = FXMLLoader.load(getClass().getResource("addCustomerScreen.fxml"));
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void deleteCustomer() {

        Client client = clients.getSelectionModel().getSelectedItem();
        clients.getItems().removeAll(client);


        int id = client.getId();

        String delete = "DELETE FROM clients WHERE id_client = "+id+"";

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
    void updateCustomer(ActionEvent event) throws IOException {


        Client person = clients.getSelectionModel().getSelectedItem();
        int id = person.getId();
        String lname = person.getNom();
        String fname = person.getPrenom();
        String e_mail= person.getEmail();
        String add_ress= person.getAddress();
        String tel= String.valueOf(person.getTelephone());
        String doctor= person.getMedcin();

        String addition= String.valueOf(person.getAdd());;
        String sphd= String.valueOf(person.getSphereDroit());;
        String sphg= String.valueOf(person.getSphereGauche());;
        String cyld= String.valueOf(person.getCylindreDroit());;
        String cylg= String.valueOf(person.getCylindreGauche());;
        String axed= String.valueOf(person.getAxeDroit());;
        String axeg= String.valueOf(person.getAxeGauche());;
        String verre_type= person.getTypeDeVerre();
        String assurance= person.getMutuelle();







        FXMLLoader loader = new FXMLLoader(getClass().getResource("updateCustomerScreen.fxml"));
        root = loader.load();

        UpdateCustomerScreenController updateCustomerScreenController = loader.getController();
        updateCustomerScreenController.displayName(lname,fname,e_mail,add_ress,tel,doctor,
                sphd,sphg,cyld,cylg,axed, axeg,verre_type,assurance,addition,id);

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
