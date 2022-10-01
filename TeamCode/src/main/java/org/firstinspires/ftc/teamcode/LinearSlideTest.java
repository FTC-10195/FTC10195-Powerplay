package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class LinearSlideTest extends LinearOpMode {
    DcMotorEx ls; //defines motor
    @Override
    public void runOpMode() throws InterruptedException {
        ls = hardwareMap.get(DcMotorEx.class, "ls"); //Sets motor

        while (opModeIsActive()) {                  //Controls movement
            double y = gamepad1.right_trigger;
            double lsPower = (y);
            ls.setPower(lsPower);

        }
    }
}