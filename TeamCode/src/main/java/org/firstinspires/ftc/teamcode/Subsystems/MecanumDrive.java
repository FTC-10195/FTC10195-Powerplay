package org.firstinspires.ftc.teamcode.Subsystems;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import static java.lang.Enum.valueOf;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class MecanumDrive  {
   public DcMotor motorFrontLeft;
  public  DcMotor motorBackLeft;
  public  DcMotor motorFrontRight;
  public  DcMotor motorBackRight;
    BNO055IMU imu;


    //hardware mapping function- constructor of the class
    public MecanumDrive(HardwareMap hwmap, Telemetry telemetry1) {
        // Declare our motors
        // Make sure your ID's match your configuration
         motorFrontLeft = hwmap.dcMotor.get("fl");
         motorBackLeft = hwmap.dcMotor.get("bl"); //reverse this
         motorFrontRight = hwmap.dcMotor.get("fr");
         motorBackRight = hwmap.dcMotor.get("br"); //reverse
        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
       // motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    //    motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
      //TODO THIS MOTOR NEEDS TO BE REVERSED ON THE MAIN ROBOT, UNCOMMENT LINE WHEN WORKING ON MAIN ROBOT//
   //    motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
       //  motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

         motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
         motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
   //   motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
       // motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        // Retrieve the IMU from the hardware map
        imu = hwmap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        // Technically this is the default, however specifying it is clearer
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        // Without this, data retrieving from the IMU throws an exception
        imu.initialize(parameters);

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
        // Reverse the right side motors        // Reverse left motors if you are using NeveRests
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor.ZeroPowerBehavior zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE;
        motorBackRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorBackLeft.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontLeft.setZeroPowerBehavior(zeroPowerBehavior);
*/
        telemetry = telemetry1;
    }

public void drive(double upDown, double strafe, double turn) {

    upDown = upDown; // Remember, this is reversed!
    strafe = -strafe * 1.1; // Counteract imperfect strafing
    turn =-turn;


    double denominator = Math.max(Math.abs(upDown) + Math.abs(strafe) + Math.abs(turn), 1);
            double frontLeftPower = (upDown + strafe + turn) / denominator;
            double backLeftPower = (upDown - strafe + turn) / denominator;
            double frontRightPower = (upDown - strafe - turn) / denominator;
            double backRightPower = (upDown + strafe - turn) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);


}
public void fieldDrive(double upDown, double strafe, double turn) {
             upDown = upDown; // Remember, this is reversed!
             strafe = -strafe * 1.1; // Counteract imperfect strafing
             turn =-turn;
            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
    double botHeading = -imu.getAngularOrientation().firstAngle;
    double rotX = strafe * Math.cos(botHeading) - upDown * Math.sin(botHeading);
    double rotY = strafe * Math.sin(botHeading) + upDown * Math.cos(botHeading);

    double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(turn), 1);
    double frontLeftPower = (rotY + rotX + turn) / denominator;
    double backLeftPower = (rotY - rotX + turn) / denominator;
    double frontRightPower = (rotY - rotX - turn) / denominator;
    double backRightPower = (rotY + rotX - turn) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);

            telemetry.addData("rotx", rotX);
    telemetry.addData("roty", rotY);
    telemetry.addData("frontleft", frontLeftPower);
    telemetry.addData("backleft", backLeftPower);
    telemetry.addData("backright", backRightPower);
    telemetry.addData("frontright", frontRightPower);
    telemetry.addData("heading", botHeading);
    telemetry.update();





    /*  double y = gamepad1.left_stick_y; // Remember, this is reversed!
            double x =-gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double turn =-gamepad1.right_stick_x; */

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
      /*      double denominator = Math.max(Math.abs(upDown) + Math.abs(strafe) + Math.abs(turn), 1);
            double frontLeftPower = (upDown + strafe + turn) / denominator;
            double backLeftPower = (upDown - strafe + turn) / denominator;
            double frontRightPower = (upDown - strafe - turn) / denominator;
            double backRightPower = (upDown + strafe - turn) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);
*/
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
