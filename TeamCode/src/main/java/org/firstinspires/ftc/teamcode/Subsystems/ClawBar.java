package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class ClawBar {

    public Servo clawServo1;
    public Servo clawServo2;
    public Servo rollerServo1;
    public Servo rollerServo2;
    public final double OUT_POSITION = 0;
    public final double IN_POSITION = .6;
    public final double OPEN_CLAW = 0;
    public final double CLOSED_CLAW = .4;
    ElapsedTime timer;



    public ClawBar(HardwareMap hwmap) {
        clawServo1 = hwmap.servo.get("clawOne");
        clawServo2 = hwmap.servo.get("clawTwo");
        rollerServo1 = hwmap.servo.get("rollerServo1");
        rollerServo2 = hwmap.servo.get("rollerServo2");
        timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    }

    //TODO CHANGE THESE VALUES TO BE BETTER

    public enum ClawState {
        OPEN,
        CLOSED
    }

    public ClawState clawState = ClawState.OPEN;

    public void intake(boolean openButton, boolean closedButton)  {
        switch (clawState) {
            case OPEN:
                timer.startTime();
                clawServo1.setPosition(OPEN_CLAW);
                clawServo2.setPosition(OPEN_CLAW);
                if(timer.time() > 100) {
                    rollerServo1.setPosition(IN_POSITION);
                    rollerServo2.setPosition(IN_POSITION);
                    timer.reset();
                }
                if (closedButton) {
                    clawState = ClawState.CLOSED;
                }
                break;
            case CLOSED:
                timer.startTime();
                clawServo1.setPosition(CLOSED_CLAW);
                clawServo2.setPosition(CLOSED_CLAW);
                if(timer.time() > 100) {
                    rollerServo1.setPosition(OUT_POSITION);
                    rollerServo2.setPosition(OUT_POSITION);
                    timer.reset();
                }
                if (openButton) {
                    clawState = ClawState.OPEN;
                }
                break;
        }

    }
}

