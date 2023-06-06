package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {





    @Override
     public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("menuScreen.fxml"));
            stage.initStyle(StageStyle.UNDECORATED);


            Scene scene = new Scene(root);

            String css = this.getClass().getResource("button.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.show();
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
