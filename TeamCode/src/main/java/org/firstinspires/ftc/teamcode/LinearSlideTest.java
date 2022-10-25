package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class LinearSlideTest extends LinearOpMode {
    DcMotorEx linearSlide; //defines motor

    @Override
    public void runOpMode() throws InterruptedException {
        linearSlide = hardwareMap.get(DcMotorEx.class, "linearSlide"); //Sets motor
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int currentPosition;
        //TODO TUNE THESE VALUES
        final int TALL_POLE = 0;
        final int MEDIUM_POLE = 0;
        final int SHORT_POLE = 0;

        waitForStart();

        while (opModeIsActive()) {                  //Controls movement
            currentPosition = linearSlide.getCurrentPosition();
            if (gamepad1.left_bumper) {
                linearSlide.setPower(1);
            }
            if (gamepad1.right_bumper) {
                linearSlide.setPower(-1);
            }

            if (gamepad1.b) {
                linearSlide.setMotorDisable();
            }
            if (gamepad1.dpad_up) {
                do {
                    linearSlide.setTargetPosition(-3000);
                    linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    linearSlide.setPower(1);
                    linearSlide.setTargetPositionTolerance(25);
                    currentPosition = linearSlide.getCurrentPosition();
                }while(currentPosition > -3000);
                linearSlide.setTargetPosition(0);
                linearSlide.setPower(1);

            }

            //TODO max position according to v1 scrim bot, any higher and the linear slide breaks
            //TODO assign variables to positions once tuned
            if(gamepad1.dpad_right) {
                do {
                    linearSlide.setTargetPosition(-5600);
                    linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    linearSlide.setPower(1);
                    linearSlide.setTargetPositionTolerance(25);
                    currentPosition = linearSlide.getCurrentPosition();
                } while (currentPosition > -5600);
                linearSlide.setTargetPosition(0);
                linearSlide.setPower(1);
            }
            telemetry.addData("Encoder Value", currentPosition);
            telemetry.update();

        }

    }

}
