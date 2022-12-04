package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class altijaniDriveTrain extends LinearOpMode {

    float lSVP = 0;

    float lSHP = 0;

    float rSHP = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        DcMotorEx tLMotor = hardwareMap.dcMotor.get("tLMotor");

        DcMotorEx bLMotor = hardwareMap.dcMotor.get("bLMotor");

        DcMotorEx tRMotor = hardwareMap.dcMotor.get("tRMotor");

        DcMotorEx bRMotor = hardwareMap.dcMotor.get("bRMotor");

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            tLMotor.setMotorEnable(lSVP, lSHP, rSHP);

            bLMotor.setMotorEnable(lSVP, lSHP, rSHP);

            tRMotor.setMotorEnable(lSVP, lSHP, rSHP);

            bRMotor.setMotorEnable(lSVP, lSHP, rSHP);

            if (gamepad1.left_stick_x = -0.2 || <-0.2) {



            }

            if (gamepad1.left_stick_x = 0.2 || >0.2) {



            }

            if (gamepad1.left_stick_y = -0.2 || <-0.2) {



            }

            if (gamepad1.left_stick_y = 0.2 || >0.2) {



            }

            if (gamepad1.right_stick_x = -0.2 || <-0.2) {



            }

            if (gamepad1.right_stick_x = 0.2 || <0.2) {



            }

            telemetry.addData("Left Stick Horizontal Position", lSHP)

            telemetry.addData("Left Stick Verticle Position", lSVP)

            telemetry.addData("Right Stick Horizontal Position",rSHP)

        }
    }
}
