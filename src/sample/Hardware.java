package sample;

import gnu.io.SerialPort;
import org.sintef.jarduino.*;
import org.sintef.jarduino.comm.Serial4JArduino;

import static org.sintef.jarduino.DigitalState.HIGH;
import static org.sintef.jarduino.DigitalState.LOW;
import static org.sintef.jarduino.PinMode.OUTPUT;

public class Hardware extends JArduino {

    public Hardware(String port) {
        super(port);
    }

   public static JArduino arduino = new Hardware("COM3");
    @Override
    protected void setup() {

        // initialize serial communication at 9600 bits per second:

    }

        public static void flashON(){
           arduino.pinMode (DigitalPin.PIN_12, OUTPUT);
            arduino.digitalWrite (DigitalPin.PIN_12, HIGH); // set the LED on
            arduino.delay (2000); // wait for a second
            arduino.digitalWrite (DigitalPin.PIN_12, LOW);
            arduino.stopArduinoProcess();
        }



    @Override
    protected void loop() {



    }

    public static void main(String[] args) {

        arduino.runArduinoProcess();


    }

    }


