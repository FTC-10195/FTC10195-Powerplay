package org.firstinspires.ftc.teamcode.Subsystems.Intake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class VirtualFourBar {
    public Servo vOne;
    public Servo vTwo;
    public final double IN_POSITION = 0;
    public final double OUT_POISTION = .6;

    public VirtualFourBar(HardwareMap hwmap) {
        vOne = hwmap.get(Servo.class, "s1");
        vOne.setDirection(Servo.Direction.REVERSE);
        vTwo = hwmap.get(Servo.class, "s2");
    }

    public void barMove(boolean in, boolean out) {
        if (in) {
            move(IN_POSITION);
        }
        if (out) {
            move(OUT_POISTION);
        }
    }

    private void move(double position) {
        vOne.setPosition(position);
        vTwo.setPosition(position);

    }


}