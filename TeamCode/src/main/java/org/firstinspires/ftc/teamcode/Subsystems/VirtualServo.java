package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


public class VirtualServo {

    public CRServoImplEx rollerServo;
    public final double rotateServoTime = 0;
    public final double Rotate_Servo = 1;
    ElapsedTime timer = new ElapsedTime();


    public VirtualServo(HardwareMap hwmap) {
        rollerServo = hwmap.get(CRServoImplEx.class, "rollerServo");
    }

    //TODO CHANGE THESE VALUES TO BE BETTER
    public void rollerRotate(boolean a) {
        rollerServo.setPower(1);
        timer.startTime();
      double elapsedTime =  timer.seconds();
        if(elapsedTime > 1)
            rollerServo.setPower(0);
    }


}