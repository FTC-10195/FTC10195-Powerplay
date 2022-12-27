package org.firstinspires.ftc.teamcode.TeleOps;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.LinearSlide;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.Subsystems.OuttakeSlides;
import org.firstinspires.ftc.teamcode.Subsystems.VirtualFourBar;

@TeleOp(group = "Match TeleOps")

public class ThoughtsandPrayers extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap, telemetry);
     //   VirtualFourBar v4b = new VirtualFourBar(hardwareMap);
      // Claw claw = new Claw(hardwareMap);
    //   OuttakeSlides slide = new OuttakeSlides(hardwareMap);
        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {
           mecanumDrive.fieldDrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
      //     claw.intake(gamepad1.x, gamepad1.b);
   //       slide.move(gamepad1.dpad_left, gamepad1.dpad_right, gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.y, gamepad1.a);
           // v4b.rollerRotate(gamepad1.x, gamepad1.b);
          //claw.intake(gamepad1.left_bumper,gamepad1.right_bumper);


    }
}
}