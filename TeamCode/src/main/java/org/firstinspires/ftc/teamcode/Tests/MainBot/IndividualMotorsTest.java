package org.firstinspires.ftc.teamcode.Tests.MainBot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDrive;





@TeleOp
public class IndividualMotorsTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive dt = new MecanumDrive(hardwareMap, telemetry);
        waitForStart();
            while (opModeIsActive()) {
                telemetry.addLine("Press play to begin the debugging opmode");
                telemetry.update();
                waitForStart();
                if (isStopRequested()) return;
                telemetry.clearAll();
                telemetry.setDisplayFormat(Telemetry.DisplayFormat.HTML);
                while (!isStopRequested()) {
                    telemetry.addLine("Press each button to turn on its respective motor");
                    telemetry.addLine();
                    telemetry.addLine("<font face=\"monospace\">Xbox/PS4 Button - Motor</font>");
                    telemetry.addLine("<font face=\"monospace\">&nbsp;&nbsp;X / ▢&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front Left</font>");
                    telemetry.addLine("<font face=\"monospace\">&nbsp;&nbsp;Y / Δ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Front Right</font>");
                    telemetry.addLine("<font face=\"monospace\">&nbsp;&nbsp;B / O&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Rear&nbsp;&nbsp;Right</font>");
                    telemetry.addLine("<font face=\"monospace\">&nbsp;&nbsp;A / X&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Rear&nbsp;&nbsp;Left</font>");
                    telemetry.addLine();

                    if(gamepad1.x) {
                        dt.motorFrontLeft.setPower(.3);
                        dt.motorFrontRight.setPower(0);
                        dt.motorBackRight.setPower(0);
                        dt.motorBackLeft.setPower(0);
                        telemetry.addLine("Running Motor: Front Left");
                    } else if(gamepad1.y) {
                        dt.motorFrontRight.setPower(.3);
                        dt.motorFrontLeft.setPower(0);
                        dt.motorBackRight.setPower(0);
                        dt.motorBackLeft.setPower(0);

                        telemetry.addLine("Running Motor: Front Right");
                    } else if(gamepad1.b) {
                        dt.motorBackRight.setPower(.3);
                        dt.motorFrontLeft.setPower(0);
                        dt.motorFrontRight.setPower(0);
                        dt.motorBackLeft.setPower(0);

                        telemetry.addLine("Running Motor: Rear Right");

                    } else if(gamepad1.a) {
                        dt.motorBackLeft.setPower(.3);
                        dt.motorFrontLeft.setPower(0);
                        dt.motorFrontRight.setPower(0);
                        dt.motorBackRight.setPower(0);
                        telemetry.addLine("Running Motor: Rear Left");
                    } else {
                        dt.motorFrontLeft.setPower(0);
                        dt.motorFrontRight.setPower(0);
                        dt.motorBackRight.setPower(0);
                        dt.motorBackLeft.setPower(0);
                        telemetry.addLine("Running Motor: None");
                    }

                    telemetry.update();
                }

            }
        }
    }

