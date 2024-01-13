package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.SpikeDetectionPipeline;
import org.firstinspires.ftc.teamcode.robotHardware;

import java.util.concurrent.ScheduledThreadPoolExecutor;

@Autonomous(name = "AdeelAuto", group = "Autonomous")
public class AdeelAuto extends LinearOpMode {

    robotHardware robot = new robotHardware(this);
//    LINE 1
    SpikeDetectionPipeline pipeline = new SpikeDetectionPipeline();

    @Override
    public void runOpMode(){
//        LINE 2
        robot.initOpenCV(pipeline);
        robot.init();
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("Position:", pipeline.getSpikePosition());
            telemetry.update();
        }
    }
}
