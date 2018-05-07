package sample;


import com.sun.org.apache.xpath.internal.operations.Bool;
import gnu.io.NoSuchPortException;
import javafx.scene.paint.Color;
import org.sintef.jarduino.*;
import org.sintef.jarduino.comm.Serial4JArduino;
import org.sintef.jarduino.sim.InteractiveJArduinoDataGUIClient;

import javax.swing.*;

import java.awt.*;

import static org.sintef.jarduino.DigitalState.HIGH;
import static org.sintef.jarduino.DigitalState.LOW;
import static org.sintef.jarduino.PinMode.INPUT;
import static org.sintef.jarduino.PinMode.OUTPUT;


public class Hardware extends JArduino {


    public static Byte pin = null;

    public Hardware(String port) {
        super(port);
    }

    public static JArduino arduino = new Hardware("COM3");

    @Override
    protected void setup() {
    }

    public static void pingTest() {
        arduino.ping();
    }

    public static void proximitySensorOn() {
        //access proximity sensor, display message when object is close
        if   (pin == 1);
            pin = arduino.digitalRead(DigitalPin.PIN_10).getValue();
            arduino.delay(50);

            alertBox.display("Wow", "That was close", "Okay");

            if (pin == 0) {
                arduino.digitalRead(DigitalPin.PIN_10);
                alertBox.display("No object detected", "Sorry, we couldn't find an object to detect. We are working on it", "Okay");
            }
        }

    public static void rearSpeakerOn() {
        //send signal to speaker sensor to play sound
        arduino.pinMode(DigitalPin.PIN_12, OUTPUT);

        arduino.digitalWrite(DigitalPin.PIN_12, HIGH);
        arduino.delay(20);
        arduino.digitalWrite(DigitalPin.PIN_12, LOW);
        arduino.delay(50);
        arduino.digitalWrite(DigitalPin.PIN_12, HIGH);
        arduino.delay(50);
        arduino.digitalWrite(DigitalPin.PIN_12, LOW);
        arduino.delay(20);

    }

    public static void microphoneOn() {
        //listen for input to come over 203, send message to say sound was heard
        arduino.pinMode(DigitalPin.PIN_8, INPUT);
        short number;

        do {
            number = arduino.analogRead(AnalogPin.A_0);
        } while (number <= 202);

        if (number >= 203) {
            System.out.print(number);
            alertBox.display("Hi!", "I heard that!", "Okay");
        }
    }

    public static void frontSpeakerOn() {
        //send signal to make speaker play sound
        try {
            arduino.pinMode(DigitalPin.PIN_11, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);
        }

        arduino.digitalWrite(DigitalPin.PIN_11, HIGH);
        arduino.delay(20);
        arduino.digitalWrite(DigitalPin.PIN_11, LOW);
        arduino.delay(5);
        arduino.digitalWrite(DigitalPin.PIN_11, HIGH);
        arduino.delay(20);
        arduino.digitalWrite(DigitalPin.PIN_11, LOW);
        arduino.delay(50);
    }

    public static void buttonOn() {
        //wait for user to press button, and display message
        arduino.pinMode(DigitalPin.PIN_10, INPUT);
        arduino.digitalWrite(DigitalPin.PIN_10, HIGH);

        do {
            pin = arduino.digitalRead(DigitalPin.PIN_10).getValue();
        }
        while (pin == 1);

        if (pin == 0) {
            {
                alertBox.display("Button Clicked", "Great! You pressed the button, which is why this popped up!", "Okay");
            }
        }
    }

    public static void flashOn() {
        //turn on flash
        try {
            arduino.pinMode(DigitalPin.PIN_13, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);
        }
        arduino.digitalWrite(DigitalPin.PIN_13, HIGH);
    }

    public static void flashOff() {
        //turn off flash
        try {
            arduino.pinMode(DigitalPin.PIN_13, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);
        }
        arduino.digitalWrite(DigitalPin.PIN_13, LOW);
    }

    @Override
    protected void loop() {
    } //needed for JArduino library

    public static void main(String[] args) {

        arduino.runArduinoProcess();
    }
}