package org.firstinspires.ftc.teamcode.Tests.MainBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(group = "Tests")
public class V4BTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Servo one = hardwareMap.servo.get("s1");
        Servo two = hardwareMap.servo.get("s2");

        waitForStart();


        if (isStopRequested()) return;

        while (opModeIsActive()) {
            one.setPosition(.5);
            two.setPosition(.5);

        }
    }
}
