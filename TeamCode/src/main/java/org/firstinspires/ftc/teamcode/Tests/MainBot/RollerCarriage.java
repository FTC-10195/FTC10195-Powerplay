package org.firstinspires.ftc.teamcode.Tests.MainBot;
import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import java.security.acl.Group;


//program to test a two claw servo. Prints out to telemetry the current value of each claw servo, uses a falling edge detector for accuracy.
@TeleOp(group = "Tests")
public class RollerCarriage extends LinearOpMode {

    @SuppressLint("SuspiciousIndentation")
    @Override
    public void runOpMode() throws InterruptedException {

        //hardware map calls
        Servo clawServo1 = hardwareMap.servo.get("roller");


        double clawServo1Position = 0;


        //falling edge detector
        boolean previousRightBumper = gamepad1.right_bumper;

        boolean previousLeftBumper = gamepad1.left_bumper;


        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            clawServo1.setPosition(clawServo1Position);


            if (gamepad1.right_bumper && !previousRightBumper) {
                clawServo1Position += .05;

            }

            if (gamepad1.left_bumper && !previousLeftBumper) {
                clawServo1Position -= .05;
            }



            //falling edge detector, prevents the input from repeating during the loop
            previousRightBumper = gamepad1.right_bumper;
            previousLeftBumper = gamepad1.left_bumper;



            telemetry.addData("Servo  Position", clawServo1Position);
            telemetry.update();
        }
    }
}




