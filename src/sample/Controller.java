package sample;

import gnu.io.NoSuchPortException;
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


    @FXML
 Rectangle Tint;

   public AnchorPane pane;






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

    public void appAcessed() {
        optionsController.tintOptions(Tint);
        System.out.print("Accessed");

    }

    public void startButton()  throws Exception { //When user clicks the start button, load the Phone.fxml file

        pane = FXMLLoader.load(getClass().getResource("Phone.fxml"));
        rootPane.getChildren().setAll(pane);
        Hardware.pingTest();
        rootPane.getStylesheets().add(optionsController.fontSize);



    }

    public void settingsButton() throws Exception { //When user clicks the start button, load the Phone.fxml file
         pane = FXMLLoader.load(getClass().getResource("Options.fxml"));
        rootPane.getChildren().setAll(pane);
        rootPane.getStylesheets().add(optionsController.fontSize);




    }

    public void infoButton() {

        alertBox.display("Info", "Version 1.0, Alpha", "Got it!");

    }

    public void quizButton() throws Exception {

         pane = FXMLLoader.load(getClass().getResource("welcomeQuiz.fxml"));
        rootPane.getChildren().setAll(pane);

        rootPane.getStylesheets().add(optionsController.fontSize);



    }


}