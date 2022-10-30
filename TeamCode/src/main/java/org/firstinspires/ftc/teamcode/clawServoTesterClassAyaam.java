package org.firstinspires.ftc.teamcode;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class clawServoTesterClassAyaam extends LinearOpMode {

    @SuppressLint("SuspiciousIndentation")
    @Override
    public void runOpMode() throws InterruptedException {

        Servo clawServo = hardwareMap.servo.get("clawOne");

        double clawServoPosition = 0;

        boolean previousRightBumper = gamepad1.right_bumper;

        boolean previousLeftBumper = gamepad1.left_bumper;

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            clawServo.setPosition(clawServoPosition);


            if (gamepad1.right_bumper && !previousRightBumper) {
                clawServoPosition += .05;
            }

            if (gamepad1.left_bumper && !previousLeftBumper) {
                clawServoPosition -= .05;
            }

            previousRightBumper = gamepad1.right_bumper;
            previousLeftBumper = gamepad1.left_bumper;


                telemetry.addData("Servo Position", clawServoPosition);
                telemetry.update();
            }
        }
    }





