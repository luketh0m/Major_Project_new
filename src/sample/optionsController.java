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
import java.lang.reflect.Method;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class optionsController {
    static Stage primaryStage = new Stage();

    Controller c = new Controller();
    Main m = new Main();

    @FXML
    AnchorPane rootPane;

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
        //set sound boolean to true, and select radio button
        soundEnabled = true;
        soundOffButton.setSelected(false);
        soundOnButton.setSelected(true);
    }

    public void soundOff() {
        //set sound boolean to false, and select radio button
        soundEnabled = false;
        soundOffButton.setSelected(true);
        soundOnButton.setSelected(false);
    }

    public static void tintOptions(Rectangle Tint) {
        //check what button is selected, and adjust background colour accordingly
        if (optionsController.blueTint == TRUE) {
            optionsController.blueTintButton(Tint);

        } else if (optionsController.yellowTint == TRUE) {
            optionsController.yellowTintButton(Tint);

        } else if (optionsController.noTint == TRUE) {
            optionsController.noBackgroundColorButton(Tint);
        }
    }

    public void smallFontButton() {
        //set small font button to true and run smallTextSize method
        smallTextSizeButton.setSelected(true);
        mediumTextSizeButton.setSelected(false);
        largeTextSizeButton.setSelected(false);
        smallTextSize();
    }

    public void mediumFontButton() {
        //set medium font button to true and run smallTextSize method
        smallTextSizeButton.setSelected(false);
        mediumTextSizeButton.setSelected(true);
        largeTextSizeButton.setSelected(false);
        mediumTextSize();
    }

    public void largeFontButton() {
        //set medium font button to true and run smallTextSize method
        smallTextSizeButton.setSelected(false);
        mediumTextSizeButton.setSelected(false);
        largeTextSizeButton.setSelected(true);
        largeTextSize();
    }

    public void smallTextSize() {
// sets boolean of smallText to true, and alters css accordingly, clears and re-adds stylesheet for correct CSS
        smallText = TRUE;
        mediumText = FALSE;
        largeText = FALSE;
        fontSize = fontSize.replaceAll("Medium", "Small");
        fontSize = fontSize.replaceAll("Large", "Small");
        rootPane.getStylesheets().clear();
        rootPane.getStylesheets().add(optionsController.fontSize);
    }

    public void mediumTextSize() {
        // sets boolean of mediumText to true, and alters css accordingly, clears and re-adds stylesheet for correct CSS
        smallText = FALSE;
        mediumText = TRUE;
        largeText = FALSE;
        fontSize = fontSize.replaceAll("Small", "Medium");
        fontSize = fontSize.replaceAll("Large", "Medium");
        rootPane.getStylesheets().clear();
        rootPane.getStylesheets().add(optionsController.fontSize);
    }

    public void largeTextSize() {
        // sets boolean of largeText to true, and alters css accordingly, clears and re-adds stylesheet for correct CSS
        fontSize = fontSize.replaceAll("Small", "Large");
        fontSize = fontSize.replaceAll("Medium", "Large");
        rootPane.getStylesheets().clear();
        rootPane.getStylesheets().add(optionsController.fontSize);
        smallText = FALSE;
        mediumText = FALSE;
        largeText = TRUE;
    }

    public static void noBackgroundColorButton(Rectangle R) {
        // removes background tint
        R.setVisible(false);
        noTint = TRUE;
        yellowTint = FALSE;
        blueTint = FALSE;
    }

    public static void yellowTintButton(Rectangle R) {
        // adds yellow background tint
        R.setFill((Color.rgb(255, 255, 0, 0.3)));
        R.setVisible(true);
        yellowTint = TRUE;
        blueTint = FALSE;
        noTint = FALSE;
    }

    public static void blueTintButton(Rectangle R) {
        // adds blue background tint
        R.setFill((Color.rgb(0, 0, 255, 0.3)));
        R.setVisible(true);
        blueTint = TRUE;
        yellowTint = FALSE;
        noTint = FALSE;
    }


    public void noTint() {
        //removes selected radio buttons, runs no background colour function
        noBackgroundColorButton(Tint);
        yellowBackgroundColorButton.setSelected(false);
        blueBackgroundColorButton.setSelected(false);
    }

    public void yellowTint() {
        //removes selected radio buttons, runs yellow background colour function
        yellowTintButton(Tint);
        noBackgroundColorButton.setSelected(false);
        blueBackgroundColorButton.setSelected(false);
    }

    public void blueTint() {
        //removes selected radio buttons, runs blue background colour function
        blueTintButton(Tint);
        yellowBackgroundColorButton.setSelected(false);
        noBackgroundColorButton.setSelected(false);
    }


    public void setFontNormal() {
        //sets font to normal (Ariel)
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
        //sets font to normal (Crulz MT)
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
        //takes user back to main menu
        closePage();
        Main.currentPage = "sample.fxml";
        rootPane.getStylesheets().add(optionsController.fontSize);
        m.start(primaryStage);
    }

    public void toolkitButtonClicked() throws Exception {
        //takes user back to toolkit
        closePage();
        Main.currentPage = "Phone.fxml";
        rootPane.getStylesheets().add(optionsController.fontSize);
        m.start(primaryStage);
    }

    public void infoButtonClicked() {
        //displays app info
        c.infoButton();
    }

    public void quizButtonClicked() throws Exception {
        //takes user back to quiz
        closePage();
        Main.currentPage = "welcomeQuiz.fxml";
        m.start(primaryStage);
    }

    public void closePage() {
        //closes current window
        Window window = rootPane.getScene().getWindow();
        if (window instanceof Stage) {

            ((Stage) window).close();
        }
    }

}
