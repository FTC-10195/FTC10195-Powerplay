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
        Gamepad previousGamepad = new Gamepad();
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
          if(gamepad1.right_bumper && !previousGamepad.right_bumper) {
              ServoPos += 0.05;
          }
          if(gamepad1.left_bumper && !previousGamepad.left_bumper) {
              ServoPos += -0.05;
          }
          previousGamepad = gamepad1;
        }
    }
}
