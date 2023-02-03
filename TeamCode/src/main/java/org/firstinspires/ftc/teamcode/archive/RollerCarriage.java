package org.firstinspires.ftc.teamcode.archive;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RollerCarriage {
    public final int OUTTAKE = 1;
    public final int INTAKE = 0;
    Servo rollerServo;
    public RollerCarriage(HardwareMap hardwareMap) {
        rollerServo = hardwareMap.servo.get("rollerS");
        rollerServo.setPosition(INTAKE);
    }
    public enum STATES  {
        OUT,
        IN
    }
    RollerCarriage.STATES rollerStates = RollerCarriage.STATES.IN;

    public void switchStates(boolean brr, boolean rrb) {
        switch (rollerStates) {
            case IN:
                movement(true, false);
                if(rrb) {
                    rollerStates = rollerStates.OUT;
                }
            case OUT:
                movement(false, true);
                if(brr) {
                    rollerStates = rollerStates.IN;
                }

        }
    }

    public void movement(boolean in, boolean out) {
        if(in) {
            rollerServo.setPosition(INTAKE);

        }
        else if(out) {
            rollerServo.setPosition(OUTTAKE);
        }
    }



}
