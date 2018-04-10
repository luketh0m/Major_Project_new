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

import static java.lang.Boolean.TRUE;


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
    private Rectangle phoneBody;
    @FXML
    private Rectangle touchScreen;
    @FXML
    private Rectangle volumeRocker;
    @FXML
    private Rectangle chargingPort;
    @FXML
    private Rectangle sleepWakeButton;
    @FXML
    private Rectangle navBar;
    @FXML
    private Rectangle multiTask1;
    @FXML
    private Rectangle multiTask2;

    @FXML
    private Rectangle frontSpeaker;
    @FXML
    private Circle camera;
    @FXML
    private Circle ambientLightSensor;
    @FXML
    private Circle proximitySensor;
    @FXML
    private Circle homeButton;
    @FXML
    private Polygon backButton;


    //Back of phone

    @FXML
    private Rectangle phoneBodyBack;
    @FXML
    private Rectangle fingerPrintScanner;
    @FXML
    private Rectangle chargingPortRear;
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
    private Rectangle volumeRockerRear;
    @FXML
    private Rectangle sleepWakeButtonRear;

    @FXML
     Rectangle Tint;


    Controller c = new Controller();
    Main m = new Main();



    public void appAcessed() {
      optionsController.tintOptions(Tint);


    }

    public void menuButtonClicked() throws Exception {


        closePage();
        m.start(primaryStage);

    }


    public void infoButtonClicked() throws Exception {

        c.infoButton();
    }

    public void quizButtonClicked() throws Exception {
        closePage();
        quizMenu.quizDifficulty();

    }

    public void backToTool() {
        frontText.setVisible(true);
        backText.setVisible(true);
        descriptionArea.setVisible(false);
        descriptionLabel.setVisible(false);
        descriptionText.setVisible(false);
        hardwareButton.setVisible(false);
        backToPhoneButton.setVisible(false);

    }


    public void sensorDescription(String sensorTitle, String sensorDescription) {


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


    public void TooltipFeatures(String description, Shape shape) {
        final Tooltip toolTip = new Tooltip();
        toolTip.setText(description);
        Tooltip.install(shape, toolTip);
        shape.setCursor(Cursor.HAND);
    }


    // Each sensor has its own class, easier to manage and change code.
    public void touchScreenMouseOver() {
        TooltipFeatures("Touchscreen", touchScreen);


    }

    public void touchScreenClicked() throws Exception {

        sensorDescription("Touch Screen", "That was the Touchscreen! Every time you tap on your phone, your phone has to transmit that touch into an electrical signal. It does this using Capacitive Sensing. Underneath the glass surface of your phone, there is a conductive material called indium tin oxide. Within this matieral there are electrodes arranged in a diamond grid. Your phone keeps these electrodes at a set voltage. When your finger touches the screen, it attracts the positive electrodes on one side of your finger, forcing your phone to deposit more electrons. Each pair of electrodes then has a meter that keeps track of how many charges are in the two electrodes at that particular spot on the phone. Your phone looks at which point of the phone the electrodes are disturbed, and it then knows where you have placed your finger on the screen! It also means that you are able to text with the back of a metal spoon, or even a hot dog!  ");


    }


    public void cameraMouseover() {

        TooltipFeatures("Front Camera", camera);
    }


    public void cameraClicked() {

        sensorDescription("Camera", "That's the camera! The camera uses a lens to help light enter through the aperture (The aperture is basically a hole) and it lets light through to the sensor. If too much light is taken in, the image will be all white. If too little light is taken in, the image will be black. The sensor is set to shut off after a certain amount of time to make sure the right amount of light has entered. Once all of the light infomation has been caputred, it is sent too a signal image processor whcih will take all the infomation and turn it into an image. (Normal a JPEG format, but this depends on what phone you use! " );
    }

    public void frontSpeakerMouseOver() {

        TooltipFeatures("Front Speaker", frontSpeaker);

    }

    public void frontSpeakerClicked() {

        sensorDescription("Front speaker", "The front and rear speakers both work the same as a normal speakers.The primary purpose of a speaker is to convert electrical energy into acoustic energy. At the front of a speaker there is a cone. The outer part of the cone is fastened to the outer part of the loudpeakers circular metal rim. The inner part (the smaller part of the cone) is fixed to an iron coil that sits just in front of a permanent magnet. To make sound, electrical singals feed through the speaker cables into the coil. As electricity flows back and forth in the cables, the magnet electromagnet either attracts of repels the permanent magnet. This moves the coil backward and forward, pulling and pushing the speakers cone. The movign cone pumps sounds out into the air ");
        hardwareButton.setOnAction(e -> Hardware.frontSpeakerOn());

    }


    public void ambientLightSensorMouseOver() {

        TooltipFeatures("Ambient Light Sensor", ambientLightSensor);

    }

    public void ambientLightSensorClicked() {
        sensorDescription("Ambient Light sensor", "That was the ambient light sensor! The Ambient Light Sensor helps to measure the light in a surrounding area and can adjust your phone's screen brightness Accordingly. it does this by using a photodiode.A photodiode is a semiconductor device that converts light into an electrical current. The photodiode measures the amount of light in the surrounding area, and these readings are sent to your phones CPU (Central processing unit). if the surrounding area is bright, the signal sent will be high, as a result the phone will increase in screen brightness, if the light is low, the screen brightness will decrease.");
        hardwareButton.setOnAction(e -> Hardware.ambientLightSensorOn());


    }

    public void proximitySensorMouseOver() {
        TooltipFeatures("Proximity Sensor", proximitySensor);

    }

    public void proximitySensorClicked() {

        sensorDescription("Proximimty Sensor", "That was the proximity sensor! The proximimty sensor measures how close something is to your device. Its range is very limited (up to 30mm) but this is because its used to detect the presence of a human ear. This means it can turn the screen off while a human ear is in range (normally due to a user on the phone). It works by using a sensor called a Capacitive Proximity sensor. It consists of two metal plates separated by an insulator called a dielectric. Using this, it can detect any target with a higher dielectric constant greater than air. Dialectic constant is an electrostatic field and can detect interference within it. Once the detector senses enough interference, the output circuit remains active until the target is removed, which is why your screen turns off while you are on the phone! ");
        hardwareButton.setOnAction(e -> Hardware.proximitySensorOn());
    }

    public void volumeRockerMouseOver() {
        TooltipFeatures("Volume Rocker", volumeRocker);
        TooltipFeatures("Volume Rocker", volumeRockerRear);

    }

    public void volumeRockerClicked() {

        sensorDescription("Volume Rocker", "That was the volume rocker. The volume rocker works the same way as any other button on a phone. The button adjusts the voltage being sent from the button from either low to high, or high to low. As a result, the phone has a mechanism for dealing with this type of change based on its current state. For example, if the state is high (User pressed the button), turn the sound off! The volume rocker actualy conatins two small buttons, and the casing around them is what we see! Pressing the casing up presses the volume up button, while pressing the casing at the bottom presses the downward button Press the launch hardware button and give it a go yourself!");

    }


    public void sleepWakeButtonMouseover() {


        TooltipFeatures("Sleep/Wake Button", sleepWakeButton);

    }

    public void sleepWakeButtonClicked() {

        sensorDescription("Sleep/ Wake Button Clicked", "Sleep/wae");
        hardwareButton.setOnAction(e -> Hardware.proximitySensorOn());

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

        sensorDescription("Home button", "Home Button");
        hardwareButton.setOnAction(e -> Hardware.buttonOn());

        backToPhoneButton.setOnAction(e -> {
            Hardware.buttonOff();
            backToTool();
        });
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

    public void fingerPrintScannerMouseOver() {
        TooltipFeatures("Fingerprint Scanner", fingerPrintScanner);
    }

    public void FingerPrintScannerClicked() {
        sensorDescription("Fingerprint Scanner", "Finger print Scanner");

    }

    public void rearSpeakerClicked() {
        sensorDescription("Rear Speaker", "Rear Speaker Clicked");
        hardwareButton.setOnAction(e -> Hardware.rearSpeakerOn());

    }

    public void rearSpeakerMouseOver() {
        TooltipFeatures("Rear Speakers", rearSpeaker1);
        TooltipFeatures("Rear Speakers", rearSpeaker2);
        TooltipFeatures("Rear Speakers", rearSpeaker3);
        TooltipFeatures("Rear Speakers", rearSpeaker4);
    }

    public void RearCameraColourClicked() {


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
        backToPhoneButton.setOnAction(e -> {
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
        if (window instanceof Stage) {
            ((Stage) window).close();
        }
    }




    @Override
    public void start(Stage primaryStage) throws Exception {


    }

}
