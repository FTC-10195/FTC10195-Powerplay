package org.firstinspires.ftc.teamcode.archive.Scrimbot;
import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import java.security.acl.Group;

@TeleOp(group = "Tests")
public class clawServoTesterClassAyaam extends LinearOpMode {

    @SuppressLint("SuspiciousIndentation")
    @Override
    public void runOpMode() throws InterruptedException {

        Servo clawServo1 = hardwareMap.servo.get("clawOne");

        Servo clawServo2 = hardwareMap.servo.get("clawTwo");

        double clawServo1Position = 0;

        double clawServo2Position = 0;

        boolean previousRightBumper = gamepad1.right_bumper;

        boolean previousLeftBumper = gamepad1.left_bumper;

        boolean previousXButton = gamepad1.x;

        boolean previousBButton = gamepad1.b;

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            clawServo1.setPosition(clawServo1Position);

            clawServo2.setPosition(clawServo2Position);

            if (gamepad1.right_bumper && !previousRightBumper) {
                clawServo1Position += .05;
                clawServo2Position += .05;

            }

            if (gamepad1.left_bumper && !previousLeftBumper) {
                clawServo1Position -= .05;
                clawServo2Position -= .05;
            }


            if (gamepad1.x && !previousXButton) {
                clawServo2Position += .05;

            }

            if (gamepad1.b && !previousBButton) {
                clawServo2Position -= .05;

            }

            previousRightBumper = gamepad1.right_bumper;
            previousLeftBumper = gamepad1.left_bumper;

            previousXButton = gamepad1.x;
            previousBButton = gamepad1.b;


                telemetry.addData("Servo One Position", clawServo1Position);
                telemetry.addData("Servo Two Position", clawServo2Position);
                telemetry.update();
            }
        }
    }




