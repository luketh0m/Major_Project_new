package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.awt.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class optionsController {
    Stage primaryStage = new Stage();

    @FXML
    AnchorPane rootPane;

    @FXML
    Button soundButton;


@FXML
    RadioButton noBackgroundColorButton;
@FXML
    RadioButton yellowBackgroundColorButton;
@FXML
    RadioButton blueBackgroundColorButton;


    @FXML
    RadioButton smallTextSizeButton;
    @FXML
    RadioButton mediumTextSizeButton;
    @FXML
    RadioButton largeTextSizeButton;

    @FXML Rectangle Tint;


public  Boolean soundEnabled = true;

public static Boolean noTint = FALSE;
public static Boolean yellowTint = FALSE;
public static Boolean blueTint = FALSE;


    public static void tintOptions (Rectangle Tint) {
        if (optionsController.blueTint == TRUE) {
            optionsController.blueTintButton(Tint);
        }

       else if (optionsController.yellowTint == TRUE) {
            optionsController.yellowTintButton(Tint);

        }
       else if (optionsController.noTint == TRUE) {
            optionsController.noBackgroundColorButton(Tint);
        }
    }





    public static void noBackgroundColorButton(Rectangle R) {

    R.setVisible(false);
    noTint = TRUE;

}

public static void yellowTintButton(Rectangle R) {
    R.setFill((Color.rgb(255,255,0, 1.0)));
    R.setVisible(true);
    yellowTint = TRUE;

}


public static void blueTintButton (Rectangle R) {

            R.setFill((Color.rgb(0,0,255, 0.2)));
            R.setVisible(true);
            blueTint = TRUE;

    }

    Controller c = new Controller();
    Main m = new Main();




public void noTint() {
    noBackgroundColorButton(Tint);
    yellowBackgroundColorButton.setSelected(false);
    blueBackgroundColorButton.setSelected(false);


}
public void yellowTint() {
    yellowTintButton(Tint);
    noBackgroundColorButton.setSelected(false);
    blueBackgroundColorButton.setSelected(false);
}
public void blueTint(){
    blueTintButton(Tint);
    yellowBackgroundColorButton.setSelected(false);
    noBackgroundColorButton.setSelected(false);
}




    public void menuButtonClicked() throws Exception {


        closePage();
        m.start(primaryStage);
        System.out.print("On the controller page the yellow tint it" + yellowTint);


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
