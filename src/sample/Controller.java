package sample;

import com.sun.istack.internal.NotNull;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.fxml.*;
import javafx.stage.PopupWindow;
import javax.tools.Tool;

public class Controller {

    @FXML
    public AnchorPane rootPane;


        @FXML
       private Button startButton;





    public void startButtonClicked(ActionEvent event) throws Exception { //When user clicks the start button, load the Phone.fxml file

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Phone.fxml"));
        rootPane.getChildren().setAll(pane);


    }

    public void optionsButton(ActionEvent event) throws Exception { //When user clicks the start button, load the Phone.fxml file
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



