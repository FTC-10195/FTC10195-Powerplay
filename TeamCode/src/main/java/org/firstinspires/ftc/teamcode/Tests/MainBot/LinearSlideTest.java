package org.firstinspires.ftc.teamcode.Tests.MainBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Subsystems.Claw;

//TODO max position according to v1 scrim bot, any higher and the linear slide breaks- around negative 5760
//TODO assign variables to positions once tuned

@TeleOp
public class LinearSlideTest extends LinearOpMode {
    public static DcMotorEx linearSlide; //defines motor
    int currentPosition;
    //TODO TUNE THESE VALUES
    public static int TALL_POLE = 0;
    public static int MEDIUM_POLE = -7397;
    public static int SHORT_POLE = -4634;
    public static int MAX_VALUE_V1 = -6510;
    Claw claw = new Claw(hardwareMap);
    @Override
    public void runOpMode() throws InterruptedException {
        linearSlide = hardwareMap.get(DcMotorEx.class, "linearSlide"); //Sets motor
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.dpad_up) {
                position(TALL_POLE);
            }
            if (gamepad1.dpad_right) {
                position(MEDIUM_POLE);
            }
            if (gamepad1.dpad_left) {
                position(SHORT_POLE);
            }
            //to test function only
            if (gamepad1.dpad_down) {
                position(MAX_VALUE_V1);
            }
            //Controls movement
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
