package sample;





import org.sintef.jarduino.*;
import org.sintef.jarduino.comm.Serial4JArduino;
import org.sintef.jarduino.sim.InteractiveJArduinoDataGUIClient;

import javax.swing.*;

import static org.sintef.jarduino.DigitalState.HIGH;
import static org.sintef.jarduino.DigitalState.LOW;
import static org.sintef.jarduino.PinMode.INPUT;
import static org.sintef.jarduino.PinMode.OUTPUT;

public class Hardware extends JArduino {








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
            System.out.print(arduino.digitalRead(DigitalPin.PIN_2));
        counter++;
        arduino.delay(50);
    }

    public static void proximitySensorOn() {

        arduino.pinMode(DigitalPin.PIN_3, INPUT);

        int counter = 0;
        while (counter < 100)
            System.out.print(arduino.digitalRead(DigitalPin.PIN_3));
        counter++;
        arduino.delay(50);

    }

    public static void rearSpeakerOn() {


        arduino.pinMode(DigitalPin.PIN_8, OUTPUT);


        arduino.digitalWrite(DigitalPin.PIN_8, HIGH);
        arduino.delay(20);
        arduino.digitalWrite(DigitalPin.PIN_8, LOW);
        arduino.delay(50);
        arduino.digitalWrite(DigitalPin.PIN_8, HIGH);
        arduino.delay(50);
        arduino.digitalWrite(DigitalPin.PIN_8, LOW);
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

    public static void microphoneOn(){

        arduino.pinMode(DigitalPin.PIN_3, INPUT);

        int count = 0;
        while (count <100)
        {
            System.out.print(arduino.digitalRead(DigitalPin.PIN_3));
            System.out.print(arduino.analogRead(AnalogPin.A_0));
            count++;
        }

    }

    public static void frontSpeakerOn() {

        try {
            arduino.pinMode(DigitalPin.PIN_7, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);}

        arduino.digitalWrite(DigitalPin.PIN_7,HIGH);
        arduino.delay(20);
        arduino.digitalWrite(DigitalPin.PIN_7,LOW);
        arduino.delay(5);
        arduino.digitalWrite(DigitalPin.PIN_7,HIGH);
        arduino.delay(20);
        arduino.digitalWrite(DigitalPin.PIN_7,LOW);
        arduino.delay(50);


    }

    public static void buttonOn() {
        Byte pin = null;

        arduino.pinMode(DigitalPin.PIN_4, INPUT);
        arduino.digitalWrite(DigitalPin.PIN_4, HIGH);

        pin =  arduino.digitalRead(DigitalPin.PIN_4).getValue();
        System.out.print(pin);


    }

    public static void buttonOff() {
        try {
            arduino.pinMode(DigitalPin.PIN_4, OUTPUT);
        } catch (Exception e) {}

        try {
            arduino.digitalWrite(DigitalPin.PIN_4, LOW);
        } catch (Exception e) {}
    }


    public static void flashOn() {
        try {
            arduino.pinMode(DigitalPin.PIN_12, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);
        }
        arduino.digitalWrite(DigitalPin.PIN_12, HIGH);

    }

    public static void flashOff() {

        try {
            arduino.pinMode(DigitalPin.PIN_12, OUTPUT);
        } catch (Exception e) {
            System.out.print(e);
        }
        arduino.digitalWrite(DigitalPin.PIN_12, LOW);

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