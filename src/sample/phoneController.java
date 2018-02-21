package sample;
import java.awt.*;
import java.awt.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Tooltip;

import javafx.stage.PopupWindow;




public class phoneController {



    String descriptionOnTouch;
    String descriptionOnMouseOver;


    // This displays typerwriter effect in java.
    // Take message length, while i < length add one,
    // pause for amount of time spec in params













    // Each sensor has its own class, easier to manage and change code.
    public void touchScreenMouseOver()  {





    }

    public void touchScreenClicked() {



        }






    public void cameraClicked() {

        System.out.println("This is the camera");
    }

    public void frontSpeakerClicked() {

        System.out.println("This is the front Speaker");
    }

    public void ambientLightSensorClicked() {

        System.out.println("This is the Light Sensor");
    }

    public void proximitySensorClicked() {

        System.out.println("This is the Proximity Sensor");
    }

    public void volumeRockerClicked() {

        System.out.println("This is the volume Rocker");
    }

    public void sleepWakeButtonClicked() {

        System.out.println("This is the sleep/wake button");

    }

    public void navigationBarClicked() {

        System.out.println("This is the navigation bar");
    }

    public void backButtonClicked() {

        System.out.println("This is the back button");
    }

    public void homeButtonClicked() {

        System.out.println("This is the home button");
    }

    public void multiTaskingButtonClicked() {

        System.out.println("This is the multi tasking button");
    }

    public void chargingPortClicked() {

        System.out.println("This is the Charging Port");
    }


    public Tooltip makeBubble(Tooltip tooltip) {
        tooltip.setStyle("-fx-font-size: 16px; -fx-shape");
        tooltip.setAnchorLocation(PopupWindow.AnchorLocation.WINDOW_BOTTOM_LEFT);

        return tooltip;
    }

}