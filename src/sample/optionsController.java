package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.awt.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class optionsController {
    static Stage primaryStage = new Stage();

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

    public static Boolean smallText = FALSE;
    public static Boolean mediumText = FALSE;
    public static Boolean largeText = FALSE;

    public static String fontSize = "Quiz.css";







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





    public void smallFontButton() throws Exception {

        smallTextSizeButton.setSelected(true);
        mediumTextSizeButton.setSelected(false);
        largeTextSizeButton.setSelected(false);
        smallTextSize();





    }

    public void mediumFontButton() throws Exception {



        smallTextSizeButton.setSelected(false);
        mediumTextSizeButton.setSelected(true);
        largeTextSizeButton.setSelected(false);
        mediumTextSize();





    }

    public void largeFontButton() throws Exception {

        smallTextSizeButton.setSelected(false);
        mediumTextSizeButton.setSelected(false);
        largeTextSizeButton.setSelected(true);
        largeTextSize();



    }


public  void smallTextSize ()throws Exception {


        smallText = TRUE;
        mediumText = FALSE;
        largeText = FALSE;
    fontSize = "/Sample/Quiz.css";
    rootPane.getStylesheets().clear();
    rootPane.getStylesheets().add(optionsController.fontSize);






}

 public  void mediumTextSize ()throws Exception {




        smallText = FALSE;
        mediumText = TRUE;
        largeText = FALSE;
     fontSize = "/Sample/fontMedium.css";
     rootPane.getStylesheets().clear();
     rootPane.getStylesheets().add(optionsController.fontSize);






    }

 public static  void largeTextSize() {
     fontSize = "/Sample/fontLarge.css";
         smallText = FALSE;
         mediumText = FALSE;
         largeText = TRUE;

     }




    public static void noBackgroundColorButton(Rectangle R) {

    R.setVisible(false);
    noTint = TRUE;
    yellowTint = FALSE;
    blueTint = FALSE;

}

public static void yellowTintButton(Rectangle R) {
    R.setFill((Color.rgb(255,255,0, 0.3)));
    R.setVisible(true);
    yellowTint = TRUE;
    blueTint = FALSE;
    noTint = FALSE;

}


public static void blueTintButton (Rectangle R) {

            R.setFill((Color.rgb(0,0,255, 0.3)));
            R.setVisible(true);
            blueTint = TRUE;
            yellowTint = FALSE;
            noTint = FALSE;

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
        Main.currentPage = "sample.fxml";
        m.start(primaryStage);



    }


    public void infoButtonClicked() throws Exception {

        c.infoButton();
    }

    public void quizButtonClicked() throws Exception {
        closePage();
        Main.currentPage = "welcomeQuiz.fxml";
        m.start(primaryStage);

    }


    public void closePage() throws Exception {

        Window window = rootPane.getScene().getWindow();
        if (window instanceof Stage) {


            ((Stage) window).close();
        }
    }


}
