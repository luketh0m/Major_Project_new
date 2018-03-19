package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class optionsController {
    Stage primaryStage = new Stage();

    @FXML
    AnchorPane rootPane;

    Controller c = new Controller();
    Main m = new Main();


    public void menuButtonClicked() throws Exception {


        closePage();
        m.start(primaryStage);

    }


    public void infoButtonClicked() throws Exception {

        c.infoButton();
    }

    public void quizButtonClicked() throws Exception {
        closePage();
        Quiz.quizMenu();

    }


    public void closePage() throws Exception {

        Window window = rootPane.getScene().getWindow();
        if (window instanceof Stage) {


            ((Stage) window).close();
        }
    }


}
