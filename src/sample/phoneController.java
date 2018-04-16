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


    public void infoButtonClicked() throws Exception {

        c.infoButton();
    }

    public void quizButtonClicked() throws Exception {
        closePage();
        sample.quizMenu.quizDifficulty();

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


    }


    public void cameraMouseover() {

        TooltipFeatures("Front Camera", camera);
    }


    public void cameraClicked() {

        sensorDescription("Camera", "That's the camera! The camera uses a lens to help light enter through the aperture (The aperture is basically a hole) and it lets light through to the sensor. If too much light is taken in, the image will be all white. If too little light is taken in, the image will be black. The sensor is set to shut off after a certain amount of time to make sure the right amount of light has entered. Once all of the light information has been captured, it is sent too a signal image processor which will take all the information and turn it into an image. (Normal a JPEG format, but this depends on what phone you use! " );
    }

    public void frontSpeakerMouseOver() {

        TooltipFeatures("Front Speaker", frontSpeaker);

    }

    public void frontSpeakerClicked() {

        sensorDescription("Front speaker", "The front and rear speakers both work the same as a normal speakers.The primary purpose of a speaker is to convert electrical energy into acoustic energy. At the front of a speaker there is a cone. The outer part of the cone is fastened to the outer part of the loudspeakers circular metal rim. The inner part (the smaller part of the cone) is fixed to an iron coil that sits just in front of a permanent magnet. To make sound, electrical signals feed through the speaker cables into the coil. As electricity flows back and forth in the cables, the magnet electromagnet either attracts of repels the permanent magnet. This moves the coil backward and forward, pulling and pushing the speakers cone. The moving cone pumps sounds out into the air ");
        hardwareButton.setOnAction(e -> Hardware.frontSpeakerOn());

    }


    public void ambientLightSensorMouseOver() {

        TooltipFeatures("Ambient Light Sensor", ambientLightSensor);

    }

    public void ambientLightSensorClicked() {
        sensorDescription("Ambient Light sensor", "That was the ambient light sensor! The Ambient Light Sensor helps to measure the light in a surrounding area and can adjust your phone's screen brightness Accordingly. it does this by using a photodiode.A photodiode is a semiconductor device that converts light into an electrical current. The photodiode measures the amount of light in the surrounding area, and these readings are sent to your phones CPU (Central processing unit). if the surrounding area is bright, the signal sent will be high, as a result the phone will increase in screen brightness, if the light is low, the screen brightness will decrease.");
        // hardwareButton.setOnAction(e -> Hardware.ambientLightSensorOn());


    }

    public void proximitySensorMouseOver() {
        TooltipFeatures("Proximity Sensor", proximitySensor);

    }

    public void proximitySensorClicked() {

        sensorDescription("Proximity Sensor", "That was the proximity sensor! The proximity sensor measures how close something is to your device. Its range is very limited (up to 30mm) but this is because its used to detect the presence of a human ear. This means it can turn the screen off while a human ear is in range (normally due to a user on the phone). It works by using a sensor called a Capacitive Proximity sensor. It consists of two metal plates separated by an insulator called a dielectric. Using this, it can detect any target with a higher dielectric constant greater than air. Dialectic constant is an electrostatic field and can detect interference within it. Once the detector senses enough interference, the output circuit remains active until the target is removed, which is why your screen turns off while you are on the phone! ");
         hardwareButton.setOnAction(e -> Hardware.proximitySensorOn());
    }

    public void volumeRockerMouseOver() {
        TooltipFeatures("Volume Rocker", volumeRocker);
        TooltipFeatures("Volume Rocker", volumeRockerRear);

    }

    public void volumeRockerClicked() {

        sensorDescription("Volume Rocker", "That was the volume rocker. The volume rocker works the same way as any other button on a phone. The button adjusts the voltage being sent from the button from either low to high, or high to low. As a result, the phone has a mechanism for dealing with this type of change based on its current state. For example, if the state is high (User pressed the button), turn the sound off! The volume rocker actually contains two small buttons, and the casing around them is what we see! Pressing the casing up presses the volume up button, while pressing the casing at the bottom presses the downward button Press the launch hardware button and give it a go yourself!");
        hardwareButton.setOnAction(e->  {
            alertBox.display("Volume Rocker", "Go ahead! Click the button", "Okay");
            Hardware.buttonOn();

        });



        }



    public void sleepWakeButtonMouseover() {


        TooltipFeatures("Lock Button", sleepWakeButton);

    }

    public void sleepWakeButtonClicked() {

        sensorDescription("Sleep/Wake Button Clicked", "That was the Lock button. The lock button works the same way as any other button on a phone. The button adjusts the voltage being sent from the button from either low to high, or high to low. As a result, the phone has a mechanism for dealing with this type of change based on its current state. For example, if the state is high (User pressed the button), turn the either turn on the screen, or turn i toff, depending on the state it was in previously. The lock button can also be programmed to perform different action depending on the length of time the button was pressed for. e.g. 'if the button state is high for 5 seconds or more, show the power off menu. ");
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

        sensorDescription("Navigation bar", "That was the navigation bar. All phones have a way to return to the home menu and go back a page. Many smart phones today also have the multi tasking button, all of which can be found on the navigation bar. The navigation bar was created to enhance the user experience, making it easier for users to complete actions on their phone. ");
    }

    public void backButtonMouseOver() {
        TooltipFeatures("Back Button", backButton);

    }

    public void backButtonClicked() {

        sensorDescription("Back button", "That was the back button! its used to..well... go back! The back button is an exmaple of a virtual button. Mobile phone manufacturers use virtual buttons for a number of reasons, one of the main reasons is that they are cheaper than physical buttons and they can be changed at any time with a software update");


    }

    public void homeButtonMouseOver() {
        TooltipFeatures("Home Button", homeButton);


    }

    public void homeButtonClicked() {

        sensorDescription("Home button", "That was the home button! Like the back and multi task buttons, it is a virtual button! The Home button is one of the most iconic buttons in smartphones. It's so important because it provides consistency to mobile phone users. Every flagship (flagship means the best product a company offers) phone hs a home button, and without it users would no be comfortable using a new device.  ");
        //  hardwareButton.setOnAction(e -> Hardware.buttonOn());

        //   backToPhoneButton.setOnAction(e -> {
        /// Hardware.buttonOff();
        backToTool();
        //   });
    }

    public void multiTaskingButtonMouseOver() {
        TooltipFeatures("Multi Tasking Button", multiTask1);
        TooltipFeatures("Multi Tasking Button", multiTask2);


    }

    public void multiTaskingButtonClicked() {

        sensorDescription("Multi Tasking Button", "That was the multi tasking button. Like the home and back buttons, it is a virtual button! The multi tasking button iss used to navigate between pages easily. Multitasking was introduced in 2010 and its no a huge part of any mobile phone The ability to navigation to and from applications with ease is a must for many users!");

    }

    public void chargingPortMouseOver() {
        TooltipFeatures("Charging Port", chargingPort);
        TooltipFeatures("Charging Port", chargingPortRear);

    }

    public void chargingPortClicked() {

        sensorDescription("Charging Port", "That was the charging port! As you already know, it's used to charge your phone! But how does it work? Well, a phone charger works of the simple principle of AC (alternating current) to DC (direct Current). The phone charger first steps down the current. After this, it uses rectification(the process of removing the negative part of the alternate current, producing the partial DC. The third step is called filtration. The output after the rectification is not a proper DC. So a capacitor is used. The capacitor maintain the voltage supply into the load circuit, creating the DC. Finally , a voltage regulator at the output side maintain the constant voltage throughout. ");
    }
    public void phoneBodyBackClicked() {

        sensorDescription("Phone Body", "That was the phone body. Although all phones have different casing they all follow the same set of general rules. The phones casing is designed to contain all of the components within the device, keeping them safe and secure. There are generally two different types of material used, Metal and plastic when materials are chosen, they must take into consideration two main factors. 1) The impact resistance of the case, because its meant to protect the internals of the phone. 2) temperature resistance.While charging or while the phone is used a lot the materials may get hot. To make sure a user doesn't burn themselves, a material with good temperature resistance must be used.");


    }

    public void phoneBodyBackMouseOver() {
        TooltipFeatures("Phone body", phoneBodyBack);

    }

    public void fingerPrintScannerMouseOver() {
        TooltipFeatures("Fingerprint Scanner", fingerPrintScanner);
    }

    public void FingerPrintScannerClicked() {
        sensorDescription("Fingerprint Scanner", "That was the fingerprint scanner. The fingerprint scanner is one of the newest advancements in mobile technology. The fingerprint scanner measurers the differences in conductivity caused by the raised parts of your fingerprint, and uses those measurements to form an image. For fingerprint scanners to work, the surface that your finger rests on must be tough, as scratching will prevent it from working properly. There are three main types of fingerprint scanners, optical scanners, which is the oldest method of capturing and comparing fingerprint The second, capacitive fingerprint scanners work in the way we've just discussed. The third, an ultrasonic scanner is the latest type of fingerprint scanner. Many of the larger phone manufactures are currently working on these technologies.    ");

    }

    public void rearSpeakerClicked() {
        sensorDescription("Rear speaker", "The front and rear speakers both work the same as a normal speakers.The primary purpose of a speaker is to convert electrical energy into acoustic energy. At the front of a speaker there is a cone. The outer part of the cone is fastened to the outer part of the speakers circular metal rim. The inner part (the smaller part of the cone) is fixed to an iron coil that sits just in front of a permanent magnet. To make sound, electrical signals feed through the speaker cables into the coil. As electricity flows back and forth in the cables, the magnet electromagnet either attracts of repels the permanent magnet. This moves the coil backward and forward, pulling and pushing the speakers cone. The moving cone pumps sounds out into the air ");

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
        sensorDescription("Rear Camera 1", "That's the first rear Camera. Smart phones these days often have two cameras. The camera uses a lens to help light enter through the aperture (The aperture is basically a hole) and it lets light through to the sensor. If too much light is taken in, the image will be all white. If too little light is taken in, the image will be black. The sensor is set to shut off after a certain amount of time to make sure the right amount of light has entered. Once all of the light information has been captured, it is sent too a signal image processor which will take all the information and turn it into an image. This camera is considered the 'standard camera' of the two! Check out the other camera to see why");

    }

    public void RearCameraBlackAndWhiteMouseOver() {
        TooltipFeatures("Rear camera 2", rearCameraBlackAndWhite);
        sensorDescription("Rear Camera 2", "This is the secondary camera. Now, the technology used differs between manufacturers. So here's a few of the main examples. 1) Enhanced zoom - sometimes the secondary camera will use a permanently zoomed lens. The dive switches between cameras upon zooming in, and it does it so smoothly the user doesn't notice. 2) Monochrome - some manufacturers shoot one lens in total monochrome (that means black nad white) an combines both images from the two cameras. the result is a much brighter, vibrant photo because it allows more light in than a regular single camera. ");
    }

    public void flashClicked() {

        sensorDescription("Flash", "This is the flash. Mobile phone flashes consist of some simple LED lights, and often use more than one LED to allow brighter and darker flashes. Normal camera flashes use a tube filled with xenon gas, but this is generally too expensive and too complicated for the average smart phone not to mention the size is also a problem. ");
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