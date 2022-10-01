package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class LinearSlideTest extends LinearOpMode {
    DcMotorEx linearSlide; //defines motor

    @Override
    public void runOpMode() throws InterruptedException {
        linearSlide = hardwareMap.get(DcMotorEx.class, "linearSlide"); //Sets motor
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        while (opModeIsActive()) {                  //Controls movement
            boolean y = gamepad1.right_bumper;
            boolean x = gamepad1.left_bumper;
            if (y) {
                linearSlide.setPower(1);
            }
            if (x) {
                linearSlide.setPower(-1);
            }

            telemetry.addData("Encoder Value", linearSlide.getCurrentPosition());
            telemetry.update();
        }
    }
}