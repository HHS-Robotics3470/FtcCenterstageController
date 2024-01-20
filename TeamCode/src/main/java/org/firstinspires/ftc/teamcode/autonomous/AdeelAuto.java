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

            telemetry.addData("Red submat 0:", pipeline.redValueSubmat0);
            telemetry.addData("Green submat 0:", pipeline.greenValueSubmat0);
            telemetry.addData("Blue submat 0:", pipeline.blueValueSubmat0);

            telemetry.addData("Red submat 1:", pipeline.redValueSubmat1);
            telemetry.addData("Green submat 1:", pipeline.greenValueSubmat1);
            telemetry.addData("Blue submat 1:", pipeline.blueValueSubmat1);

            telemetry.addData("Red submat 2:", pipeline.redValueSubmat2);
            telemetry.addData("Green submat 2:", pipeline.greenValueSubmat2);
            telemetry.addData("Blue submat 2:", pipeline.blueValueSubmat2);
            telemetry.update();
        }
    }
}
