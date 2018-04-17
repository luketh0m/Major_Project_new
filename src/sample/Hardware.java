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
    protected void setup() {}

    public static void ambientLightSensorOn() {

        arduino.pinMode(DigitalPin.PIN_3, INPUT);

        int counter = 0;
        while (counter < 100)
            System.out.print(arduino.digitalRead(DigitalPin.PIN_3));
        counter++;
        arduino.delay(50);

    }

    public static void pingTest() {

        arduino.ping();
    }



    public static void proximitySensorOn() {

        arduino.pinMode(DigitalPin.PIN_4, INPUT);

        int counter = 0;
        while (counter < 100)
            System.out.print(arduino.digitalRead(DigitalPin.PIN_4));
        counter++;
        arduino.delay(50);

    }

    public static void rearSpeakerOn() {


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

    public static void touchScreenButtonsPressed(){

        arduino.pinMode(DigitalPin.PIN_2, INPUT);
        arduino.pinMode(DigitalPin.PIN_3, INPUT);
        arduino.pinMode(DigitalPin.PIN_4, INPUT);
        arduino.pinMode(DigitalPin.PIN_5, INPUT);
        arduino.pinMode(DigitalPin.PIN_6, INPUT);
        arduino.pinMode(DigitalPin.PIN_7, INPUT);
        arduino.pinMode(DigitalPin.PIN_8, INPUT);
        arduino.pinMode(DigitalPin.PIN_9, INPUT);


        DigitalState state = arduino.digitalRead(DigitalPin.PIN_2);
        while (state == LOW) {
            System.out.print( "Waiting...");
            arduino.delay(20);
        }
        while (state == HIGH)
            System.out.print("You pressed :" + state);


    }

    public static void microphoneOn() {



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

        try {
            arduino.pinMode(DigitalPin.PIN_11, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);}

        arduino.digitalWrite(DigitalPin.PIN_11,HIGH);
        arduino.delay(20);
        arduino.digitalWrite(DigitalPin.PIN_11,LOW);
        arduino.delay(5);
        arduino.digitalWrite(DigitalPin.PIN_11,HIGH);
        arduino.delay(20);
        arduino.digitalWrite(DigitalPin.PIN_11,LOW);
        arduino.delay(50);


    }

    public static void buttonOn() {


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
        try {
            arduino.pinMode(DigitalPin.PIN_13, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);
        }
        arduino.digitalWrite(DigitalPin.PIN_13, HIGH);

    }

    public static void flashOff() {

        try {
            arduino.pinMode(DigitalPin.PIN_13, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);
        }
        arduino.digitalWrite(DigitalPin.PIN_13, LOW);

    }

    @Override
    protected void loop() {



    }

    public static void main(String[] args) {

        arduino.runArduinoProcess();


    }
    public static void Stop(){
        arduino.stopArduinoProcess();
    }
}