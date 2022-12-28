package org.firstinspires.ftc.teamcode.Tests.MainBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(group = "Tests")
public class V4BTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        double clawServo1Position = 0;

    double clawServo2Position = 0;

    //falling edge detector
    boolean previousRightBumper = gamepad1.right_bumper;

    boolean previousLeftBumper = gamepad1.left_bumper;

    Servo one = hardwareMap.servo.get("s1");
        Servo two = hardwareMap.servo.get("s2");



        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

        one.setPosition(clawServo1Position);

        two.setPosition(clawServo2Position);

        if (gamepad1.right_bumper && !previousRightBumper) {
            clawServo1Position += .05;
            clawServo2Position -= .05;

        }

        if (gamepad1.left_bumper && !previousLeftBumper) {
            clawServo1Position -= .05;
            clawServo2Position += .05;
        }


        //falling edge detector, prevents the input from repeating during the loop
        previousRightBumper = gamepad1.right_bumper;
        previousLeftBumper = gamepad1.left_bumper;

        telemetry.addData("Servo One Position", clawServo1Position);
        telemetry.addData("Servo Two Position", clawServo2Position);
        telemetry.update();
    }
}

}
