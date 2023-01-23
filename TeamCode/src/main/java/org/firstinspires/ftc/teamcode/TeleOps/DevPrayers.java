package org.firstinspires.ftc.teamcode.TeleOps;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.Subsystems.Intake.VirtualFourBar;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;

@TeleOp(group = "Tests")
public class DevPrayers extends LinearOpMode {
    MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap, telemetry);
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
          mecanumDrive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
           // bar.rollerRotate(gamepad1.a, gamepad1.b);
        }

    }
}