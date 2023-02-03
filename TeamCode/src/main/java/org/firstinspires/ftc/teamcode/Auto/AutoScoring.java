package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Auto.AprilTags.PrayersAuto;
import org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad.LinearSlide;
import org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad.Linkage;

public class AutoScoring extends LinearOpMode {
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackRight;

    @Override
    public void runOpMode() throws InterruptedException {
        LinearSlide slide = new LinearSlide(hardwareMap, telemetry);
        Claw claw = new Claw(hardwareMap);
        Linkage link = new Linkage(hardwareMap);

        //all of the init stuff
        motorFrontLeft = hardwareMap.dcMotor.get("fl");
        motorBackLeft = hardwareMap.dcMotor.get("bl"); //reverse this
        motorFrontRight = hardwareMap.dcMotor.get("fr");
        motorBackRight = hardwareMap.dcMotor.get("br"); //reverse
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


        if (isStopRequested()) return;

        if(PrayersAuto.zone == 1) {

        }


    }
}