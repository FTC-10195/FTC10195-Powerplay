package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.Robot;

@TeleOp(name = "MecanumTeleOp", group = "2")
public class MecanumTeleOp extends LinearOpMode {

    protected Robot wildWing = new Robot();

    private boolean music = false;
    private int musicID;
    private boolean first = true;

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot(wildWing, Robot.Alliance.BLUE);
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            mainLoop(wildWing);
        }
    }

    public void initRobot(Robot robot, Robot.Alliance alliance) {
        robot.init(hardwareMap, alliance);
        /*musicID = hardwareMap.appContext.getResources().getIdentifier("koopacape", "raw", hardwareMap.appContext.getPackageName());
        if (musicID != 0) {
            music = SoundPlayer.getInstance().preload(
                    hardwareMap.appContext,
                    musicID
            );
        }*/

    }

    public void mainLoop(Robot robot) {
        /*if (first && music) {
            SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, musicID);
            first = false;
        }*/
        robot.drive(
                telemetry,
                gamepad1.left_stick_x,
                gamepad1.left_stick_y,
                gamepad1.right_stick_x,
                gamepad1.left_trigger,
                gamepad1.right_bumper,
                gamepad1.left_bumper,
                gamepad1.right_trigger > 0.1 || gamepad2.right_trigger > 0.1,
                gamepad2.left_trigger > 0.1,
                gamepad1.dpad_up || gamepad2.x,
                gamepad1.dpad_down || gamepad2.b,
                gamepad2.dpad_down,
                gamepad2.dpad_right,
                gamepad2.dpad_up,
                gamepad1.a || gamepad2.a,
                gamepad1.y || gamepad2.y,
                gamepad2.right_bumper,
                gamepad2.left_bumper
        );
    }
}