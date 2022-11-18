package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class BasicTeleOp extends LinearOpMode {
   //basic teleop for mecanum
    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive mecanumDrive = new MecanumDrive(hardwareMap);
        //Claw claw = new Claw(hardwareMap);
        //LinearSlide linearSlide = new LinearSlide(hardwareMap);
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            //claw.intake(gamepad1.a, gamepad1.x);
            //claw.intake(gamepad2.a, gamepad2.x);
            mecanumDrive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
            //if(gamepad2.dpad_down) {claw.intake(false, true);}
            //linearSlide.slideMovement(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
            //linearSlide.manualMove(gamepad1.left_trigger,gamepad1.right_trigger, gamepad1.b);

    }
}
}