package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Clawbprac extends LinearOpMode{


    @Override
    public void runOpMode() throws InterruptedException {

        Servo clawServo = hardwareMap.servo.get("clawOne");
        double ServoPos = 0.5;
        boolean previousLeftBumper = false, previousRightBumper = false;

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
          if(gamepad1.right_bumper && !previousRightBumper) {
              ServoPos += 0.05;
          }
          if(gamepad1.left_bumper && !previousLeftBumper) {
              ServoPos -= 0.05;
          }
            previousRightBumper = gamepad1.right_bumper;
            previousLeftBumper  = gamepad1.left_bumper;
          clawServo.setPosition(ServoPos);

          telemetry.addData("servoPos", ServoPos);
          telemetry.update();
        }
    }
}
