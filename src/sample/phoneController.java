package sample;

import gnu.io.NoSuchPortException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Cursor;


import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.function.ToLongBiFunction;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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

import static java.lang.Boolean.FALSE;
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
    @FXML
    private Ellipse microphone;


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
    private Circle led1;
    @FXML
    private Circle led2;
    @FXML
    private Circle led3;
    @FXML
    private Circle led4;
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
    private Rectangle greyOutRectangle;

    @FXML
    private Rectangle Tint;


    Controller c = new Controller();
    Main m = new Main();


    public void appAcessed() {
        optionsController.tintOptions(Tint);

    }


    public void menuButtonClicked() throws Exception {
        closePage();
        m.start(primaryStage);


    }


    public void settingsButtonClicked() throws Exception {
        closePage();
        Main.currentPage = "Options.fxml";
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

    public void backToTool() {
        frontText.setVisible(true);
        backText.setVisible(true);
        descriptionArea.setVisible(false);
        descriptionLabel.setVisible(false);
        descriptionText.setVisible(false);
        hardwareButton.setVisible(false);
        backToPhoneButton.setVisible(false);
        greyOutRectangle.setVisible(false);

    }


    public void sensorDescription(String sensorTitle, String sensorDescription) {

        greyOutRectangle.setVisible(true);
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

        sensorDescription("Touch Screen", "That was the Touchscreen! Every time you tap on your phone, your phone has to transmit that touch into an electrical signal. It does this using Capacitive Sensing. Underneath the glass surface of your phone, there is a conductive material called indium tin oxide. Within this material there are electrodes arranged in a diamond grid. Your phone keeps these electrodes at a set voltage. When your finger touches the screen, it attracts the positive electrodes on one side of your finger, forcing your phone to deposit more electrons. Each pair of electrodes then has a meter that keeps track of how many charges are in the two electrodes at that particular spot on the phone. Your phone looks at which point of the phone the electrodes are disturbed, and it then knows where you have placed your finger on the screen! It also means that you are able to text with the back of a metal spoon, or even a hot dog!  ");
        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));

    }

    public void microphoneMouseOver() {
        TooltipFeatures("Microphone", microphone);

    }

    public void microphoneClicked() {

        sensorDescription("Microphone", "That was the microphone!\n" +
                "\u2022 The microphone is a type of transducer - a device which converts energy from one form to another.\n" +
                        "\u2022 Microphones convert acoustic energy (sound waves) into electrical energy (the audio signal.\n" +
                        "\u2022 Whenever a sound is made, it sends vibrations through the air.\n" +
                        "\u2022 A microphone has a diaphragm.\n" +
                        "\u2022 This is a thin piece of material that vibrates when sounds strikes it.\n" +
                        "\u2022 This passes the energy to the rest of the microphones components.\n" +
                        "\u2022 These vibrations are converted to an electrical current which becomes the audio signal your interface uses to capture and playback sound.\n");

        hardwareButton.setOnAction(e -> {


            alertBox.display("Go on!", "Say something!, but make sure you click okay first!", "Okay");
            Hardware.microphoneOn();

        });


    }

    public void cameraMouseover() {

        TooltipFeatures("Front Camera", camera);
    }


    public void cameraClicked() {

        sensorDescription("Camera",
                "\u2022 That's the camera!\n" +
                        " \u2022 The camera uses a lens to help light enter through the aperture (The aperture is basically a hole)\n" +
                        " \u2022 The Aperture lets light through to the sensor.\n" +
                        "\u2022 If too much light is taken in, the image will be all white.\n" +
                        "\u2022 If too little light is taken in, the image will be black.\n" +
                        "\u2022 The sensor is set to shut off after a certain amount of time to make sure the right amount of light has entered.\n" +
                        "\u2022 Once all of the light information has been captured, it is sent too a signal image processor which will take all the information and turn it into an image.\n");

                        hardwareButton.setOnAction(e-> alertBox.display("No hardware!", "We're really sorry, there's no hardware available for this sensor", "Okay"));
    }

    public void frontSpeakerMouseOver() {

        TooltipFeatures("Front Speaker", frontSpeaker);

    }

    public void frontSpeakerClicked() {

        sensorDescription("Front speaker",
                "\u2022 The primary purpose of a speaker is to convert electrical energy into acoustic energy.\n" +
                "\u2022 At the front of a speaker there is a cone.\n"+
                "\u2022 The outer part of the cone is fastened to the outer part of the loudspeakers circular metal rim.\n"  +
                "\u2022 The inner part) is fixed to an iron coil that sits just in front of a permanent magnet.\n"  +
                "\u2022 To make sound, electrical signals feed through the speaker cables into the coil.\n" +
                "\u2022 electricity flows back and forth in the cables, the magnet electromagnet either attracts of repels the permanent magnet.\n" +
                "\u2022 This moves the coil backward and forward, pulling and pushing the speakers cone.+ The moving cone pumps sounds out into the air\n ");

        hardwareButton.setOnAction(e -> Hardware.frontSpeakerOn());

    }


    public void ambientLightSensorMouseOver() {

        TooltipFeatures("Ambient Light Sensor", ambientLightSensor);

    }

    public void ambientLightSensorClicked() {
        sensorDescription("Ambient Light sensor",
                "That was the ambient light sensor!\n" +
                "\u2022The Ambient Light Sensor helps to measure the light in a surrounding area and can adjust your phone's screen brightness Accordingly.\n" +
                 "\u2022Uses a photodiode.\n" +
                "\u2022A photodiode is a semiconductor device that converts light into an electrical current.\n" +
                "\u2022photodiode measures the amount of light in the surrounding area.\n" +
                "\u2022readings are sent to your phones CPU (Central processing unit).\n" +
        "\u2022if the surrounding area is bright, the signal sent will be high, as a result the phone will increase in screen brightness, if the light is low, the screen brightness will decrease.\n");

        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "We're really sorry, there's no hardware available for this sensor.", "Okay"));


    }

    public void proximitySensorMouseOver() {
        TooltipFeatures("Proximity Sensor", proximitySensor);

    }

    public void proximitySensorClicked() {

        sensorDescription("Proximity Sensor", "\u2022That was the proximity sensor!" +
                "\u2022The proximity sensor measures how close something is to your device.\n" +
    "\u2022Its range is very limited (up to 30mm)\n"+
    "\u2022Used to turn the screen off while a human ear is in range (normally due to a user on the phone).\n" +
    "\u2022It works by using a Capacitive Proximity sensor.2\n" +
    "\u2022It consists of two metal plates separated by an insulator called a dielectric.\n" +
    "\u2022It can detect any target with a higher dielectric constant greater than air.\n" +
    "\u2022Dialectic constant is an electrostatic field and can detect interference within it.\n" +
    "\u2022Once the detector senses enough interference, the output circuit remains active until the target is removed, which is why your screen turns off while you are on the phone! ");

        hardwareButton.setOnAction(e -> Hardware.proximitySensorOn());
    }

    public void volumeRockerMouseOver() {
        TooltipFeatures("Volume Rocker", volumeRocker);
        TooltipFeatures("Volume Rocker", volumeRockerRear);

    }

    public void volumeRockerClicked() {

        sensorDescription("Volume Rocker",
                "\u2022That was the volume rocker.\n" +
                "\u2022The volume rocker works the same way as any other button on a phone.\n" +
                "\u2022The button adjusts the voltage being sent from the button from either low to high, or high to low.\n" +
                "\u2022The phone has a mechanism for dealing with this type of change based on its current state.\n" +
                "\u2022if the state is high (User pressed the button), turn the sound off!\n" +
                "\u2022The volume rocker actually contains two small buttons, and the casing around them covers both.\n" +
                "\u2022Pressing the casing up presses the volume up button, while pressing the casing at the bottom presses the downward button.\n");

        hardwareButton.setOnAction(e -> {
            alertBox.display("Volume Rocker", "Go ahead! Click the button", "Okay");
            Hardware.buttonOn();

        });


    }


    public void sleepWakeButtonMouseover() {


        TooltipFeatures("Lock Button", sleepWakeButton);

    }

    public void sleepWakeButtonClicked() {

        sensorDescription("Sleep/Wake button",
                "\u2022That was the volume rocker.\n" +
                        "\u2022The Sleep/wake works the same way as any other button on a phone.\n" +
                        "\u2022The button adjusts the voltage being sent from the button from either low to high, or high to low.\n" +
                        "\u2022The phone has a mechanism for dealing with this type of change based on its current state.\n" +
                        "\u2022if the state is high (User pressed the button), turn the sound off!\n" +
                        "\u2022The volume rocker actually contains two small buttons, and the casing around them covers both.\n" );

        hardwareButton.setOnAction(e -> {
            alertBox.display("Sleep/wake button", "Go ahead! Click the button", "Okay");
            Hardware.buttonOn();

        });
    }

    public void setSleepWakeButtonRearMouseOver() {
        TooltipFeatures("Sleep/Wake Button", sleepWakeButtonRear);

    }

    public void navigationBarMouseOver() {
        TooltipFeatures("Navigation Bar", navBar);

    }

    public void navigationBarClicked() {


        sensorDescription("Navigation bar", "That was the navigation bar.\n" +
                "\u2022All phones have a way to return to the home menu and go back a page.\n" +
                "\u2022Many smart phones today also have the multi tasking button, all of which can be found on the navigation bar.\n" +
                "\u2022The navigation bar was created to enhance the user experience.\n" +
                "\u2022 Makes it easier for users to complete actions on their phone. ");

        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }


    public void backButtonMouseOver() {
        TooltipFeatures("Back Button", backButton);

    }

    public void backButtonClicked() {

        sensorDescription("Back button", "That was the back button!\n" +
                "\u2022its used to go back to previous page.\n" +
                "\u2022Back button is an example of a virtual button.\n" +
                "\u2022Mobile phone manufacturers use virtual buttons for a number of reasons.\n" +
                "\u2022one of the main reasons is that they are cheaper than physical buttons.\n" +
                "\u2022They can be changed at any time with a software update");

        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));

    }

    public void homeButtonMouseOver() {
        TooltipFeatures("Home Button", homeButton);


    }

    public void homeButtonClicked() {

        sensorDescription("Home button", "That was the home button!\n" +
                "\u2022it is a virtual button!\n" +
                "\u2022The Home button is one of the most iconic buttons in smart phones.\n" +
                "\u2022Important because it provides consistency to mobile phone users.\n" +
                 "\u2022Every flagship (flagship means the best product a company offers) phone has a home button.\n" +
                "\u2022Without it users would not be comfortable using a new device.\n");

        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void multiTaskingButtonMouseOver() {
        TooltipFeatures("Multi Tasking Button", multiTask1);
        TooltipFeatures("Multi Tasking Button", multiTask2);


    }

    public void multiTaskingButtonClicked() {

        sensorDescription("Multi Tasking Button", "That was the multi tasking button." +
                "\u2022It is a virtual button!\n"+
                "\u2022The multi tasking button is used to navigate between pages easily.\n" +
        "\u2022Multitasking was introduced in 2010 and its now a huge part of any mobile phone.\n" +
        "\u2022The ability to navigation to and from applications with ease is a must for many users!\n");

        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void chargingPortMouseOver() {
        TooltipFeatures("Charging Port", chargingPort);
        TooltipFeatures("Charging Port", chargingPortRear);

    }

    public void chargingPortClicked() {

        sensorDescription("Charging Port", "That was the charging port!" +
                "\u2022used to charge your phone!\n"+
                "\u2022phone charger works of the principle of AC (alternating current) to DC (direct Current).\n" +
                "\u2022phone charger first steps down the current.\n"+
                "\u2022uses rectification(the process of removing the negative part of the alternate current, producing the partial DC.\n" +
                "\u2022The third step is called filtration. The output after the rectification is not a proper DC.\n"+
                 "\u2022A  capacitor is used.\n" +
                "\u2022The capacitor maintain the voltage supply into the load circuit, creating the DC.\n"+
                "\u2022A voltage regulator at the output side maintain the constant voltage throughout. + ");

                hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void phoneBodyBackClicked() {

        sensorDescription("Phone Body", "That was the phone body.\n" +
                "\u2022Although all phones have different casing they all follow the same set of general rules.\n" +
                "\u2022The phones casing is designed to contain every components within the device, keeping them safe and secure.\n" +
                "\u2022generally two different types of material used.\n" +
                "\u2022Metal and plastic when materials are chosen.\n" +
                "\u2022two main factors.\n" +
                 "\u20221) The impact resistance of the case, because its meant to protect the internals of the phone.\n" +
                "\u20222) temperature resistance.\n" +
                "\u2022While charging or while the phone is used a lot the materials may get hot. To make sure a user doesn't burn themselves, a material with good temperature resistance must be used.");

        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));

    }

    public void phoneBodyBackMouseOver() {
        TooltipFeatures("Phone body", phoneBodyBack);

    }

    public void fingerPrintScannerMouseOver() {
        TooltipFeatures("Fingerprint Scanner", fingerPrintScanner);
    }

    public void FingerPrintScannerClicked() {
        sensorDescription("Fingerprint Scanner", "That was the fingerprint scanner.\n" +
                "\u2022The fingerprint scanner is one of the newest advancements in mobile technology.\n"+
                        "\u2022fingerprint scanner measurers the differences in conductivity caused by the raised parts of your fingerprint, and uses those measurements to form an image.\n"+
                        "\u2022the surface that your finger rests on must be tough, and scratching will prevent it from working properly.\n" +
                        "\u2022There are three main types of fingerprint scanners.\n"+
                        "\u20221) optical scanners, which is the oldest method of capturing and comparing fingerprint.\n"+
                        "\u20222) capacitive fingerprint scanners work in the way we've just discussed.\n"+
                       "\u20223)  ultrasonic scanner is the latest type of fingerprint scanner.\n"+
                        "\u2022Many of the larger phone manufactures are currently working on these technologies.");
        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void rearSpeakerClicked() {
        sensorDescription("Front speaker",
                "\u2022 The primary purpose of a speaker is to convert electrical energy into acoustic energy.\n" +
                        "\u2022 At the front of a speaker there is a cone.\n"+
                        "\u2022 The outer part of the cone is fastened to the outer part of the loudspeakers circular metal rim.\n"  +
                        "\u2022 The inner part) is fixed to an iron coil that sits just in front of a permanent magnet.\n"  +
                        "\u2022 To make sound, electrical signals feed through the speaker cables into the coil.\n" +
                        "\u2022 electricity flows back and forth in the cables, the magnet electromagnet either attracts of repels the permanent magnet.\n" +
                        "\u2022 This moves the coil backward and forward, pulling and pushing the speakers cone.+ The moving cone pumps sounds out into the air\n ");        hardwareButton.setOnAction(e -> Hardware.rearSpeakerOn());

    }

    public void rearSpeakerMouseOver() {
        TooltipFeatures("Rear Speakers", rearSpeaker1);
        TooltipFeatures("Rear Speakers", rearSpeaker2);
        TooltipFeatures("Rear Speakers", rearSpeaker3);
        TooltipFeatures("Rear Speakers", rearSpeaker4);
    }

    public void RearCameraColourClicked() {


        sensorDescription("Camera",
                "\u2022 That's the camera!\n" +
                        " \u2022 The camera uses a lens to help light enter through the aperture (The aperture is basically a hole)\n" +
                        " \u2022 The Aperture lets light through to the sensor.\n" +
                        "\u2022 If too much light is taken in, the image will be all white.\n" +
                        "\u2022 If too little light is taken in, the image will be black.\n" +
                        "\u2022 The sensor is set to shut off after a certain amount of time to make sure the right amount of light has entered.\n" +
                        "\u2022 Once all of the light information has been captured, it is sent too a signal image processor which will take all the information and turn it into an image.\n");
        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));

    }

    public void RearCameraColourMouseOver() {
        TooltipFeatures("Rear camera - Colour version", rearCameraColour);
    }

    public void RearCameraBlackAndWhiteClicked() {
        sensorDescription("Rear Camera 1", "That's the first rear Camera. Smart phones these days often have two cameras. The camera uses a lens to help light enter through the aperture (The aperture is basically a hole) and it lets light through to the sensor. If too much light is taken in, the image will be all white. If too little light is taken in, the image will be black. The sensor is set to shut off after a certain amount of time to make sure the right amount of light has entered. Once all of the light information has been captured, it is sent too a signal image processor which will take all the information and turn it into an image. This camera is considered the 'standard camera' of the two! Check out the other camera to see why");
        hardwareButton.setOnAction(e-> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void RearCameraBlackAndWhiteMouseOver() {
        TooltipFeatures("Rear camera 2", rearCameraBlackAndWhite);

    }

    public void flashClicked() {

        sensorDescription("Flash", "This is the flash.\n" +
                "\u2022Mobile phone flashes consist of simple LED lights.\n" +
                        "\u2022often use more than one LED to allow brighter and darker flashes.\n"	+
                        "\u2022Normal camera flashes use a tube filled with xenon gas.\n" +
                        "\u2022Generally too expensive and too big for smart phone");

        hardwareButton.setOnAction(e -> Hardware.flashOn());
        backToPhoneButton.setOnAction(e -> {
            Hardware.flashOff();
            backToTool();
        });

    }

    public void flashMouseOver() {
        TooltipFeatures("Flash", flash);

    }


    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {


    }


    public void closePage() throws Exception {

        Window window = rootPane.getScene().getWindow();
        if (window instanceof Stage) {


            ((Stage) window).close();
        }
    }


}