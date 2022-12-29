package org.firstinspires.ftc.teamcode.Tests.MainBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(group = "Tests")
public class V4BTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {


        double servoOne = 0;

    double servoTwo = 0;

    //falling edge detector
    boolean previousRightBumper = gamepad1.right_bumper;

    boolean previousLeftBumper = gamepad1.left_bumper;

    Servo one = hardwareMap.servo.get("s1");
        Servo two = hardwareMap.servo.get("s2");

two.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

        one.setPosition(servoOne);

        two.setPosition(servoTwo);

        if (gamepad1.right_bumper && !previousRightBumper) {
            servoOne += .05;
            servoTwo += .05;

        }

        if (gamepad1.left_bumper && !previousLeftBumper) {
            servoOne -= .05;
            servoTwo -= .05;
        }


        //falling edge detector, prevents the input from repeating during the loop
        previousRightBumper = gamepad1.right_bumper;
        previousLeftBumper = gamepad1.left_bumper;

        telemetry.addData("Servo One Position", servoOne);
        telemetry.addData("Servo Two Position", servoTwo);
        telemetry.update();
    }
}

}
