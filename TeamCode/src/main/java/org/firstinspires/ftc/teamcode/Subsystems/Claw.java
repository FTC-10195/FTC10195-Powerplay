package org.firstinspires.ftc.teamcode.Subsystems;

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

        clawServo1 = hwmap.get(Servo.class, "clawOne");
        clawServo2 = hwmap.get(Servo.class, "clawTwo");
    }

    //TODO CHANGE THESE VALUES TO BE BETTER
    public final double OPEN_CLAW = 0;
    public final double CLOSED_CLAW = .28;

    public enum ClawState {
        OPEN,
        CLOSED
    }

    public ClawState clawState = ClawState.OPEN;

    public void intake(boolean openButton, boolean closedButton) {
        switch (clawState) {
            case OPEN:
                clawServo1.setPosition(OPEN_CLAW);
                clawServo2.setPosition(OPEN_CLAW);
                if (closedButton) {
                    clawState = ClawState.CLOSED;
                }
                break;
            case CLOSED:
                clawServo1.setPosition(CLOSED_CLAW);
                clawServo2.setPosition(CLOSED_CLAW);
                if (openButton) {
                    clawState = ClawState.OPEN;
                }
                break;
        }

    }
}

