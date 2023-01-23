package org.firstinspires.ftc.teamcode.Subsystems.Outtake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class OuttakeSlides {
    DcMotorEx slide;
    DcMotorEx slide1;
    public final int MAX_VAL = 7000;
    public final int LOW = 400;
    public final int MEDIUM = 4000;
    public final int HIGH = 6000;
    public final int ZERO = 0;
    public int currentPosition =0;


    public OuttakeSlides(HardwareMap map) {
        slide = map.get(DcMotorEx.class, "ls");
        slide1 = map.get(DcMotorEx.class, "ls1");
        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public enum STATES {
        ENCODER,
        MANUAL,
    }

    public STATES slideState = STATES.MANUAL;

    public void move(boolean low, boolean mid, boolean high, boolean zero, boolean down, boolean up) {
            switch(slideState) {
                case MANUAL:
                    if (down) {
                        slide.setPower(-.4);
                        slide1.setPower(.4);
                    } else if (up) {
                        slide.setPower(.4);
                        slide1.setPower(-.4);
                    } else {
                        slide.setPower(0);
                        slide1.setPower(0);
                    }
                    if (slide.getCurrentPosition() > MAX_VAL) {
                        slide.setPower(-.1);
                        slide1.setPower(-.1);
                    }

                    if (low || mid || high || zero) {
                        slideState = slideState.ENCODER;
                    }
                case ENCODER:
                    slideMovement(high, low, mid, zero);
                    if (down || up) {
                        slideState = slideState.MANUAL;
                    }
            }




        }

    private  void slideMovement(boolean up, boolean down, boolean left, boolean right) {

            if (up) {
                position(HIGH);
            }
            if (right) {
                position(MEDIUM);
            }
            if (left) {
                position(LOW);



            }
            //to test function only
            if (down) {
                position(ZERO);
            }



        }

    private void position(int pole) {

        slide.setTargetPosition(pole);
        slide1.setTargetPosition(pole);


        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slide1.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        slide.setPower(1);
        slide1.setPower(1);


        slide.setTargetPositionTolerance(25);
        slide1.setTargetPositionTolerance(25);

        currentPosition = slide.getCurrentPosition();
        int currentPosition2 = slide1.getCurrentPosition();

        if (currentPosition <= pole) {
         //   resetSlides();
            slide.setPower(0);
            slide1.setPower(0);
        }

    }
    private void resetSlides() {
        slide.setTargetPosition(0);
        slide.setPower(1);
    }


}



