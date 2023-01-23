package org.firstinspires.ftc.teamcode.Tests.MainBot;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;


@TeleOp(group = "Tests")
public class ColorSensorTest extends LinearOpMode {
    RevColorSensorV3 colorSensorV3;

    @Override
    public void runOpMode() throws InterruptedException {
        colorSensorV3 = hardwareMap.get(RevColorSensorV3.class, "colorSensor");
        int red = colorSensorV3.red();
        int blue = colorSensorV3.blue();
        int green = colorSensorV3.green();
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
            }
            if(blue > red && blue > green) {
                telemetry.addData("Zone 2- Blue", blue);
            }
            if(green > red && green > blue) {
                telemetry.addData("Zone 1- Green", green);
            }


        }
    }
}