package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robotHardware;
public class Autonomus extends LinearOpMode{
    robotHardware robot = new robotHardware(this);

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();

        waitForStart();
        if (opModeIsActive()) {
            telemetry.addData("Status", "Tiiiiimothyyyy, I'm determining signal");
            telemetry.update();
            telemetry.addData("Status", "Yo Timbits, target zone determined");
            telemetry.addData("Status", "Timmy watch me! I'm playing the pre-recorded sequence");
            telemetry.update();
//                INSERT RECORDED MOVEMENTS HERE

//                STOP RECORDED MOVEMENTS
            robot.resetEncoders();
        }
        stop();
    }
}
