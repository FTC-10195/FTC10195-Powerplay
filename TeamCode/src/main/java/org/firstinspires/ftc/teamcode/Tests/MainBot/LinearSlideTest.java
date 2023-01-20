package org.firstinspires.ftc.teamcode.Tests.MainBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


//TODO max position according to v1 scrim bot, any higher and the linear slide breaks- around negative 5760
//TODO assign variables to positions once tuned

@TeleOp(group = "Tests")
public class LinearSlideTest extends LinearOpMode {
     DcMotorEx linearSlide;
    DcMotorEx linearSlide2;
    //defines motor
    int currentPosition;
    //TODO TUNE THESE VALUES
    public static int TALL_POLE = 0;
    public static int MEDIUM_POLE = -7397;
    public static int SHORT_POLE = -4634;
    public static int MAX_VALUE_V1 = -6510;
    @Override
    public void runOpMode() throws InterruptedException {
        linearSlide = hardwareMap.get(DcMotorEx.class, "ls");
        linearSlide2 = hardwareMap.get(DcMotorEx.class, "ls2");

        //Sets motor
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        linearSlide2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        linearSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        boolean previousXButton = gamepad1.x;

        boolean previousBButton = gamepad1.b;

        waitForStart();
        while (opModeIsActive()) {

            //Controls movement
            currentPosition = linearSlide.getCurrentPosition();
            if (gamepad1.x) {
                linearSlide.setPower(1);
                linearSlide2.setPower(1);
            }
            else if (gamepad1.b) {
                linearSlide.setPower(-1);
                linearSlide2.setPower(-1);

            } else {
                linearSlide.setPower(0);
                linearSlide2.setPower(0);
            }

             previousXButton = gamepad1.x;

             previousBButton = gamepad1.b;


            telemetry.addData("Encoder Value", currentPosition);
            telemetry.update();


        }
    }



    public void position(int pole) {
        do{
            linearSlide.setTargetPosition(pole);
            linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            linearSlide.setPower(1);
            linearSlide.setTargetPositionTolerance(25);
            currentPosition = linearSlide.getCurrentPosition();
            telemetry.addData("Encoder Value", currentPosition);
            telemetry.update();
        } while (currentPosition > pole);
        linearSlide.setTargetPosition(0);
        linearSlide.setPower(1);
        telemetry.addData("Encoder Value", currentPosition);
        telemetry.update();

    }

}
