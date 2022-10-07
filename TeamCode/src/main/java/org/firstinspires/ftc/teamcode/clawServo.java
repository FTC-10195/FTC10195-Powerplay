package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class clawServo extends LinearOpMode {
    private final double OPEN_CLAW = 0;
    private final double CLOSED_CLAW = 1;
    public void runOpMode() throws InterruptedException {
        Servo clawServo = hardwareMap.servo.get("claw");
        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {

            if(gamepad2.a == true) {
                clawServo.setPosition(OPEN_CLAW);
            }

            if(gamepad2.x == true) {
                clawServo.setPosition(CLOSED_CLAW);
            }
        }


    }
}
