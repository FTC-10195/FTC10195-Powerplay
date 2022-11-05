package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class MecanumDrive  {
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;

    //hardware mapping function- constructor of the class
    public MecanumDrive(HardwareMap hwmap) {
        // Declare our motors
        // Make sure your ID's match your configuration
         motorFrontLeft = hwmap.dcMotor.get("fl");
         motorBackLeft = hwmap.dcMotor.get("bl"); //reverse this
         motorFrontRight = hwmap.dcMotor.get("fr");
         motorBackRight = hwmap.dcMotor.get("br"); //reverse
        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    //    motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
      //TODO THIS MOTOR NEEDS TO BE REVERSED ON THE MAIN ROBOT, UNCOMMENT LINE WHEN WORKING ON MAIN ROBOT//
          motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor.ZeroPowerBehavior zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE;
        motorBackRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorBackLeft.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontLeft.setZeroPowerBehavior(zeroPowerBehavior);

         motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        /*   // Declare our motors
        // Make sure your ID's match your configuration
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("fl");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("bl"); //reverse this
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("fr");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("br"); //reverse
        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor.ZeroPowerBehavior zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE;
        motorBackRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorBackLeft.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontLeft.setZeroPowerBehavior(zeroPowerBehavior);
*/
    }


public void drive(double upDown, double strafe, double turn) {
             upDown = -upDown; // Remember, this is reversed!
             strafe =strafe * 1.1; // Counteract imperfect strafing
             turn =turn;


            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(upDown) + Math.abs(strafe) + Math.abs(turn), 1);
            double frontLeftPower = (upDown + strafe + turn) / denominator;
            double backLeftPower = (upDown - strafe + turn) / denominator;
            double frontRightPower = (upDown - strafe - turn) / denominator;
            double backRightPower = (upDown + strafe - turn) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);

            /*  double y = gamepad1.left_stick_y; // Remember, this is reversed!
            double x =-gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx =-gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower); */

        }

    }
