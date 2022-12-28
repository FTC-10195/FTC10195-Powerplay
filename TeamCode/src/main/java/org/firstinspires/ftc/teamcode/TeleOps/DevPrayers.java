package org.firstinspires.ftc.teamcode.TeleOps;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.ClawBar;
import org.firstinspires.ftc.teamcode.Subsystems.LinearSlide;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.Subsystems.OuttakeSlides;
import org.firstinspires.ftc.teamcode.Subsystems.VirtualFourBar;

@TeleOp(group = "Tests")
public class DevPrayers extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
      //  MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap, telemetry);
        ClawBar intake = new ClawBar(hardwareMap);
        //VirtualFourBar bar = new VirtualFourBar(hardwareMap);
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
        //    mecanumDrive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
          intake.intake(gamepad1.a, gamepad1.x);
           // bar.rollerRotate(gamepad1.a, gamepad1.b);
        }

    }
}