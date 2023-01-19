package org.firstinspires.ftc.teamcode.TeleOps;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.Subsystems.Intake.VirtualFourBar;

@TeleOp(group = "Tests")
public class DevPrayers extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
      //  MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap, telemetry);
        //VirtualFourBar bar = new VirtualFourBar(hardwareMap);
       // ClawBar intake = new ClawBar(hardwareMap);
        VirtualFourBar bar = new VirtualFourBar(hardwareMap);
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
        //    mecanumDrive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
           // bar.rollerRotate(gamepad1.a, gamepad1.b);
        }

    }
}