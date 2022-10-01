package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class LinearSlideTest extends LinearOpMode {
    DcMotorEx ls; //defines motor

    @Override
    public void runOpMode() throws InterruptedException {
        ls = hardwareMap.get(DcMotorEx.class, "linearSlide"); //Sets motor

        while (opModeIsActive()) {                  //Controls movement
            boolean y = gamepad1.right_bumper;
            boolean x = gamepad1.left_bumper;
            if (y) {
                ls.setPower(1);
            }
            if (x) {
                ls.setPower(-1);
            }
            telemetry.addData("Encoder Value", ls.getCurrentPosition());
            telemetry.update();
        }
    }
}