package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.lang.*;

//TODO FIGURE OUT IN THE CAR

public class ColorDetector {
    public static ColorSensor sensor;

    public ColorDetector(HardwareMap hwMap) {
        sensor = hwMap.get(ColorSensor.class, "ColorDetector");
        sensor.enableLed(true);
    }

    int r = sensor.red();
    int g = sensor.green();
    int b = sensor.blue();
    int idealpinkr = 0; //placeholder
    int idealpinkg = 0; //placeholder
    int idealpinkb = 0; //placeholder

    int idealgoldr = 0; //placeholder
    int idealgoldg = 0; //placeholder
    int idealgoldb = 0; //placeholder
    
    int idealbluer = 0; //placeholder
    int idealblueg = 0; //placeholder
    int idealblueb = 0; //placeholder

    /*Idea here: use Math.abs() to find error values from the received rgb values and the "ideal"
    rgb values for every color to see if the result should be counted as that color. The margin
    should probably be around around 40. May want to see if the previous code actually gets a value
    from the color sensor.*/


}

