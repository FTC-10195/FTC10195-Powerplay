package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class LinearSlidethingy extends LinearOpMode{

    @Override

    public void runOpMode() throws InterruptedException {
        DcMotor linearSlide = hardwareMap.dcMotor.get("fl");

        waitForStart();
    }

}
