package org.firstinspires.ftc.teamcode.Subsystems.Intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSlides {
    DcMotorEx motorOne;
    DcMotorEx motorTwo;


    public final int OUT_POSITION = 5000;
    public final int IN_POSITION = 0;

    public IntakeSlides(HardwareMap hwap) {
        motorOne = (DcMotorEx) hwap.dcMotor.get("in1");
        motorTwo = (DcMotorEx) hwap.dcMotor.get("in2");
        motorOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void intakeOut(boolean in, boolean out) {
        if(in) {move(IN_POSITION);}
        if(out){move(OUT_POSITION);}

    }

private void move(int position) {
        motorOne.setTargetPosition(position);
        motorTwo.setTargetPosition(position);
        motorOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorTwo.setMode(DcMotor.RunMode.RUN_TO_POSITION);

}

}
