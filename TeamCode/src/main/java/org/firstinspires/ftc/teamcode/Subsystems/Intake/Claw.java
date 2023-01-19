package org.firstinspires.ftc.teamcode.Subsystems.Intake;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Claw {

    public Servo clawServo1;
    public Servo clawServo2;


    public Claw(HardwareMap hwmap) {
        clawServo1 = hwmap.servo.get("clawOne");
        clawServo2 = hwmap.servo.get("clawTwo");
    }

    //TODO CHANGE THESE VALUES TO BE BETTER
    public final double OPEN_CLAW = 0;
    public final double CLOSED_CLAW = .4;


    public void clawMove(boolean openButton, boolean closedButton) {

        if(openButton) {move(OPEN_CLAW);}
        if(closedButton) {move(CLOSED_CLAW);}
        }


        private void move(double position) {
        clawServo1.setPosition(position);
        clawServo2.setPosition(position);

    }
}


