package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class AutoMovement  {
    static DcMotor motorFrontLeft;
    static DcMotor motorBackLeft;
    static DcMotor motorFrontRight;
    static DcMotor motorBackRight;
    int br;
    int bl;
    int fr;
    int fl;

public static void forward(int distance) {

//reset encoder, go forward x amount of ticks at .1 speed
    motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    motorBackRight.setTargetPosition(distance);
    motorBackLeft.setTargetPosition(distance);
    motorFrontRight.setTargetPosition(distance);
    motorFrontLeft.setTargetPosition(distance);

    motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    motorBackRight.setPower(.1);
    motorBackLeft.setPower(.1);
    motorFrontRight.setPower(.1);
    motorFrontLeft.setPower(.1);

    //while loop exists so that the program does not stop the motors while the motors are still running, blocking code
    while(motorBackLeft.isBusy() || motorBackRight.isBusy() || motorFrontLeft.isBusy() || motorFrontRight.isBusy()){}
    motorBackRight.setPower(0);
    motorBackLeft.setPower(0);
    motorFrontRight.setPower(0);
    motorFrontLeft.setPower(0);


}
    //literally same as before, just add some negatives bc of mecanum equations
    public static void strafeRight(int distance) {

        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorBackRight.setTargetPosition(-distance);
        motorBackLeft.setTargetPosition(distance);
        motorFrontRight.setTargetPosition(-distance);
        motorFrontLeft.setTargetPosition(distance);

        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorBackRight.setPower(.1);
        motorBackLeft.setPower(.1);
        motorFrontRight.setPower(.1);
        motorFrontLeft.setPower(.1);
        while(motorBackLeft.isBusy() && motorBackRight.isBusy() && motorFrontLeft.isBusy() && motorFrontRight.isBusy()){}
        motorBackRight.setPower(0);
        motorBackLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorFrontLeft.setPower(0);
    }

    public static void strafeLeft(int distance) {
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorBackRight.setTargetPosition(-distance);
        motorBackLeft.setTargetPosition(distance);
        motorFrontRight.setTargetPosition(-distance);
        motorFrontLeft.setTargetPosition(distance);
        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorBackRight.setPower(1);
        motorBackLeft.setPower(1);
        motorFrontRight.setPower(1);
        motorFrontLeft.setPower(1);

        while(motorBackLeft.isBusy() && motorBackRight.isBusy() && motorFrontLeft.isBusy() && motorFrontRight.isBusy()){}
        motorBackRight.setPower(0);
        motorBackLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorFrontLeft.setPower(0);

    }

}
