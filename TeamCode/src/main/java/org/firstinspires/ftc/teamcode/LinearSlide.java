package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

//TODO max position according to v1 scrim bot, any higher and the linear slide breaks- around negative 5760
//TODO assign variables to positions once tuned


public class LinearSlide {
    public static DcMotorEx linearSlide; //defines motor
    int currentPosition;
    //TODO TUNE THESE VALUES
    public static int TALL_POLE = -6510;
    public static int MEDIUM_POLE = 0;
    public static int SHORT_POLE = 0;
    public static int MAX_VALUE_V1 = -6510;
    public static int GROUND = 0;

    public LinearSlide(HardwareMap hwmp) {
    linearSlide = hwmp.get(DcMotorEx.class, "linearSlide");
    linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
}

public void slideMovement(boolean up, boolean down, boolean left, boolean right) {
            if (up) {
                position(TALL_POLE);
            }
            if (right) {
                position(MEDIUM_POLE);
            }
            if (left) {
                position(SHORT_POLE);
            }
            //to test function only
            if (down) {
                position(GROUND);

            }
        }

        public void manualMove(double leftTrigger, double rightTrigger, boolean stop) {

        if(leftTrigger > 0.1) {
            linearSlide.setPower(leftTrigger);
        }
          else if(rightTrigger > 0.1) {
            linearSlide.setPower(-rightTrigger);
        }
          else {
              linearSlide.setMotorDisable();
        }

            if(stop) {
                linearSlide.setMotorDisable();
            }

        }



    public void position(int pole) {
        linearSlide.setTargetPosition(pole);
        linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linearSlide.setPower(1);
        linearSlide.setTargetPositionTolerance(25);
        currentPosition = linearSlide.getCurrentPosition();
        if (currentPosition <= pole) {
            resetSlides();
        }
    }

    public void resetSlides() {
        linearSlide.setTargetPosition(0);
        linearSlide.setPower(1);
    }
    public void stop() {
        linearSlide.setMotorDisable();
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}


