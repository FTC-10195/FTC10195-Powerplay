package org.firstinspires.ftc.teamcode.Subsystems.Intake;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;


public class Intake {

Claw claw = new Claw(hardwareMap);
VirtualFourBar bar = new VirtualFourBar(hardwareMap);

public enum intakeState {
    OUT,
    IN
    }







}

