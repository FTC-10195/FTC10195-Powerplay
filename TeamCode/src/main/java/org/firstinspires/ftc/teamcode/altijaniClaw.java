package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class altijaniClaw extends LinearOpMode {

    double topCP = 0.5;

    double bottomCP = 0.5;

    boolean rb = false;

    boolean lb = false;

    @Override
    public void runOpMode() throws InterruptedException {

        Servo servoTop = hardwareMap.servo.get("topCP");

        Servo servoBottom = hardwareMap.servo.get("bottomCP");

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            servoTop.setPosition(topCP);

            servoBottom.setPosition(bottomCP);

            if (gamepad1.right_bumper && !rb) {

                topCP -= 0.05;
                bottomCP += 0.05;
            }

            if (gamepad1.left_bumper && !lb) {

                topCP += 0.05;
                bottomCP -= 0.05;

            }

            rb = gamepad1.right_bumper;

            lb = gamepad1.left_bumper;

            telemetry.addData("Top Claw Position",topCP);

            telemetry.addData("Bottom Claw Position",bottomCP);

            telemetry.update();
    }
}