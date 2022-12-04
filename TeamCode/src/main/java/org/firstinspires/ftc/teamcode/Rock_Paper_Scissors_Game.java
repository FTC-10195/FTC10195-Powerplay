package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Rock_Paper_Scissors_Game extends OpMode {

    long player1Score = 0;

    long player2Score = 0;

    boolean previousRightBumper = gamepad1.right_bumper;



    @Override
    public void init() {

        telemetry.addLine("Welcome to Rock Paper Scissors!\n\nControls:\n\nPlayer 1:\nRock = Right Pad\nPaper = Left Pad\nScissors = Down Pad\n\nPlayer Two: Rock = X\nPaper = B\nScissors = A\n\nHow to Play:\n\n1. Have Player 1 place their left hand on the left side of the controller and Player 2 place their right hand on the right side of the controller.\n2. At the time final decision, make your choices at the same time\n3. Press the Stop button when your finished playing.\n\nRules:\n\n1. Both players must keep their eyes and hand on thier side of the shared controller which should be evenly shared\n2. Both players must make their choice by the time of final decision\n\n Press the Start button to play and good luck!");
    }
        public void loop() {

            if(gamepad1.dpad_right && gamepad1.x) {

                telemetry.addData("Player One Selection", "Rock");
                telemetry.addData("Player Two Selection", "Rock");
                telemetry.addLine("Tie!");
            }
        }
    }
