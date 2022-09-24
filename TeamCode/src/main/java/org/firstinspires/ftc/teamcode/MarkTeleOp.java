package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MarkTeleOp extends LinearOpMode {
    DcMotorEx fl, fr, bl, br; //defines motors
    @Override
    public void runOpMode() throws InterruptedException {
        fl = hardwareMap.get(DcMotorEx.class, "fl"); //Sets motors
        fr = hardwareMap.get(DcMotorEx.class, "fr");
        bl = hardwareMap.get(DcMotorEx.class, "bl");
        br = hardwareMap.get(DcMotorEx.class, "br");

        fr.setDirection(DcMotorEx.Direction.REVERSE); //Sets some of the motors to reverse
        br.setDirection(DcMotorEx.Direction.REVERSE);
        waitForStart();

        while (opModeIsActive()) {                  //Controls movement
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1; //Counteracts imperfect strafing
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1); //Essentially calculates movement and strafing
            double flPower = (y + x + rx) / denominator;
            double frPower = (y - x + rx) / denominator;
            double blPower = (y - x - rx) / denominator;
            double brPower = (y + x - rx) / denominator;

            fl.setPower(flPower);
            fr.setPower(frPower);
            bl.setPower(blPower);
            br.setPower(brPower);
        }
    }
}
