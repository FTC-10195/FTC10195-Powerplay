package org.firstinspires.ftc.teamcode.TeleOps;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Claw;

import org.firstinspires.ftc.teamcode.Subsystems.Intake.VirtualFourBar;

@TeleOp(group = "Tests")
public class DevPrayers extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
      //  MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap, telemetry);
<<<<<<< HEAD
        ClawBar intake = new ClawBar(hardwareMap);
        //VirtualFourBar bar = new VirtualFourBar(hardwareMap);
=======
       // ClawBar intake = new ClawBar(hardwareMap);
        VirtualFourBar bar = new VirtualFourBar(hardwareMap);
>>>>>>> 0021c53ef22d391898991cd0061541650835bea9
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
        //    mecanumDrive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
<<<<<<< HEAD
          intake.intake(gamepad1.a, gamepad1.x);
           // bar.rollerRotate(gamepad1.a, gamepad1.b);
=======
         //   intake.intake(gamepad1.a, gamepad1.x);
        //    intake.intake(gamepad1.x, gamepad1.y);
>>>>>>> 0021c53ef22d391898991cd0061541650835bea9
        }

    }
}