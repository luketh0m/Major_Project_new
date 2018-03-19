package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    DBconnect DB = new DBconnect();

    @Override
    public void start(Stage primaryStage) throws Exception{ // Load FXML document and display on screen
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Start");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);



    }


    public void closeWindow(Stage primaryStage) {

        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
