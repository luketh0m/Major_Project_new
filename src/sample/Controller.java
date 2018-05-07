package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static java.lang.Boolean.TRUE;


public class Controller {
    @FXML
    public AnchorPane rootPane;
    @FXML
    Rectangle touchScreen;
    @FXML
    Button startButton;
    @FXML
    Button settingsButton;
    @FXML
    Button aboutButton;
    @FXML
    Button quizButton;

    @FXML
    Rectangle Tint;

    public AnchorPane pane;



    public void appAcessed() {
        //Applies background colour
        optionsController.tintOptions(Tint);
    }

    public void startButton() throws Exception {
        //When user clicks the start button, load the Phone.fxml file
        pane = FXMLLoader.load(getClass().getResource("Phone.fxml"));
        rootPane.getChildren().setAll(pane);
        Hardware.pingTest();
        rootPane.getStylesheets().add(optionsController.fontSize);
    }

    public void settingsButton() throws Exception {
        //When user clicks the settings button, load the Options.fxml file
        pane = FXMLLoader.load(getClass().getResource("Options.fxml"));
        rootPane.getChildren().setAll(pane);
        rootPane.getStylesheets().add(optionsController.fontSize);
    }

    public void infoButton() {
    //display application information
        alertBox.display("Info", "Version 2.0, Beta. Release date March 2018. Author lut14@aber.ac.uk", "Got it!");
    }

    public void quizButton() throws Exception {
        //When user clicks the quiz button, load the welcome quiz file
        pane = FXMLLoader.load(getClass().getResource("welcomeQuiz.fxml"));
        rootPane.getChildren().setAll(pane);
        rootPane.getStylesheets().add(optionsController.fontSize);
    }
}