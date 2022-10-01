package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class clawServoTesterClassAyaam extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Servo clawServo = hardwareMap.servo.get("claw");
        double clawServoPosition = 0;

        waitForStart();
        if(isStopRequested()) return;

        while (opModeIsActive()) {

            clawServo.setPosition(clawServoPosition);


            boolean previousRightBumper = gamepad1.right_bumper;
            boolean previousLeftBumper = gamepad1.left_bumper;

            if(gamepad1.right_bumper == true && previousRightBumper == false) {
                clawServoPosition += .05;
            }
            if(gamepad1.left_bumper == true && previousLeftBumper == false) {
                clawServoPosition -= .05;
            }

            telemetry.addData("Servo Position", clawServoPosition);
            telemetry.update();
        }
    }




}
