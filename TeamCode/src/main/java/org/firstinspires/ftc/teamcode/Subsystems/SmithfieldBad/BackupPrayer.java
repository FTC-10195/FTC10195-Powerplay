package org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.archive.RollerCarriage;

@TeleOp(group = "Match TeleOps")
public class BackupPrayer extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap, telemetry);
        LinearSlide slide = new LinearSlide(hardwareMap, telemetry);
      //  RollerCarriage roll = new RollerCarriage(hardwareMap);
      //  Linkage link = new Linkage(hardwareMap);
        Claw claw = new Claw(hardwareMap, telemetry);
        waitForStart();

        if (isStopRequested()) return;


        while (opModeIsActive()) {

            mecanumDrive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.a);

         //   slide.slideStates(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right, gamepad1.y, gamepad1.b);

           slide.manualMove(gamepad1.b, gamepad1.a);
           if(gamepad1.b && claw.ClawState != claw.ClawState.CLOSED){
               claw.clawMove(true, false);
               slide.manualMove(true, false);

            }
          //  slide.slideMovement(gamepad1.dpad_up, gamepad1.dpad_down, game.pad1.dpad_left, gamepad1.dpad_right);
         //   link.switchStates(gamepad1.a, gamepad1.x);
           // link.movement(gamepad1.y, gamepad1.x);
            claw.clawMove(gamepad1.left_bumper, gamepad1.right_bumper);
           // link.switchStates(gamepad1.a, gamepad1.x);
            //roll.switchStates(gamepad1.left_bumper, gamepad1.right_bumper);
          /*  if (gamepad1.dpad_right) {
                slide.slideStates(true, false, false, false, false, false);
                if (slide.currentPosition > 3000) {
                    link.switchStates(true, false);
                }
                if (gamepad1.dpad_left) {
                    slide.slideStates(false, false, true, false, false, false);
                    if (slide.currentPosition > 3000) {
                        link.switchStates(true, false);
                    }
                    if (gamepad1.dpad_down) {
                        if (slide.currentPosition > 3000)
                            link.switchStates(false, true);
                        slide.slideStates(false, true, true, false, false, false);

                        if (gamepad1.dpad_up) {
                            slide.slideStates(true, false, false, false, false, false);
                            if (slide.currentPosition > 3000) {
                                link.switchStates(true, false);
                            }
*/

                        }
                    }

                }

