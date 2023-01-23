package org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//TODO max position according to v1 scrim bot, any higher and the linear slide breaks- around negative 5760
//brrat
//some code
public class LinearSlide {
    public static DcMotorEx linearSlide; //defines motor
    int currentPosition;
    DcMotorEx linearSlide2;
    //TODO TUNE THESE VALUES
    public static int TALL_POLE;
    public static int MEDIUM_POLE = 0;
    public static int SHORT_POLE = 0;
    public static int MAX_VALUE_V1;
    public static int GROUND = 0;

    public LinearSlide(HardwareMap hwmp, Telemetry telemetry1) {
        linearSlide = hwmp.get(DcMotorEx.class, "ls");
        linearSlide2 = hwmp.get(DcMotorEx.class, "ls2");

        //Sets motor
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        linearSlide.setDirection(DcMotorSimple.Direction.REVERSE);


        linearSlide2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry = telemetry1;

    }
public enum slideStates {
        MANUAL,
        AUTO,
}
slideStates sStates = slideStates.MANUAL;

public void slideStates(boolean up, boolean down, boolean left, boolean right, boolean manUp, boolean manDown) {
        switch(sStates){
            case AUTO:
                slideMovement(up, down, left, right);
                if(manDown || manUp) {
                    sStates = sStates.MANUAL;
                }

            case MANUAL:
                manualMove(manUp, manUp);
                if(up || down || left || right) {
                    sStates = sStates.AUTO;
                }
    }
}


private void slideMovement(boolean up, boolean down, boolean left, boolean right) {
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

        private void manualMove(boolean up, boolean down) {

            currentPosition = linearSlide.getCurrentPosition();

          if(currentPosition < MAX_VALUE_V1) {
            if (up) {
                linearSlide.setPower(1);
                linearSlide2.setPower(1);
            }
            else if (down) {
                linearSlide.setPower(-1);
                linearSlide2.setPower(-1);
            }
            else {

                linearSlide.setPower(.05);
                linearSlide2.setPower(.05);
            }

            telemetry.addData("Encoder Value", currentPosition);
            telemetry.update();

}
    else {
        linearSlide.setPower(-.05);
        linearSlide2.setPower(-.05);
        }
}
    private void position(int pole) {
        linearSlide.setTargetPosition(pole);
        linearSlide.setTargetPositionTolerance(50);
        linearSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linearSlide.setPower(1);

        linearSlide2.setTargetPosition(pole);
        linearSlide2.setTargetPositionTolerance(50);
        linearSlide2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linearSlide2.setPower(1);


    }


    private void resetSlides() {
        linearSlide.setTargetPosition(0);
        linearSlide.setPower(1);
    }
}


