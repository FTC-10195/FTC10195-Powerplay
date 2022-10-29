package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Claw {

    public Servo clawServo;


    public Claw(HardwareMap hwmap) {
        clawServo = hwmap.get(Servo.class, "clawServo");
    }
    //TODO CHANGE THESE VALUES TO BE BETTER
    public final double OPEN_CLAW = .6;
    public final double CLOSED_CLAW = .80;
    public void intake(boolean openButton, boolean closedButton) {

            if(openButton) {
                clawServo.setPosition(OPEN_CLAW);
            }

            if(closedButton) {
                clawServo.setPosition(CLOSED_CLAW);
            }
        }


    }
