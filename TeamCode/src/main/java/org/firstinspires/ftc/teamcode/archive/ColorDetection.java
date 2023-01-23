package org.firstinspires.ftc.teamcode.archive;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;


//should be self explanatory
@TeleOp(group = "Tests")
public class ColorDetection extends LinearOpMode {
    RevColorSensorV3 colorSensorV3;
   public int red = 0;
   public int blue = 0;
   public int green = 0;

public boolean zone2;
public boolean zone1;
public boolean zone3;

    public ColorDetection(HardwareMap hardwareMap) {
        colorSensorV3 = hardwareMap.get(RevColorSensorV3.class, "colorSensor");
    }

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {
            red = colorSensorV3.red();
            blue = colorSensorV3.blue();
            green = colorSensorV3.green();
            telemetry.addData("Red", red);
            telemetry.addData("Green", green);
            telemetry.addData("Blue", blue);
            telemetry.addData("Alpha", colorSensorV3.alpha());
            telemetry.update();

            if (red > blue && red > green) {
                telemetry.addData("Zone 3- Red", red);
                zone3 = true;
            }
            if(blue > red && blue > green) {
                telemetry.addData("Zone 2- Blue", blue);
                zone2 = true;
            }
            if(green > red && green > blue) {
                telemetry.addData("Zone 1- Green", green);
                zone1 = true;
            }


        }
    }
}