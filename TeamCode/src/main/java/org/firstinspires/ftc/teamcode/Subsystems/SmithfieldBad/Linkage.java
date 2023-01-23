package org.firstinspires.ftc.teamcode.Subsystems.SmithfieldBad;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Linkage {
    public final int OUTTAKE = 1;
    public final int INTAKE = 0;
    Servo linkageServo;
    Servo linkageServo1;
    public int position;

    public Linkage(HardwareMap hardwareMap) {
         linkageServo  = hardwareMap.servo.get("linkageS");
         linkageServo1 = hardwareMap.servo.get("linkageS1");
        linkageServo.setPosition(INTAKE);
    }

    public enum STATES  {
        OUT,
        IN,
        MANUAL
    }
    STATES linkageStates = STATES.IN;

    public void switchStates(boolean brr, boolean rrb) {
        switch (linkageStates) {
            case IN:
                movement(true, false);
                if(rrb) {
                    linkageStates = linkageStates.OUT;
                }
            case OUT:
                movement(false, true);
                if(brr) {
                    linkageStates = linkageStates.IN;
                }
            case MANUAL:
                manualMovement(brr, rrb);

        }
    }

    public void movement(boolean in, boolean out) {
        if (in) {
            linkageServo.setPosition(INTAKE);
            linkageServo1.setPosition(INTAKE);


        } else if (out) {
            linkageServo.setPosition(OUTTAKE);
            linkageServo1.setPosition(OUTTAKE);

        }
    }
        public void manualMovement(boolean brr, boolean rrb) {
            if(brr) {
                position+= .05;
            }
            if(rrb) {
                position -= .05;
            }
            linkageServo.setPosition(position);
            linkageServo1.setPosition(position);
        }



    }

