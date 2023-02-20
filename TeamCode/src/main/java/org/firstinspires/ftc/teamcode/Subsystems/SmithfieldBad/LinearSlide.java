package org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.acmerobotics.roadrunner.control.PIDFController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//TODO max position according to v1 scrim bot, any higher and the linear slide breaks- around negative 5760
//brrat
//some code
public class LinearSlide {
    public static DcMotorEx linearSlide; //defines motor
    int currentPosition;
    DcMotorEx linearSlide2;
    //TODO TUNE THESE VALUES
    public static int TALL_POLE = 3878;
    public static int MEDIUM_POLE = 3500;
    public static int SHORT_POLE = 300;
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
                    sStates = slideStates.MANUAL;
                }
                break;

            case MANUAL:
                manualMove(manUp, manUp);
                if(up || down || left || right) {
                    sStates = slideStates.AUTO;
                }
                break;
    }
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

        public void manualMove(boolean up, boolean down) {

            currentPosition = linearSlide.getCurrentPosition();


           // if (up && -linearSlide.getCurrentPosition() <= 7500) {
            if (up) {
                linearSlide.setPower(1);
                linearSlide2.setPower(1);

            }
          //  else if (down && -linearSlide.getCurrentPosition() >= 0) {
              else if(down) {
                linearSlide.setPower(-1);
                linearSlide2.setPower(-1);
            }
            else {

                linearSlide.setPower(0);
                linearSlide2.setPower(0);
            }

            telemetry.addData("Encoder Value", currentPosition);
            telemetry.update();


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
       /* public double output(int pole) {
        double Kp  = 0;
        double Ki = 0;
        double Kd = 0;

        double integralSum = 0;

        double lastError = 0;

        double error = 0;

        double derivative = 0;
        double currentPos = linearSlide.getCurrentPosition();

        ElapsedTime timer=  new ElapsedTime();


        currentPos = linearSlide.getCurrentPosition();

        error = pole - currentPos;

        derivative = (error - lastError)/timer.seconds();

        integralSum = integralSum + error * timer.seconds();

        return  (Kp * error + (Ki * integralSum) + (Kd * derivative));
d

    }

}
    */

}


