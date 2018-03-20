package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Cursor;


import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import javax.swing.*;
import javax.tools.Tool;


public class phoneController extends Application {

Stage primaryStage = new Stage();


    @FXML
    AnchorPane rootPane;
    @FXML
    StackPane infomationPane;
    @FXML
    Text frontText;
    @FXML
    Text backText;
    @FXML
    private  Rectangle phoneBody;
    @FXML
    private  Rectangle touchScreen;
    @FXML
    private  Rectangle volumeRocker;
    @FXML
    private  Rectangle chargingPort;
    @FXML
    private  Rectangle sleepWakeButton;
    @FXML
    private  Rectangle navBar;
    @FXML
    private  Rectangle multiTask1;
    @FXML
    private  Rectangle multiTask2;

    @FXML
    private Rectangle frontSpeaker;
    @FXML
    private  Circle camera;
    @FXML
    private  Circle ambientLightSensor;
    @FXML
    private  Circle proximitySensor;
    @FXML
    private  Circle homeButton;
    @FXML
    private Polygon backButton;


    //Back of phone

    @FXML
    private  Rectangle phoneBodyBack;
    @FXML
    private Rectangle fingerPrintScanner;
    @FXML
    private  Rectangle chargingPortRear;
    @FXML
    private Circle rearCameraColour;
    @FXML
    private Circle rearCameraBlackAndWhite;
    @FXML
    private Circle flash;
    @FXML
    private Rectangle rearSpeaker1;
    @FXML
    private Rectangle rearSpeaker2;
    @FXML
    private Rectangle rearSpeaker3;
    @FXML
    private Rectangle rearSpeaker4;



    @FXML
    private Rectangle descriptionArea;
    @FXML
    private Text descriptionLabel;
    @FXML
    private Text descriptionText;
    @FXML
    private Button hardwareButton;
    @FXML
    private Button backToPhoneButton;
    @FXML
    private static Button menuButton;
    @FXML
    private static Button settingsButton;
    @FXML
    private static Button infoButton;
    @FXML
    private static Button quizButton;



    Controller c = new Controller();
    Main m  = new Main();

    public  void menuButtonClicked() throws Exception {


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
    public void backToTool () {
        frontText.setVisible(true);
        backText.setVisible(true);
        descriptionArea.setVisible(false);
        descriptionLabel.setVisible(false);
        descriptionText.setVisible(false);
        hardwareButton.setVisible(false);
        backToPhoneButton.setVisible(false);
    }


    public void sensorDescription (String sensorTitle, String sensorDescription) {



        frontText.setVisible(false);
        backText.setVisible(false);
        descriptionArea.setVisible(true);
        descriptionLabel.setVisible(true);
        descriptionText.setVisible(true);
        hardwareButton.setVisible(true);
        backToPhoneButton.setVisible(true);

        backToPhoneButton.setOnAction(e -> backToTool() );

        descriptionLabel.setText(sensorTitle);
        descriptionText.setText(sensorDescription);
        String[] args = {};

        hardwareButton.setOnAction(e-> Hardware.main(args));


    }




    public void TooltipFeatures (String description, Shape shape)
    {
        final Tooltip toolTip = new Tooltip();
        toolTip.setText(description);
        Tooltip.install(shape, toolTip);
        toolTip.setShowDelay(Duration.millis(1));
        shape.setCursor(Cursor.HAND);
    }


    // Each sensor has its own class, easier to manage and change code.
    public void touchScreenMouseOver()  {
        TooltipFeatures("Touchscreen", touchScreen);



    }

    public void touchScreenClicked() throws Exception {

        sensorDescription("Touch Screen", "This is the touchscreen. It does all of these things");


    }


    public void cameraMouseover() {

        TooltipFeatures("Front Camera", camera);
    }


    public void cameraClicked() {

        System.out.println("This is the camera");
    }

    public void frontSpeakerMouseOver() {

        TooltipFeatures("Front Speaker", frontSpeaker);

    }
    public void frontSpeakerClicked() {

        System.out.println("This is the front Speaker");
    }


    public void ambientLightSensorMouseOver() {

        TooltipFeatures("Ambient Light Sensor", ambientLightSensor);

    }
    public void ambientLightSensorClicked() {

        System.out.println("This is the Light Sensor");
    }

    public void proximitySensorMouseOver() {
        TooltipFeatures("Proximity Sensor", proximitySensor);

    }
    public void proximitySensorClicked() {

        System.out.println("This is the Proximity Sensor");
    }

    public void volumeRockerMouseOver() {
        TooltipFeatures("Volume Rocker", volumeRocker);

    }

    public void volumeRockerClicked() {

        System.out.println("This is the volume Rocker");
    }

    public void sleepWakeButtonMouseover() {

        TooltipFeatures("Sleep/Wake Button", sleepWakeButton);
    }
    public void sleepWakeButtonClicked() {

        System.out.println("This is the sleep/wake button");

    }

    public void navigationBarMouseOver() {
        TooltipFeatures("Navigation Bar", navBar);

    }

    public void navigationBarClicked() {

        System.out.println("This is the navigation bar");
    }

    public void backButtonMouseOver() {
        TooltipFeatures("Back Button", backButton);

    }
    public void backButtonClicked() {

        System.out.println("This is the back button");
    }

    public void homeButtonMouseOver() {
        TooltipFeatures("Home Button", homeButton);


    }
    public void homeButtonClicked() {

        System.out.println("This is the home button");
    }

    public void multiTaskingButtonMouseOver() {
        TooltipFeatures("Multi Tasking Button", multiTask1);
        TooltipFeatures("Multi Tasking Button", multiTask2);


    }
    public void multiTaskingButtonClicked() {

        System.out.println("This is the multi tasking button");
    }

    public void chargingPortMouseOver() {
        TooltipFeatures("Charging Port", chargingPort);
        TooltipFeatures("Charging Port", chargingPortRear);

    }

    public void phoneBodyBackClicked() {

    }
    public void phoneBodyBackMouseOver() {
        TooltipFeatures("Phone body", phoneBodyBack);

    }

    public void   fingerPrintScannerMouseOver() {
    TooltipFeatures("Fingerprint Scanner", fingerPrintScanner);
    }

    public void FingerPrintScannerClicked() {

    }

    public void rearSpeakerClicked() {


    }

    public void rearSpeakerMouseOver() {
        TooltipFeatures("Rear Speakers", rearSpeaker1);
        TooltipFeatures("Rear Speakers",rearSpeaker2);
        TooltipFeatures("Rear Speakers", rearSpeaker3);
        TooltipFeatures("Rear Speakers", rearSpeaker4);
    }
    public void RearCameraColourClicked(){


    }

    public void RearCameraColourMouseOver() {
        TooltipFeatures("Rear camera - Colour version", rearCameraColour);
    }

    public void RearCameraBlackAndWhiteClicked() {
        TooltipFeatures("Rear camera - Black and white", rearCameraBlackAndWhite);

    }

    public void RearCameraBlackAndWhiteMouseOver() {
        TooltipFeatures("Rear camera - Black and white", rearCameraBlackAndWhite);
    }

    public void flashClicked() {

    }

    public void flashMouseOver() {
        TooltipFeatures("Flash", flash);

    }


    public void chargingPortClicked() {

        System.out.println("This is the Charging Port");
    }


    public static void main(String[] args) {
        launch(args);

    }

    public void closePage() {

        Window window = rootPane.getScene().getWindow();
        if (window instanceof Stage){
            ((Stage) window).close();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {


    }
}