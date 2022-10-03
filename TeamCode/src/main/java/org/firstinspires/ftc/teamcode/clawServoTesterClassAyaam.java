package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class clawServoTesterClassAyaam extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Servo clawServoOne = hardwareMap.servo.get("clawOne");
        Servo clawServoTwo = hardwareMap.servo.get("clawTwo");
        double clawServoPositionOne = 0;
        double clawServoPositionTwo = 0;
        boolean previousRightBumper = gamepad1.right_bumper;
        boolean previousLeftBumper = gamepad1.left_bumper;
        boolean previousX = gamepad1.x;
        boolean previousB = gamepad1.b;

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {

            clawServoOne.setPosition(clawServoPositionOne);
            clawServoTwo.setPosition(clawServoPositionTwo);


            if (gamepad1.right_bumper && !previousRightBumper) {
                clawServoPositionOne += .05;
            }
            if (gamepad1.left_bumper && !previousLeftBumper) {
                clawServoPositionOne -= .05;
            }
            if (gamepad1.x && !previousX) {
                clawServoPositionTwo += .05;
            }
            if (gamepad1.b && !previousB) {
                clawServoPositionTwo -= .05;
            }


                previousRightBumper = gamepad1.right_bumper;
                previousLeftBumper = gamepad1.left_bumper;
                previousX = gamepad1.x;
                previousB = gamepad1.b;


                telemetry.addData("Servo Position", clawServoPositionOne);
                telemetry.addData("Servo Position", clawServoPositionTwo);

                telemetry.update();
            }
        }
    }





