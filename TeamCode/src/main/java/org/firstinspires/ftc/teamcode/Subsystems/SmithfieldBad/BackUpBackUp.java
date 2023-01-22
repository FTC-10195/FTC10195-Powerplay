package org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;

@TeleOp
public class BackUpBackUp extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
         final int OUTTAKER = 1;
         final int INTAKER = 0;
        MecanumDrive drive = new MecanumDrive(hardwareMap, telemetry);
        int position = 0;
        Servo rollerServo = hardwareMap.servo.get("rollerS");
        rollerServo.setPosition(INTAKER);

Servo linkageServo1 = hardwareMap.servo.get("linkageS1");
      Servo linkageServo  = hardwareMap.servo.get("linkageS");

      linkageServo.setPosition(INTAKER);
        linkageServo1.setPosition(INTAKER);
        DcMotorEx linearSlide = hardwareMap.get(DcMotorEx.class, "ls");
       DcMotorEx linearSlide2 = hardwareMap.get(DcMotorEx.class, "ls2");

        //Sets motor
        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        linearSlide.setDirection(DcMotorSimple.Direction.REVERSE);


        linearSlide2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearSlide2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearSlide2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();

        if (isStopRequested()) return;


        while (opModeIsActive()) {

            drive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

                linearSlide.setPower(.5);
                linearSlide2.setPower(.5);

            if(gamepad1.x) {
                linkageServo.setPosition(OUTTAKER);
                linkageServo1.setPosition(OUTTAKER);
            }
            else if(gamepad1.b) {
                position-= .5;
                linkageServo.setPosition(INTAKER);
                linkageServo1.setPosition(INTAKER);
            }
            if(gamepad1.left_bumper) {

                rollerServo.setPosition(OUTTAKER);
            }
            else if (gamepad1.left_bumper) {
                rollerServo.setPosition(INTAKER);
            }


        }


        }
    }

