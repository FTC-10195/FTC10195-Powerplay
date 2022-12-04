package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

//example of how to use a Finite State Machine (fsm)
public class Claw {

    //declare the two servos
    public Servo clawServo1;
    public Servo clawServo2;

//constructor of the function- only need this if you are calling this from another functiton
    public Claw(HardwareMap hwmap) {

        clawServo1 = hwmap.get(Servo.class, "clawOne");
        clawServo2 = hwmap.get(Servo.class, "clawTwo");
    }

    //TODO CHANGE THESE VALUES TO BE BETTER
    public final double OPEN_CLAW = 0;
    public final double CLOSED_CLAW = .28;

    //finite state machine
    //enum = finite state machine
    //this has multiple states, or status' that can be switched through in order to run code
    //this allows multiple systems to run at the same time
    public enum ClawState {
        OPEN,
        CLOSED
    }
//start by declaring the object of the finite state machine- this is the same as declaring a Servo servo, for example.
    public ClawState clawState = ClawState.OPEN;

    public void intake(boolean openButton, boolean closedButton) {
    //boiler plate
        //switch the claw state with two different cases
        switch (clawState) {
            case OPEN:
                clawServo1.setPosition(OPEN_CLAW);
                clawServo2.setPosition(OPEN_CLAW);
               //if, while the claw is in the sttate open, and the claw close button is pressed, switch the state to claw closed
                if (closedButton) {
                    clawState = ClawState.CLOSED;
                }
              //add the break bc otherwise it will run all of the states
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