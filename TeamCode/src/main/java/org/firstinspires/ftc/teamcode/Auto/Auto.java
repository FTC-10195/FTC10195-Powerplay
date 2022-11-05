package org.firstinspires.ftc.teamcode.Auto;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous
public class Auto extends LinearOpMode {
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;


    @Override
    public void runOpMode() throws InterruptedException {

      //  LinearSlide linearSlide = new LinearSlide(hardwareMap);

        motorFrontLeft = hardwareMap.dcMotor.get("fl");
        motorBackLeft = hardwareMap.dcMotor.get("bl"); //reverse this
        motorFrontRight = hardwareMap.dcMotor.get("fr");
        motorBackRight = hardwareMap.dcMotor.get("br"); //reverse
        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);

        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();


        if (isStopRequested()) return;
        while (opModeIsActive()) {

            //TODO EITHER TUNE THIS FOR A PRELOAD DELIVERY OR PARK AND STOP OR IF COLOR SENSOR WORKS DO THAT
            int endForward;

            do {
                endForward = forward(1000);
            } while (endForward != 1);

            int endRight;
            do {
                 endRight = right(1000);
            } while (endRight != 1);

       //     if (endRight == 1) {
         //       linearSlide.slideMovement(true, false, false, false);
            }

            telemetry.addData("Encoder Position", motorBackRight.getCurrentPosition());
            telemetry.update();

        }






    public int forward(int distance) {

        motorBackRight.setTargetPosition(distance);
        motorBackLeft.setTargetPosition(distance);
        motorFrontRight.setTargetPosition(distance);
        motorFrontLeft.setTargetPosition(distance);

        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorBackRight.setPower(1);
        motorBackLeft.setPower(1);
        motorFrontRight.setPower(1);
        motorFrontLeft.setPower(1);

        return 1;

    }
    public int right(int distance) {

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


        return 1;
    }

}

