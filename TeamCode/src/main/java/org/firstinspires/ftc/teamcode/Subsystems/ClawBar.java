package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class ClawBar {

    public Servo clawServo1;
    public Servo clawServo2;
    public Servo rollerServo1;
    public Servo rollerServo2;
    public final double OUT_POSITION = 0;
    public final double IN_POSITION = .6;
    public final double OPEN_CLAW = 0;
    public final double CLOSED_CLAW = .4;




    public ClawBar(HardwareMap hwmap) {
        clawServo1 = hwmap.servo.get("clawOne");
        clawServo2 = hwmap.servo.get("clawTwo");
        rollerServo1 = hwmap.servo.get("rollerServo1");
        rollerServo2 = hwmap.servo.get("rollerServo2");


    }

    //TODO CHANGE THESE VALUES TO BE BETTER

    public enum ClawState {
        OPEN,
        CLOSED
    }

    public ClawState clawState = ClawState.OPEN;

    public void intake(boolean openButton, boolean closedButton) throws InterruptedException {
        switch (clawState) {
            case OPEN:
                clawServo1.setPosition(OPEN_CLAW);
                clawServo2.setPosition(OPEN_CLAW);
                rollerServo1.setPosition(OUT_POSITION);
                rollerServo2.setPosition(OUT_POSITION);
                if (closedButton) {
                    clawState = ClawState.CLOSED;
                }
                break;
            case CLOSED:
                clawServo1.setPosition(CLOSED_CLAW);
                clawServo2.setPosition(CLOSED_CLAW);
                rollerServo1.setPosition(OUT_POSITION);
                rollerServo2.setPosition(OUT_POSITION);
                if (openButton) {
                    clawState = ClawState.OPEN;
                }
                break;
        }

    }
}

