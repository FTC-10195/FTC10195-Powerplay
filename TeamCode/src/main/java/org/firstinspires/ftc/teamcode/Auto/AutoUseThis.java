package org.firstinspires.ftc.teamcode.Auto;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous
public class AutoUseThis extends LinearOpMode {
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;


    @Override
    public void runOpMode() throws InterruptedException {
        motorFrontLeft = hardwareMap.dcMotor.get("fl");
        motorBackLeft = hardwareMap.dcMotor.get("bl"); //reverse this
        motorFrontRight = hardwareMap.dcMotor.get("fr");
        motorBackRight = hardwareMap.dcMotor.get("br"); //reverse
     //   motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        //    motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        //TODO THIS MOTOR NEEDS TO BE REVERSED ON THE MAIN ROBOT, UNCOMMENT LINE WHEN WORKING ON MAIN ROBOT//
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor.ZeroPowerBehavior zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE;
        motorBackRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorBackLeft.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontRight.setZeroPowerBehavior(zeroPowerBehavior);
        motorFrontLeft.setZeroPowerBehavior(zeroPowerBehavior);

        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();



        if (isStopRequested()) return;
        while (opModeIsActive()) {
            int br = motorBackRight.getCurrentPosition();
            int bl =   motorBackLeft.getCurrentPosition();
            int fr =  motorFrontRight.getCurrentPosition();
            int fl =  motorFrontLeft.getCurrentPosition();
            //TODO scrim is cursed i hate it here
            forward(1000);
            telemetry.addData("motorBackRight", br);
            telemetry.addData("motorBackLeft", bl);
            telemetry.addData("motorFrontRight", fr);
            telemetry.addData("motorFrontLeft", fl);
            telemetry.update();


        }
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

        motorBackRight.setPower(.1);
        motorBackLeft.setPower(.1);
        motorFrontRight.setPower(.1);
        motorFrontLeft.setPower(.1);
        return 1;

    }

}

