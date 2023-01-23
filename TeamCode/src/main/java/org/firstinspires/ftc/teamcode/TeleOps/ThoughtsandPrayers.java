package org.firstinspires.ftc.teamcode.TeleOps;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;

@TeleOp(group = "Match TeleOps")

public class ThoughtsandPrayers extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap, telemetry);
        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {
           mecanumDrive.fieldDrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}
}