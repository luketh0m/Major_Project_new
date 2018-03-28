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
import org.w3c.dom.css.Rect;

import javax.swing.*;
import javax.tools.Tool;




public class phoneController extends Application {

Stage primaryStage = new Stage();



Boolean flashOn = false;

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
    private  Rectangle volumeRockerRear;
    @FXML
    private  Rectangle sleepWakeButtonRear;




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

        backToPhoneButton.setOnAction(e -> backToTool());

        descriptionLabel.setText(sensorTitle);
        descriptionText.setText(sensorDescription);



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

        sensorDescription("Camera", "Desc");
    }

    public void frontSpeakerMouseOver() {

        TooltipFeatures("Front Speaker", frontSpeaker);

    }
    public void frontSpeakerClicked() {

       sensorDescription("Front speaker", "Desc");
       hardwareButton.setOnAction(e-> Hardware.frontSpeakerOn());

    }


    public void ambientLightSensorMouseOver() {

        TooltipFeatures("Ambient Light Sensor", ambientLightSensor);

    }
    public void ambientLightSensorClicked() {
sensorDescription("Ambient Light sensor", "Desc");

    hardwareButton.setOnAction(e-> Hardware.ambientLightSensor());


    }

    public void proximitySensorMouseOver() {
        TooltipFeatures("Proximity Sensor", proximitySensor);

    }
    public void proximitySensorClicked() {

      sensorDescription("Proximimty Sensor", "Desc");
    }

    public void volumeRockerMouseOver() {
        TooltipFeatures("Volume Rocker", volumeRocker);
        TooltipFeatures("Volume Rocker", volumeRockerRear);

    }

    public void volumeRockerClicked() {

        sensorDescription("Volume Rocker", "Volume Rocker");

    }



    public void sleepWakeButtonMouseover() {

        TooltipFeatures("Sleep/Wake Button", sleepWakeButton);

    }
    public void sleepWakeButtonClicked() {

        sensorDescription("Sleep/ Wake Button Clicked", "Sleep/wae");


    }
    public void setSleepWakeButtonRearMouseOver() {
        TooltipFeatures("Sleep/Wake Button", sleepWakeButtonRear);

    }

    public void navigationBarMouseOver() {
        TooltipFeatures("Navigation Bar", navBar);

    }

    public void navigationBarClicked() {

      sensorDescription("Navigation bar", "Nav bar");
    }

    public void backButtonMouseOver() {
        TooltipFeatures("Back Button", backButton);

    }
    public void backButtonClicked() {

        sensorDescription("Back button", "Button");


    }

    public void homeButtonMouseOver() {
        TooltipFeatures("Home Button", homeButton);


    }
    public void homeButtonClicked() {

        sensorDescription("Home button","Home Button");

    }

    public void multiTaskingButtonMouseOver() {
        TooltipFeatures("Multi Tasking Button", multiTask1);
        TooltipFeatures("Multi Tasking Button", multiTask2);


    }
    public void multiTaskingButtonClicked() {

           sensorDescription("Multi Tasking Button", "Dess");

    }

    public void chargingPortMouseOver() {
        TooltipFeatures("Charging Port", chargingPort);
        TooltipFeatures("Charging Port", chargingPortRear);

    }

    public void phoneBodyBackClicked() {

        sensorDescription("Phone Body", "Phone Body is made of...");


    }
    public void phoneBodyBackMouseOver() {
        TooltipFeatures("Phone body", phoneBodyBack);

    }

    public void   fingerPrintScannerMouseOver() {
    TooltipFeatures("Fingerprint Scanner", fingerPrintScanner);
    }

    public void FingerPrintScannerClicked() {
        sensorDescription("Fingerprint Scanner", "Finger print Scanner");

    }

    public void rearSpeakerClicked() {
        sensorDescription("Rear Speaker", "Rear Speaker Clicked");
        hardwareButton.setOnAction(e-> Hardware.rearSpeakerOn());

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

        sensorDescription("Flash", "This is the flash. It works by... Want to give it a go?");
        hardwareButton.setOnAction(e -> Hardware.flashOn());
        backToPhoneButton.setOnAction(e-> {
                Hardware.flashOff();
            backToTool();
        });

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