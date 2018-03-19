package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.fxml.*;
import javafx.stage.PopupWindow;
import javax.tools.Tool;


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