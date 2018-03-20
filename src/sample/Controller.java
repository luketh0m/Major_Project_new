package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;


public class Controller {

    @FXML
    public AnchorPane rootPane;

    @FXML
    public Rectangle touchScreen;

@FXML
Button startButton;
@FXML
Button settingsButton;
@FXML

Button aboutButton;
@FXML
Button quizButton;

    public void mouseOver(Button button) {

        button.setCursor(Cursor.HAND);
    }


    public void startButtonMouseOver() {
       mouseOver(startButton);
    }
    public void settingsButtonMouseOver() {
        mouseOver(settingsButton);
    }
    public void aboutButtonMouseOver() {
        mouseOver(aboutButton);
    }
    public void quizButtonMouseOver() {
        mouseOver(quizButton);
    }

    public void startButton() throws Exception { //When user clicks the start button, load the Phone.fxml file
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Phone.fxml"));
        rootPane.getChildren().setAll(pane);


    }

    public void settingsButton() throws Exception { //When user clicks the start button, load the Phone.fxml file
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Options.fxml"));
        rootPane.getChildren().setAll(pane);


    }

    public void infoButton() {

        alertBox.display("Info", "Version 1.0, Alpha", "Got it!");

    }

    public void quizButton() throws Exception {

        Quiz.quizMenu();


    }


}