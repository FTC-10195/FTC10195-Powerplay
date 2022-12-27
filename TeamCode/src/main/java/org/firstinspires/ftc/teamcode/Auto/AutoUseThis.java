package org.firstinspires.ftc.teamcode.Auto;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


//extremely ugly, encoder based auto
@Autonomous
public class AutoUseThis extends LinearOpMode {
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;
    int br;
    int bl;
    int fr;
    int fl;


    @SuppressLint("SuspiciousIndentation")
    @Override
    public void runOpMode() throws InterruptedException {
      //all of the init stuff
        motorFrontLeft = hardwareMap.dcMotor.get("fl");
        motorBackLeft = hardwareMap.dcMotor.get("bl"); //reverse this
        motorFrontRight = hardwareMap.dcMotor.get("fr");
        motorBackRight = hardwareMap.dcMotor.get("br"); //reverse
        //   motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        //    motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor.ZeroPowerBehavior zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE;
        motorBackRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorBackLeft.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontLeft.setZeroPowerBehavior(zeroPowerBehavior);

        //reset stuff
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //call color detection through constructor
        ColorDetection colorDetection = new ColorDetection(hardwareMap);

        waitForStart();


        if (isStopRequested()) return;


            br = motorBackRight.getCurrentPosition();
            bl = motorBackLeft.getCurrentPosition();
            fr = motorFrontRight.getCurrentPosition();
            fl = motorFrontLeft.getCurrentPosition();

            //go forward and depending on zone park there- HAS NOT BEEN TESTED IN A MATCH, THEORITICALLY SHOULD WORK

            forward(1300);
        //    strafeRight(1000);


        //   if(colorDetection.zone3) {
          //      strafeRight(1000);

         //  }
        //   if(colorDetection.zone1){
          //     strafeLeft(1000);

         //  }
         //  if(colorDetection.zone2) {
        //   }
        }



    public void forward(int distance) {

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
    public void strafeRight(int distance) {

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

    public void strafeLeft(int distance) {
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

