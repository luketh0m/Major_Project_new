package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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

    @FXML
    Rectangle Tint;

    @FXML
    Text fontStyle;
    @FXML
    RadioButton normalFontButton;
    @FXML
    RadioButton funFontButton;
    @FXML
    ToggleButton volumeSetter;

    @FXML
    RadioButton soundOffButton;
    @FXML
    RadioButton soundOnButton;

    public static Boolean soundEnabled = TRUE;

    public static Boolean noTint = FALSE;
    public static Boolean yellowTint = FALSE;
    public static Boolean blueTint = FALSE;

    public static Boolean smallText = FALSE;
    public static Boolean mediumText = FALSE;
    public static Boolean largeText = FALSE;

    public static String fontSize;

    public static Boolean fontNormal = FALSE;
    public static Boolean fontFun = TRUE;


    public void soundOn() {
        soundEnabled = true;

        soundOffButton.setSelected(false);
        soundOnButton.setSelected(true);

    }

    public void soundOff() {
        soundEnabled = false;
        soundOffButton.setSelected(true);
        soundOnButton.setSelected(false);


    }


    public static void tintOptions(Rectangle Tint) {
        if (optionsController.blueTint == TRUE) {
            optionsController.blueTintButton(Tint);
        } else if (optionsController.yellowTint == TRUE) {
            optionsController.yellowTintButton(Tint);

        } else if (optionsController.noTint == TRUE) {
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


    public void smallTextSize() throws Exception {


        smallText = TRUE;
        mediumText = FALSE;
        largeText = FALSE;
        fontSize = fontSize.replaceAll("Medium", "Small");
        fontSize = fontSize.replaceAll("Large", "Small");
        rootPane.getStylesheets().clear();
        rootPane.getStylesheets().add(optionsController.fontSize);


    }

    public void mediumTextSize() {


        smallText = FALSE;
        mediumText = TRUE;
        largeText = FALSE;
        fontSize = fontSize.replaceAll("Small", "Medium");
        fontSize = fontSize.replaceAll("Large", "Medium");
        rootPane.getStylesheets().clear();
        rootPane.getStylesheets().add(optionsController.fontSize);


    }

    public void largeTextSize() {
        fontSize = fontSize.replaceAll("Small", "Large");
        fontSize = fontSize.replaceAll("Medium", "Large");
        rootPane.getStylesheets().clear();
        rootPane.getStylesheets().add(optionsController.fontSize);
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
        R.setFill((Color.rgb(255, 255, 0, 0.3)));
        R.setVisible(true);
        yellowTint = TRUE;
        blueTint = FALSE;
        noTint = FALSE;

    }


    public static void blueTintButton(Rectangle R) {

        R.setFill((Color.rgb(0, 0, 255, 0.3)));
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

    public void blueTint() {
        blueTintButton(Tint);
        yellowBackgroundColorButton.setSelected(false);
        noBackgroundColorButton.setSelected(false);
    }


    public void setFontNormal() {

        if (fontNormal != TRUE) {
            fontNormal = TRUE;
            fontFun = FALSE;
            funFontButton.setSelected(FALSE);
            normalFontButton.setSelected(TRUE);
            fontSize = fontSize.replaceAll(".css", "FamilyNormal.css");
            rootPane.getStylesheets().clear();
            rootPane.getStylesheets().add(optionsController.fontSize);
        } else {
            alertBox.display("Already Selected!", "You've already chosen this font", "Okay");
        }


    }

    public void setFontFun() {

        if (fontFun != TRUE) {
            fontFun = TRUE;
            fontNormal = FALSE;
            funFontButton.setSelected(TRUE);
            normalFontButton.setSelected(FALSE);
            fontSize = fontSize.replaceAll("FamilyNormal.css", ".css");
            rootPane.getStylesheets().clear();
            rootPane.getStylesheets().add(optionsController.fontSize);


        } else {
            alertBox.display("Already Selected!", "You've already chosen this font", "Okay");
        }
    }

    public void menuButtonClicked() throws Exception {


        closePage();

        Main.currentPage = "sample.fxml";
        rootPane.getStylesheets().add(optionsController.fontSize);
        m.start(primaryStage);


    }

    public void toolkitButtonClicked() throws Exception {


        closePage();

        Main.currentPage = "Phone.fxml";
        rootPane.getStylesheets().add(optionsController.fontSize);
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
