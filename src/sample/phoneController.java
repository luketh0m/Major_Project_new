package sample;

import gnu.io.NoSuchPortException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Cursor;


import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.function.ToLongBiFunction;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
// All shapes for front of smartphone
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
    private Rectangle rearSpeaker1;
    @FXML
    private Rectangle rearSpeaker2;
    @FXML
    private Rectangle rearSpeaker3;
    @FXML
    private Rectangle rearSpeaker4;

    // Description settings
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

    // Background colour object
    @FXML
    private Rectangle Tint;

    // Narration object
    @FXML
    private MediaPlayer player;

    //Controller and main instances
    private Controller c = new Controller();
    private Main m = new Main();


    public void appAcessed() {
        //displays background colour
        optionsController.tintOptions(Tint);
    }

    public void menuButtonClicked() throws Exception {
        //displays main menu, closes current page
        closePage();
        m.start(primaryStage);
    }

    public void settingsButtonClicked() throws Exception {
        //displays settings page, closes current page
        closePage();
        Main.currentPage = "Options.fxml";
        m.start(primaryStage);
    }

    public void infoButtonClicked() {
        //displays app info
        c.infoButton();
    }

    public void quizButtonClicked() throws Exception {
        //displays quiz, closes current page
        closePage();
        Main.currentPage = "welcomeQuiz.fxml";
        m.start(primaryStage);
    }

    public void backToTool() {
        //removes description and background,stops narration
        frontText.setVisible(true);
        backText.setVisible(true);
        descriptionArea.setVisible(false);
        descriptionLabel.setVisible(false);
        descriptionText.setVisible(false);
        hardwareButton.setVisible(false);
        backToPhoneButton.setVisible(false);
        greyOutRectangle.setVisible(false);
        player.stop();
    }


    public void sensorDescription(String sensorTitle, String sensorDescription) {
        //displays sensor description, and sets back to tool button
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
        //displays Tooltip
        final Tooltip toolTip = new Tooltip();
        toolTip.setText(description);
        Tooltip.install(shape, toolTip);
        shape.setCursor(Cursor.HAND);
    }

    public void narration(String sensor) {
        //plays narration
        Media media = new Media(Paths.get(sensor).toUri().toString());
        player = new MediaPlayer(media);
        playNarration();
        player.play();
    }
    // Each sensor has its own class, easier to manage and change code.
    public void touchScreenMouseOver() {
        //upon mouseover display touchscreen Tooltip
        TooltipFeatures("Touchscreen", touchScreen);
    }

    public void touchScreenClicked() {
        // displays touchscreen description, plays narration, display alert box for no hardware option
        sensorDescription("Touch Screen", "That was the Touchscreen!\n" +
                "\u2022Every time you tap on your phone, your phone has to transmit that touch into an electrical signal.\n" +
                "\u2022Does this using Capacitive Sensing.\n" +
                "\u2022Underneath the glass surface of your phone, there is a conductive material called indium tin oxide.\n" +
                "\u2022Within this material there are electrodes arranged in a diamond grid.\n" +
                "\u2022When your finger touches the screen, it attracts the positive electrodes on one side of your finger\n" +
                "\u2022forcing your phone to deposit more electrons.\n" +
                "\u2022Each pair of electrodes then has a meter that keeps track of how many charges are in the two electrodes at that particular spot on the phone.\n" +
                "\u2022Your phone looks at which point of the phone the electrodes are disturbed, and it then knows where you have placed your finger on the screen!\n");

        narration("Touch screen.m4a");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void microphoneMouseOver() {
        //upon mouseover display microphone Tooltip
        TooltipFeatures("Microphone", microphone);
    }

    public void microphoneClicked() {
        // displays microphone description, plays narration, activates microphone hardware
        sensorDescription("Microphone", "That was the microphone!\n" +
                "\u2022 The microphone is a type of transducer - a device which converts energy from one form to another.\n" +
                "\u2022 Microphones convert acoustic energy (sound waves) into electrical energy (the audio signal).\n" +
                "\u2022 Whenever a sound is made, it sends vibrations through the air.\n" +
                "\u2022 A microphone has a diaphragm.\n" +
                "\u2022 This is a thin piece of material that vibrates when sounds strikes it.\n" +
                "\u2022 This passes the energy to the rest of the microphones components.\n" +
                "\u2022 These vibrations are converted to an electrical current which becomes the audio signal your interface uses to capture and playback sound.\n");

        narration("microphone.m4a");

        hardwareButton.setOnAction(e -> {
            alertBox.display("Go on!", "Say something!, but make sure you click okay first!", "Okay");
            Hardware.microphoneOn();
        });
    }

    public void cameraMouseover() {
        //upon mouseover display camera Tooltip
        TooltipFeatures("Front Camera", camera);
    }

    public void cameraClicked() {
        // displays camera description, plays narration, display alert box for no hardware option
        sensorDescription("Camera",
                "\u2022 That's the camera!\n" +
                        "\u2022 The camera uses a lens to help light enter through the aperture (The aperture is basically a hole)\n" +
                        "\u2022 The Aperture lets light through to the sensor.\n" +
                        "\u2022 If too much light is taken in, the image will be all white.\n" +
                        "\u2022 If too little light is taken in, the image will be black.\n" +
                        "\u2022 The sensor is set to shut off after a certain amount of time to make sure the right amount of light has entered.\n" +
                        "\u2022 Once all of the light information has been captured, it is sent too a signal image processor which will take all the information and turn it into an image.\n");

        narration("CameraVocal.mp3");

        hardwareButton.setOnAction(e ->
                alertBox.display("No hardware!", "We're really sorry, there's no hardware available for this sensor", "Okay"));
    }

    public void frontSpeakerMouseOver() {
        //upon mouseover display front speaker Tooltip
        TooltipFeatures("Front Speaker", frontSpeaker);
    }

    public void frontSpeakerClicked() {
        // displays front speaker description, plays narration, activates front speaker hardware
        sensorDescription("Front speaker",
                "\u2022 The primary purpose of a speaker is to convert electrical energy into acoustic energy.\n" +
                        "\u2022 At the front of a speaker there is a cone.\n" +
                        "\u2022 The outer part of the cone is fastened to the outer part of the loudspeakers circular metal rim.\n" +
                        "\u2022 The inner part is fixed to an iron coil that sits just in front of a permanent magnet.\n" +
                        "\u2022 To make sound, electrical signals feed through the speaker cables into the coil.\n" +
                        "\u2022 electricity flows back and forth in the cables, the magnet electromagnet either attracts of repels the permanent magnet.\n" +
                        "\u2022 This moves the coil backward and forward, pulling and pushing the speakers cone. +" +
                        "\u2022 The moving cone pumps sounds out into the air\n ");

        narration("speaker.m4a");

        hardwareButton.setOnAction(e -> Hardware.frontSpeakerOn());
    }

    public void ambientLightSensorMouseOver() {
        //upon mouseover display ambient light sensor Tooltip
        TooltipFeatures("Ambient Light Sensor", ambientLightSensor);
    }

    public void ambientLightSensorClicked() {
        // displays ambient light sensor description, plays narration, display alert box for no hardware option
        sensorDescription("Ambient Light sensor",
                "That was the ambient light sensor!\n" +
                        "\u2022 The Ambient Light Sensor helps to measure the light in a surrounding area and can adjust your phone's screen brightness Accordingly.\n" +
                        "\u2022 Uses a photodiode.\n" +
                        "\u2022 A photodiode is a semiconductor device that converts light into an electrical current.\n" +
                        "\u2022 Photodiode measures the amount of light in the surrounding area.\n" +
                        "\u2022 Readings are sent to your phones CPU (Central processing unit).\n" +
                        "\u2022 If the surrounding area is bright, the signal sent will be high, as a result the phone will increase in screen brightness, if the light is low, the screen brightness will decrease.\n");

        narration("Ambient light sensor.m4a");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "We're really sorry, there's no hardware available for this sensor.", "Okay"));
    }

    public void proximitySensorMouseOver() {
        //upon mouseover display proximity sensor Tooltip
        TooltipFeatures("Proximity Sensor", proximitySensor);
    }

    public void proximitySensorClicked() {
        // displays proximity description, plays narration, activates proximity sensor hardware
        sensorDescription("Proximity Sensor", "\u2022 That was the proximity sensor!" +
                "\u2022 The proximity sensor measures how close something is to your device.\n" +
                "\u2022 Its range is very limited (up to 30mm)\n" +
                "\u2022 Used to turn the screen off while a human ear is in range (normally due to a user on the phone).\n" +
                "\u2022 It works by using a Capacitive Proximity sensor.\n" +
                "\u2022 It consists of two metal plates separated by an insulator called a dielectric.\n" +
                "\u2022 It can detect any target with a higher dielectric constant greater than air.\n" +
                "\u2022 Dialectic constant is an electrostatic field and can detect interference within it.\n" +
                "\u2022 Once the detector senses enough interference, the output circuit remains active until the target is removed, which is why your screen turns off while you are on the phone! ");

        narration("Proximity sensor.m4a");

        hardwareButton.setOnAction(e -> Hardware.proximitySensorOn());
    }

    public void volumeRockerMouseOver() {
        //upon mouseover display volume rocker Tooltip
        TooltipFeatures("Volume Rocker", volumeRocker);
        TooltipFeatures("Volume Rocker", volumeRockerRear);
    }

    public void volumeRockerClicked() {
        // displays volume rocker description, plays narration, activates button hardware
        sensorDescription("Volume Rocker",
                "\u2022That was the volume rocker.\n" +
                        "\u2022 The volume rocker works the same way as any other button on a phone.\n" +
                        "\u2022 The button adjusts the voltage being sent from the button from either low to high, or high to low.\n" +
                        "\u2022 The phone has a mechanism for dealing with this type of change based on its current state.\n" +
                        "\u2022 If the state is high (User pressed the button), turn the sound off!\n" +
                        "\u2022 The volume rocker actually contains two small buttons, and the casing around them covers both.\n" +
                        "\u2022 Pressing the casing up presses the volume up button, while pressing the casing at the bottom presses the downward button.\n");

        narration("volume rocker.m4a");

        hardwareButton.setOnAction(e -> {
            alertBox.display("Volume Rocker", "Go ahead! Click the button", "Okay");
            Hardware.buttonOn();
        });
    }

    public void sleepWakeButtonMouseover() {
        //upon mouseover display sleep/wake button Tooltip
        TooltipFeatures("Lock Button", sleepWakeButton);
    }

    public void sleepWakeButtonClicked() {
        // displays sleep wake button description, plays narration, activates button hardware
        sensorDescription("Sleep/Wake button",
                "\u2022That was the sleep/wake button.\n" +
                        "\u2022 The Sleep/wake works the same way as any other button on a phone.\n" +
                        "\u2022 The button adjusts the voltage being sent from the button from either low to high, or high to low.\n" +
                        "\u2022 The phone has a mechanism for dealing with this type of change based on its current state.\n" +
                        "\u2022 If the state is high (User pressed the button), lock the phone!\n" +
                        "\u2022 The volume rocker actually contains two small buttons, and the casing around them covers both.\n");

        narration("sleepwake button.m4a");

        hardwareButton.setOnAction(e -> {
            alertBox.display("Sleep/wake button", "Go ahead! Click the button", "Okay");
            Hardware.buttonOn();
        });
    }

    public void setSleepWakeButtonRearMouseOver() {
        //upon mouseover display sleep/wake button Tooltip (rear)
        TooltipFeatures("Sleep/Wake Button", sleepWakeButtonRear);
    }

    public void navigationBarMouseOver() {
        //upon mouseover display navigation bar Tooltip (rear)
        TooltipFeatures("Navigation Bar", navBar);
    }

    public void navigationBarClicked() {
        // displays navigation bar description, plays narration, alert box displays for no hardware option
        sensorDescription("Navigation bar", "That was the navigation bar.\n" +
                "\u2022 All phones have a way to return to the home menu and go back a page.\n" +
                "\u2022 Many smart phones today also have the multi tasking button, all of which can be found on the navigation bar.\n" +
                "\u2022 The navigation bar was created to enhance the user experience.\n" +
                "\u2022 Makes it easier for users to complete actions on their phone. ");

        narration("navigation bar.m4a");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void backButtonMouseOver() {
        //upon mouseover display back button Tooltip
        TooltipFeatures("Back Button", backButton);
    }

    public void backButtonClicked() {
        // displays back button description, plays narration, alert box displays for no hardware option
        sensorDescription("Back button", "That was the back button!\n" +
                "\u2022 Its used to go back to previous page.\n" +
                "\u2022 Back button is an example of a virtual button.\n" +
                "\u2022 Mobile phone manufacturers use virtual buttons for a number of reasons.\n" +
                "\u2022 One of the main reasons is that they are cheaper than physical buttons.\n" +
                "\u2022 They can be changed at any time with a software update");

        narration("Back button.m4a");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void homeButtonMouseOver() {
        //upon mouseover display home button Tooltip
        TooltipFeatures("Home Button", homeButton);
    }

    public void homeButtonClicked() {
        // displays home button description, plays narration, alert box displays for no hardware option
        sensorDescription("Home button", "That was the home button!\n" +
                "\u2022 It is a virtual button!\n" +
                "\u2022 The Home button is one of the most iconic buttons in smart phones.\n" +
                "\u2022 Important because it provides consistency to mobile phone users.\n" +
                "\u2022 Every flagship (flagship means the best product a company offers) phone has a home button.\n" +
                "\u2022 Without it users would not be comfortable using a new device.\n");

        narration("Home button.m4a");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void multiTaskingButtonMouseOver() {
        //upon mouseover display multitasking Tooltip
        TooltipFeatures("Multi Tasking Button", multiTask1);
        TooltipFeatures("Multi Tasking Button", multiTask2);
    }

    public void multiTaskingButtonClicked() {
        // displays multitasking button description, plays narration, alert box displays for no hardware option
        sensorDescription("Multi Tasking Button", "That was the multi tasking button." +
                "\u2022 It is a virtual button!\n" +
                "\u2022 The multi tasking button is used to navigate between pages easily.\n" +
                "\u2022 Multitasking was introduced in 2010 and its now a huge part of any mobile phone.\n" +
                "\u2022 The ability to navigation to and from applications with ease is a must for many users!\n");

        narration("multitasking button.m4a");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void chargingPortMouseOver() {
        //upon mouseover display charging port Tooltip
        TooltipFeatures("Charging Port", chargingPort);
        TooltipFeatures("Charging Port", chargingPortRear);
    }

    public void chargingPortClicked() {
        // displays charging port description, plays narration, alert box displays for no hardware option
        sensorDescription("Charging Port", "That was the charging port!" +
                "\u2022 Used to charge your phone!\n" +
                "\u2022 Phone charger works of the principle of AC (alternating current) to DC (direct Current).\n" +
                "\u2022 Phone charger first steps down the current.\n" +
                "\u2022 Uses rectification(the process of removing the negative part of the alternate current, producing the partial DC.\n" +
                "\u2022 The third step is called filtration. The output after the rectification is not a proper DC.\n" +
                "\u2022 A capacitor is used.\n" +
                "\u2022 The capacitor maintains the voltage supply into the load circuit, creating the DC.\n" +
                "\u2022 A voltage regulator at the output side maintain the constant voltage throughout.");

        narration("Charging port.m4a");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void phoneBodyBackMouseOver() {
        //upon mouseover display phone body Tooltip
        TooltipFeatures("Phone body", phoneBodyBack);
    }
    public void phoneBodyBackClicked() {
// displays phone body description, plays narration, alert box displays for no hardware option
        sensorDescription("Phone Body", "That was the phone body.\n" +
                "\u2022 Although all phones have different casing they all follow the same set of general rules.\n" +
                "\u2022 The phones casing is designed to contain every components within the device, keeping them safe and secure.\n" +
                "\u2022 generally two different types of material used.\n" +
                "\u2022 Metal and plastic materials are chosen.\n" +
                "\u2022 Two main factors.\n" +
                "\u2022 1) The impact resistance of the case, because its meant to protect the internals of the phone.\n" +
                "\u2022 2) temperature resistance.\n" +
                "\u2022 While charging or while the phone is used a lot the materials may get hot. To make sure a user doesn't burn themselves, a material with good temperature resistance must be used.");
        narration("Recording.m4a");
        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void fingerPrintScannerMouseOver() {
        //upon mouseover display fingerprint scanner Tooltip
        TooltipFeatures("Fingerprint Scanner", fingerPrintScanner);
    }

    public void FingerPrintScannerClicked() {
        // displays fingerprint scanner description, plays narration, alert box displays for no hardware option
        sensorDescription("Fingerprint Scanner", "That was the fingerprint scanner.\n" +
                "\u2022 The fingerprint scanner is one of the newest advancements in mobile technology.\n" +
                "\u2022 Fingerprint scanner measurers the differences in conductivity caused by the raised parts of your fingerprint, and uses those measurements to form an image.\n" +
                "\u2022 The surface that your finger rests on must be tough, and scratching will prevent it from working properly.\n" +
                "\u2022 There are three main types of fingerprint scanners.\n" +
                "\u2022 1) Optical scanners, which is the oldest method of capturing and comparing fingerprint.\n" +
                "\u2022 2) Capacitive fingerprint scanners work in the way we've just discussed.\n" +
                "\u2022 3) Ultrasonic scanner is the latest type of fingerprint scanner.\n" +
                "\u2022 Many of the larger phone manufactures are currently working on these technologies.");
        narration("fingerprint scanner.m4a");
        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }
    public void rearSpeakerMouseOver() {
        //upon mouseover display rear speaker Tooltip
        TooltipFeatures("Rear Speakers", rearSpeaker1);
        TooltipFeatures("Rear Speakers", rearSpeaker2);
        TooltipFeatures("Rear Speakers", rearSpeaker3);
        TooltipFeatures("Rear Speakers", rearSpeaker4);
    }

    public void rearSpeakerClicked() {
        // displays rear speaker description, plays narration, activates rear speaker hardware
        sensorDescription("Front speaker",
                "\u2022 The primary purpose of a speaker is to convert electrical energy into acoustic energy.\n" +
                        "\u2022 At the front of a speaker there is a cone.\n" +
                        "\u2022 The outer part of the cone is fastened to the outer part of the loudspeakers circular metal rim.\n" +
                        "\u2022 The inner part is fixed to an iron coil that sits just in front of a permanent magnet.\n" +
                        "\u2022 To make sound, electrical signals feed through the speaker cables into the coil.\n" +
                        "\u2022 electricity flows back and forth in the cables, the magnet electromagnet either attracts of repels the permanent magnet.\n" +
                        "\u2022 This moves the coil backward and forward, pulling and pushing the speakers cone. The moving cone pumps sounds out into the air\n ");
        narration("speaker.m4a");
        hardwareButton.setOnAction(e -> Hardware.rearSpeakerOn());
    }

    public void RearCameraColourMouseOver() {
        //upon mouseover display rear camera#1 Tooltip
        TooltipFeatures("Rear camera - Colour version", rearCameraColour);
    }

    public void RearCameraColourClicked() {
        // displays rear camera#1 description, plays narration, alert box displays for no hardware option
        sensorDescription("Camera",
                "\u2022 That's the camera!\n" +
                        "\u2022 The camera uses a lens to help light enter through the aperture (The aperture is basically a hole)\n" +
                        "\u2022 The Aperture lets light through to the sensor.\n" +
                        "\u2022 If too much light is taken in, the image will be all white.\n" +
                        "\u2022 If too little light is taken in, the image will be black.\n" +
                        "\u2022 The sensor is set to shut off after a certain amount of time to make sure the right amount of light has entered.\n" +
                        "\u2022 Once all of the light information has been captured, it is sent too a signal image processor which will take all the information and turn it into an image.\n");

        narration("CameraVocal.mp3");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void RearCameraBlackAndWhiteMouseOver() {
        //upon mouseover display rear camera#2 Tooltip
        TooltipFeatures("Rear camera 2", rearCameraBlackAndWhite);
    }

    public void RearCameraBlackAndWhiteClicked() {
        // displays rear camera#2 description, plays narration, alert box displays for no hardware option
        sensorDescription("Rear Camera 1", "That's the secondary camera. " +
                "\u2022 Smart phones these days often have two cameras.\n" +
                "\u2022 The camera uses a lens to help light enter through the aperture (The aperture is basically a hole) and it lets light through to the sensor.\n" +
                "\u2022 Secondary cameras are used for three primary purposes\n" +
                "1) Better white balance and low light performance\n" +
                "\u2022 Done using a larger image sensor\n" +
                "\u2022 Often taken in monochrome (black and white)\n" +
                "2) 3D image capabilities\n" +
                "\u2022 Done by taking the photo from two different angles\n" +
                "3) Optical zoom with no moving parts\n" +
                "\u2022done by providing two vocal lengths\n");

        narration("Secondary camera.m4a");

        hardwareButton.setOnAction(e -> alertBox.display("No hardware", "we're sorry, there's no hardware available for this option", "Okay"));
    }

    public void flashMouseOver() {
        //upon mouseover display flash Tooltip
        TooltipFeatures("Flash", flash);
    }

    public void flashClicked() {
        // displays flash description, plays narration, activates flash activates
        sensorDescription("Flash", "This is the flash.\n" +
                "\u2022 Mobile phone flashes consist of simple LED lights.\n" +
                "\u2022 Often use more than one LED to allow brighter and darker flashes.\n" +
                "\u2022 Normal camera flashes use a tube filled with xenon gas.\n" +
                "\u2022 Generally too expensive and too big for smart phone");

        narration("flash.m4a");

        hardwareButton.setOnAction(e -> Hardware.flashOn());

        backToPhoneButton.setOnAction(e -> {
            Hardware.flashOff();
            backToTool();
        });
    }

    public void playNarration() {
        //play narrations
        if (!optionsController.soundEnabled) {
            player.setVolume(0);

            if (optionsController.soundEnabled) {
                player.setVolume(100);
            }
        }
    }

    public static void main(String[] args) {
        launch(args); //main
    }

    @Override
    public void start(Stage primaryStage)  {
    } //stat app

    public void closePage() throws Exception {
        //closes current window
        Window window = rootPane.getScene().getWindow();
        if (window instanceof Stage) {

            ((Stage) window).close();
        }
    }

}