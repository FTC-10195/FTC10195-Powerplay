package org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;

public class BackupBackupBackup extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive drive = new MecanumDrive(hardwareMap, telemetry);
        waitForStart();


        if (isStopRequested()) return;


        while (opModeIsActive()) {
            drive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        }


        }
    }