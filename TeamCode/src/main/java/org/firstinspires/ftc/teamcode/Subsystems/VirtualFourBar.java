package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoControllerEx;
import com.qualcomm.robotcore.util.ElapsedTime;


public class VirtualFourBar {

    public Servo rollerServo1;
    public Servo rollerServo2;
    public final double OUT_POSITION = 0;
    public final double IN_POISTION = .6;
    public enum FourBar {
        OUT,
        IN
    }

    public VirtualFourBar(HardwareMap hwmap) {
        rollerServo1 = hwmap.get(Servo.class, "rollerServo1");
        rollerServo2 = hwmap.get(Servo.class, "rollerServo1");
    }

    FourBar fourBarState = FourBar.OUT;

    //TODO CHANGE THESE VALUES TO BE BETTER
    public void rollerRotate(boolean open, boolean closed) {
        switch(fourBarState) {
            case IN:
               rollerServo1.setPosition(IN_POISTION);
               rollerServo2.setPosition(IN_POISTION);
                if(closed) {
                    fourBarState = fourBarState.IN;
                }
                break;
            case OUT:
                rollerServo1.setPosition(OUT_POSITION);
                rollerServo2.setPosition(OUT_POSITION);
                if(open) {
                    fourBarState = fourBarState.IN;
                }
                break;


        }

    }


}