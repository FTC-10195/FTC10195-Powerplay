package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

public class clawServo {
    public final double OPEN_CLAW = .8;
    public final double CLOSED_CLAW = .60;

    public void claw(boolean buttonPressed) {
        Servo clawServo = hardwareMap.servo.get("claw");
            if(gamepad2.a) {
                clawServo.setPosition(OPEN_CLAW);
            }

            if(gamepad2.x) {
                clawServo.setPosition(CLOSED_CLAW);
            }
        }


    }

