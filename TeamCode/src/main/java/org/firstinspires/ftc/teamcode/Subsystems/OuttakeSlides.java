package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OuttakeSlides {
    DcMotorEx slide;
    public final int MAX_VAL = 7000;
    public final int LOW = 400;
    public final int MEDIUM = 700;
    public final int HIGH = 1000;
    public final int ZERO = 0;

    public OuttakeSlides(HardwareMap map) {
        slide = map.get(DcMotorEx.class, "ls");
        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public enum STATES {
        LOW,
        MEDIUM,
        HIGH,
        ZERO,
        MAX,
    }

}
