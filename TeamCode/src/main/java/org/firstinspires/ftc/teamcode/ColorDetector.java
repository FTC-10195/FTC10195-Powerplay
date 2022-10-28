package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.lang.*;


public class ColorDetector {
    public static ColorSensor colorSensor;

    public ColorDetector(HardwareMap hwMap) {
        colorSensor = hwMap.get(ColorSensor.class, "ColorDetector");
        colorSensor.enableLed(true);
    }

    int r = colorSensor.red();
    int g = colorSensor.green();
    int b = colorSensor.blue();

    /*Idea here: use Math.abs() to find error values from the received rgb values and the "ideal"
    rgb values for every color to see if the result should be counted as that color. The margin
    should probably be around around 40. May want to see if the previous code actually gets a value
    from the color sensor.*/


}

