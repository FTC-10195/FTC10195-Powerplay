package org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Claw {

    public Servo clawServo;
    Telemetry telemetry;


    public Claw(HardwareMap hwmap, Telemetry telemetry) {
        clawServo = hwmap.servo.get("clawOne");
        this.telemetry = telemetry;
    }

    //TODO CHANGE THESE VALUES TO BE BETTER
    public final double OPEN_CLAW = 0;
    public final double CLOSED_CLAW = .55;

public enum claw {
    OPEN,
    CLOSED
}
claw ClawState = claw.CLOSED;

public void clawMove(boolean openButton, boolean closedButton) {

        switch(ClawState) {
            case OPEN:
               move(OPEN_CLAW);
               if(closedButton) {
                   ClawState = claw.CLOSED;
               }
               break;

            case CLOSED:
                move(CLOSED_CLAW);
                if(openButton) {
                    ClawState = claw.OPEN;
                }
                break;
        }

        }


        private void move(double position) {
        clawServo.setPosition(position);

    }
}


