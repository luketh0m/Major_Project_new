package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;
import static java.lang.Boolean.TRUE;

public class Main extends Application {

    DBconnect DB = new DBconnect();
    public static String currentPage = "sample.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception { // Load FXML document and display on screen
        if (optionsController.fontSize == null) {
            optionsController.fontSize = "/Sample/fontSmall.css"; //check is font size is set, if not set to small
        }

        Parent root = FXMLLoader.load(getClass().getResource(currentPage));
        root.getStylesheets().add(optionsController.fontSize);
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600); //load scene

    }
    public void closeWindow(Stage primaryStage) {
        primaryStage.close(); //close stage
    }

    public static void main(String[] args) {
        launch(args); //launch application
    }
}
