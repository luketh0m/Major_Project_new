package sample;

import org.sintef.jarduino.DigitalPin;
import org.sintef.jarduino.DigitalState;
import org.sintef.jarduino.JArduino;
import org.sintef.jarduino.PinMode;

public class Hardware extends JArduino {


    public Hardware(String port) {
        super(port);
    }

    @Override
    protected void setup() {
        // initialize the digital pin as an output.
        // Pin 13 has an LED connected on most Arduino boards:
        pinMode(DigitalPin.PIN_13, PinMode.OUTPUT);
    }

    protected void flashON() {

        digitalWrite(DigitalPin.PIN_13, DigitalState.HIGH);
        delay(2000); // wait for a second
        // set the LED off
        digitalWrite(DigitalPin.PIN_13, DigitalState.LOW);
        delay(1000); // wait for a second
    }





    @Override
    protected void loop() {
     flashON();

    }




    public static void main(String[] args) {
        JArduino arduino = new Hardware("COM3");
        arduino.runArduinoProcess();
    }

}