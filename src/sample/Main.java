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
    public void start(Stage primaryStage) throws Exception{ // Load FXML document and display on screen


        Parent root = FXMLLoader.load(getClass().getResource(currentPage));
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        System.out.print("on the main page the yellow tint option is" + optionsController.yellowTint);





    }




    public void closeWindow(Stage primaryStage) {

        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);



    }
}
