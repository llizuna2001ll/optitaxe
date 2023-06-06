package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class UpdateCustomerScreenController implements Initializable {

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
        private TextField prenom;

        @FXML
        private TextField email;

        @FXML
        private TextField address;

        @FXML
        private Button modifier;

        @FXML
        private Button Cancel;

        @FXML
        private Label addingLabel;

        @FXML
        private TextField telephone;

        @FXML
        private TextField medcin;


        @FXML
        private TextField sphDroit;

        @FXML
        private TextField sphGauche;

        @FXML
        private TextField cylDroit;

        @FXML
        private TextField cylGauche;

        @FXML
        private TextField axeDroit;

        @FXML
        private TextField axeGauche;

        @FXML
        private TextField diamDroit;

        @FXML
        private TextField diamGauche;

        @FXML
        private TextField verre;

    @FXML
    private ChoiceBox<String> mutuelle;
    private final String[] typeMutuelle = {"Aucune","Atlanta", "AXA","CNOPS","MFAR","RMA","SAHAM","Wafa Assurance","Zurich"};

        @FXML
        private TextField add;

        @FXML
        private Button clear;

        int id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mutuelle.setValue("Selectioner");
        mutuelle.getItems().addAll(typeMutuelle);
        telephone.setText("+212");



    }

    public void displayName(String name,String lname,String mail,String adresse, String tele, String doc, String sphD, String sphG, String cylD,
                            String cylG,String axeD, String axeG, String glass, String assurance,String addition,int idd) {
        nom.setText(name);
        prenom.setText(lname);
        email.setText(mail);
        address.setText(adresse);
        telephone.setText(tele);
        medcin.setText(doc);
        sphDroit.setText(sphD);
        sphGauche.setText(sphG);
        cylDroit.setText(cylD);
        cylGauche.setText(cylG);
        axeDroit.setText(axeD);
        axeGauche.setText(axeG);
        verre.setText(glass);
        mutuelle.setValue(assurance);
        add.setText(addition);
        id = idd;
    }

    @FXML
    void Cancel(ActionEvent event)  {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }


    @FXML
    void clear(ActionEvent event) {
        nom.clear();
        prenom.clear();
        email.clear();
        address.clear();
        telephone.clear();
        medcin.clear();

        add.clear();
        sphDroit.clear();
        sphGauche.clear();
        cylDroit.clear();
        cylGauche.clear();
        axeDroit.clear();
        axeGauche.clear();
        verre.clear();
        diamDroit.clear();
        diamGauche.clear();
        mutuelle.setValue("Selectionner");
        telephone.setText("212");


    }


        @FXML
        void update(ActionEvent event) {


            String lname = nom.getText();
            String fname = prenom.getText();
            String e_mail = email.getText();
            String add_ress = address.getText();
            String tel = telephone.getText();
            String doctor = medcin.getText();

            String addition = add.getText();
            String sphd = sphDroit.getText();
            String sphg = sphGauche.getText();
            String cyld = cylDroit.getText();
            String cylg = cylGauche.getText();
            String axed = axeDroit.getText();
            String axeg = axeGauche.getText();
            String verre_type = verre.getText();

            String assurance = mutuelle.getValue();

            if (nom.getText() ==""  || prenom.getText()==""  || telephone.getText()==""  || medcin.getText() =="" ||

                      add.getText() ==""  || sphGauche.getText() =="" || sphDroit.getText() == ""  ||

                    cylDroit.getText() ==""  || cylGauche.getText() ==""  || axeDroit.getText() ==""  || axeGauche.getText() ==""  ||

                    verre.getText() == ""  ||  mutuelle.getValue() != null) addingLabel.setText("Fulfill all the elements");


                else {
                String insertFields = "UPDATE  clients SET nom = '" + lname +
                        "',prenom = '" + fname +
                        "',address = '" + add_ress +
                        "',telephone = '" + tel +
                        "',email= '" + e_mail +
                        "',medcin = '" + doctor +

                        "',addd = '" + addition +
                        "',sphere_droit = '" + sphd +
                        "',sphere_gauche = '" + sphg +
                        "',cylindre_droit = '" + cyld +
                        "',cylindre_gauche = '" + cylg +
                        "',axe_droit = '" + axed +
                        "',axe_gauche = '" + axeg +
                        "',verre = '" + verre_type +
                        "',mutuelle = '" + assurance + "' WHERE id_client='" + id + "'";


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

}


